package erwin.springbootwebapp.Repository;

import erwin.springbootwebapp.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    //Users findByUsername(String username);
}
