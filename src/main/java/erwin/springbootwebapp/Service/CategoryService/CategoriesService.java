package erwin.springbootwebapp.Service.CategoryService;



import erwin.springbootwebapp.Entity.CategoryEntity.Categories;
import erwin.springbootwebapp.Repository.CategoryRepository.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriesService {
    CategoriesRepository categoriesRepository;

    @Autowired
    public CategoriesService(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    // Return List of Categories, not CategoriesRepository
    public List<Categories> findAll() {return this.categoriesRepository.findAll();}
    public List<Categories> findByCategoryName(String categoryName) {
        return this.categoriesRepository.findByCategoryName(categoryName);
    }
    // Save a Category,
    public void save(Categories categories) {categoriesRepository.save(categories);}
    // Delete by id, the id is of type Long
    public void deleteById(Long id) {this.categoriesRepository.deleteById(id);}
    // Find by id, the return type is Optional<Categories>
    public Optional<Categories> findById(Long id) {return this.categoriesRepository.findById(id);}
    public void saveAll(List<Categories> categories) {
        this.categoriesRepository.saveAll(categories);
    }



}
