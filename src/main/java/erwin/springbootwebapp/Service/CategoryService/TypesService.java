package erwin.springbootwebapp.Service.CategoryService;

import erwin.springbootwebapp.Entity.CategoryEntity.Types;
import erwin.springbootwebapp.Repository.CategoryRepository.TypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypesService {
    private final TypesRepository typesRepository;
    @Autowired
    public TypesService(TypesRepository typesRepository) {this.typesRepository = typesRepository;}

    public void save(Types type) {this.typesRepository.save(type);}
    public void saveAll(List<Types> types) {this.typesRepository.saveAll(types);}
    public List<Types> findAll() {return this.typesRepository.findAll();}
    public void deleteById(Integer id) {this.typesRepository.deleteById(id);}
    public Types findById(Integer id) {return this.typesRepository.findById(id).get();}
    public void deleteAll() {this.typesRepository.deleteAll();}
}
