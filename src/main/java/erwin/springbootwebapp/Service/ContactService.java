package erwin.springbootwebapp.Service;

import erwin.springbootwebapp.Entity.Contact;
import erwin.springbootwebapp.Repository.ContactRepository;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    ContactRepository contactRepository;
    public ContactService(ContactRepository contactRepository) {this.contactRepository = contactRepository;}

    public void save(Contact contact) {contactRepository.save(contact);}
    public void deleteById(Long id) {contactRepository.deleteById(id);}
    public void getAll(){contactRepository.findAll();}



}
