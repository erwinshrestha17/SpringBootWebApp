package erwin.springbootwebapp.Controller;

import erwin.springbootwebapp.Entity.Posts;
import erwin.springbootwebapp.Entity.Users;
import erwin.springbootwebapp.Exception.UserNotFoundException;
import erwin.springbootwebapp.Repository.PostsRepository;
import erwin.springbootwebapp.Repository.UsersRepository;
import erwin.springbootwebapp.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users") // Setting a base path for consistency and easier management
public class UsersController {
    private final UsersService usersService;
    private final PostsRepository postsRepository;
    private final UsersRepository usersRepository;

    @Autowired
    public UsersController(UsersService usersService, PostsRepository postsRepository, UsersRepository usersRepository) {
        this.usersService = usersService;
        this.postsRepository = postsRepository;
        this.usersRepository = usersRepository;
    }
    @PostMapping
    public ResponseEntity<String> save(@RequestBody Users users) {
        if (usersRepository.existsByEmail(users.getEmail())){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }else {
            usersService.save(users);
            return new ResponseEntity<>( HttpStatus.CREATED);
        }
    }
    @GetMapping
    public ResponseEntity<List<Users>> getAll() {
        return new ResponseEntity<>(usersService.findAll(), HttpStatus.OK);

    }
    @GetMapping("/{id}")
    public ResponseEntity<String> getById(@PathVariable Long id) {
        Optional<Users> users = usersService.findById(id);
        return users.map(value -> new ResponseEntity<>(value.toString(), HttpStatus.OK))
                .orElseThrow(()-> new UserNotFoundException(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        Optional<Users> users=usersService.findById(id);
        if(users.isPresent()) {
            usersService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateById(@PathVariable Long id, @RequestBody Users users) {
        Optional<Users> user = usersService.findById(id);
        if (user.isPresent()) {
            usersService.save(users);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}/posts")
    public ResponseEntity<?> GetUserPostsById(@PathVariable Long id) {
        Optional<Users> users = usersService.findById(id);
        if (users.isEmpty()) {
            throw new UserNotFoundException(id);
        } else {
            List<Posts> posts = users.get().getPosts();  // Assuming getPosts() returns a List<Post>
            if (posts.isEmpty()) {
                return ResponseEntity.noContent().build();  // Return 204 No Content if no posts
            } else {
                return ResponseEntity.ok(posts);  // Return 200 OK with the list of posts
            }
        }
    }

    @PostMapping("{id}/posts")
    public ResponseEntity<String> SavePostsByUserId(@PathVariable Long id, @RequestBody Posts posts) {
        Optional<Users> users = usersService.findById(id);
        if (users.isEmpty()) {
            throw new UserNotFoundException(id);
        }
        posts.setUsers(users.get());
        postsRepository.save(posts);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
