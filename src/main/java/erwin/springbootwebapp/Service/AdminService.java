package erwin.springbootwebapp.Service;

import erwin.springbootwebapp.Entity.Admin;
import erwin.springbootwebapp.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    AdminRepository adminRepository;
    @Autowired
    public AdminService(AdminRepository adminRepository) {this.adminRepository = adminRepository;}

    public void save(Admin admin) {adminRepository.save(admin);}
    public void deleteById(Long id) {adminRepository.deleteById(id);}
    public void getAll(){adminRepository.findAll();}

}
