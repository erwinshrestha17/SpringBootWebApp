package erwin.springbootwebapp.Repository;

import erwin.springbootwebapp.Entity.Products;
import graphql.com.google.common.base.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, Integer> {

}
