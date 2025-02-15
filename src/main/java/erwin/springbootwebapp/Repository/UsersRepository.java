package erwin.springbootwebapp.Repository;

import erwin.springbootwebapp.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    boolean existsByEmail(String email);
    //Users findByUsername(String username);
}
