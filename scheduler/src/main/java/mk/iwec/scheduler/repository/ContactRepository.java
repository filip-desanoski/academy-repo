package mk.iwec.scheduler.repository;

import mk.iwec.scheduler.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
