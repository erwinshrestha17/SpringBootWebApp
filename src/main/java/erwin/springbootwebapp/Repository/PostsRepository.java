package erwin.springbootwebapp.Repository;

import erwin.springbootwebapp.Entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
