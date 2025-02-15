package erwin.springbootwebapp.Controller;

import erwin.springbootwebapp.Entity.Products;
import erwin.springbootwebapp.Service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products") // Setting a base path for consistency and easier management
public class ProductsController {
    private final ProductsService productsService;

    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Products products) {


        productsService.save(products);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Products>> getAll() {
        List<Products> products = productsService.findAll();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Products> findById(@PathVariable int id) {
        Optional<Products> product = productsService.findById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id) {
        Optional<Products> product = productsService.findById(id);
        if (product.isPresent()) {
            productsService.deleteById((long) id);
            return new ResponseEntity<>( HttpStatus.OK);
        } else {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
    }
}
