package erwin.springbootwebapp.Service;

import erwin.springbootwebapp.Entity.Users;
import erwin.springbootwebapp.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    UsersRepository usersRepository;
    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
    public void save(Users users) {usersRepository.save(users);}
    public void deleteById(Long id) {usersRepository.deleteById(id);}
    public List<Users> findAll() {return usersRepository.findAll();}
    public Optional<Users> findById(Long id) {return usersRepository.findById(id);}

}
