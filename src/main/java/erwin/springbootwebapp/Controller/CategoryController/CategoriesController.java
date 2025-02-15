package erwin.springbootwebapp.Controller.CategoryController;

import erwin.springbootwebapp.Entity.CategoryEntity.Categories;
import erwin.springbootwebapp.Service.CategoryService.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/categories")
public class CategoriesController {
    private final CategoriesService categoriesService;
    @Autowired
    public CategoriesController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @GetMapping
    public ResponseEntity<List<Categories>> findAll() {
        return new ResponseEntity<>(categoriesService.findAll(),HttpStatus.OK);
    }

   @GetMapping("/{id}")
   public ResponseEntity<Categories> findById(@PathVariable Long id) {
        Optional<Categories> categories = categoriesService.findById(id);
       return categories.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
   }
    @PostMapping
    public ResponseEntity<String> save(@RequestBody Categories categories) {
        categoriesService.save(categories);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        categoriesService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/saveAll")
    public ResponseEntity<String> saveAll(@RequestBody Categories[] categories) {
        // Assuming saveAll method saves multiple categories
        categoriesService.saveAll(List.of(categories));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
