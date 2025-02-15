package erwin.springbootwebapp.Repository;

import erwin.springbootwebapp.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Long> {
}
