package erwin.springbootwebapp.Controller;

import erwin.springbootwebapp.Entity.Admin;
import erwin.springbootwebapp.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    AdminService adminService;
    @Autowired
    AdminController(AdminService adminService) {this.adminService = adminService;}


    @PostMapping
    public ResponseEntity<String> save(@RequestBody Admin admin) {
        adminService.save(admin);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<String> getAll() {
        adminService.getAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
