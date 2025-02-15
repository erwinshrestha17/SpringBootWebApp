package erwin.springbootwebapp.Controller.CategoryController;

import erwin.springbootwebapp.Entity.CategoryEntity.Types;
import erwin.springbootwebapp.Service.CategoryService.TypesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/types")
public class TypesController {
    private final TypesService typesService;
    public TypesController(TypesService typesService) {
        this.typesService = typesService;
    }

    @PostMapping("/saveAll")
    public ResponseEntity<String> saveAll(@RequestBody Types[] types){
        this.typesService.saveAll(List.of(types));
        return  new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PostMapping
    public ResponseEntity<String> save(@RequestBody Types type){
        this.typesService.save(type);
        return  new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<String> getAll(){
        this.typesService.findAll();
        return  new ResponseEntity<>(HttpStatus.OK);
    }



}
