package erwin.springbootwebapp.Service;

import erwin.springbootwebapp.Entity.Products;
import erwin.springbootwebapp.Repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {
    ProductsRepository productsRepository;
    @Autowired
    public ProductsService(ProductsRepository productsRepository) {this.productsRepository = productsRepository;}

    public List<Products> findAll() {return productsRepository.findAll();}
    public void save(Products product) {productsRepository.save(product);}
    public Optional<Products> findById(int id) {return productsRepository.findById(id);}
    public void deleteById(Long id) {productsRepository.deleteById(Math.toIntExact(id));}

}
