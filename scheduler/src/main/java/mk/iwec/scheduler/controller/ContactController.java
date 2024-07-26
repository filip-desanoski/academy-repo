package mk.iwec.scheduler.controller;

import mk.iwec.scheduler.model.Contact;
import mk.iwec.scheduler.repository.ContactRepository;
import mk.iwec.scheduler.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contacts")
public class ContactController {

    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping(produces = "application/json")
    @ResponseBody
    public List<Contact> getAllContacts() {
        return contactService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Contact> getContactById(@PathVariable (value = "id") Integer id) {
        Contact contact = contactService.findById(id);
        HttpStatus status = contact != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(contact, status);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer save(@RequestBody Contact contact) {
        return contactService.save(contact).getId();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Integer update(@RequestBody Contact contact) {
        return contactService.update(contact).getId();
    }

    @DeleteMapping(value = "/{id}")
    public HttpStatus delete(@PathVariable(value = "id") Integer id) {
        boolean isDeleted = contactService.delete(id);
        return isDeleted ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    }
}
