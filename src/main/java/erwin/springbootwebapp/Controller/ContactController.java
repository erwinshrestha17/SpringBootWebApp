package erwin.springbootwebapp.Controller;


import erwin.springbootwebapp.Entity.Contact;
import erwin.springbootwebapp.Service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contact")
public class ContactController {
    ContactService contactService;
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public ResponseEntity<String> getAll() {
        this.contactService.getAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> save(@RequestBody Contact contact) {
        this.contactService.save(contact);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        this.contactService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
