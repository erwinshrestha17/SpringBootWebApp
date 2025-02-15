package erwin.springbootwebapp.Repository.CategoryRepository;

import erwin.springbootwebapp.Entity.CategoryEntity.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories,Long> {

    List<Categories> findByCategoryName(String categoryName);
}
