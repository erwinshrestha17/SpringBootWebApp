package erwin.springbootwebapp.Repository.CategoryRepository;


import erwin.springbootwebapp.Entity.CategoryEntity.Types;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypesRepository extends JpaRepository<Types,Integer> { }


