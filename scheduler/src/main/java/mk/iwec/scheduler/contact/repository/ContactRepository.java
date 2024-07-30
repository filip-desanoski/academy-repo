package mk.iwec.scheduler.contact.repository;

import mk.iwec.scheduler.contact.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
