package erwin.springbootwebapp.Service;

import erwin.springbootwebapp.Entity.Posts;
import erwin.springbootwebapp.Repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    PostsRepository postsRepository;
    @Autowired
    public PostService(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }

    public void save(Posts posts) {postsRepository.save(posts);}
    public void deleteById(Long id) {postsRepository.deleteById(id);}
    public List<Posts> findAll() {return postsRepository.findAll();}
    public Optional<Posts> findById(Long id) {return postsRepository.findById(id);}

}
