package erwin.springbootwebapp.Controller;

import erwin.springbootwebapp.Entity.Posts;
import erwin.springbootwebapp.Exception.UserNotFoundException;
import erwin.springbootwebapp.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts") // Setting a base path for consistency and easier management
public class PostsController {
    private final PostService postService;
    @Autowired
    PostsController(PostService postService) {
        this.postService = postService;
    }
    @PostMapping
    public ResponseEntity<String> save(@RequestBody Posts posts) {
        postService.save(posts);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Posts>> getAll() {
        return new ResponseEntity<>(postService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<String> getById(@PathVariable Long id) {
        Optional<Posts> posts = postService.findById(id);
        return posts.map(value -> new ResponseEntity<>(value.toString(), HttpStatus.OK))
                .orElseThrow(() -> new UserNotFoundException(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        Optional<Posts> posts=postService.findById(id);
        if(posts.isPresent()) {
            postService.deleteById(id);
            return new ResponseEntity<>( HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
