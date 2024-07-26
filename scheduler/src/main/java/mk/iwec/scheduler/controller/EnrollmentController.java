package mk.iwec.scheduler.controller;

import mk.iwec.scheduler.model.Contact;
import mk.iwec.scheduler.model.Enrollment;
import mk.iwec.scheduler.repository.EnrollmentRepository;
import mk.iwec.scheduler.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @Autowired
    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @GetMapping(produces = "application/json")
    @ResponseBody
    public List<Enrollment> findAllEnrollments() {
        return enrollmentService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Enrollment> findEnrollmentById(@PathVariable (value = "id") Integer id) {
        Enrollment enrollment = enrollmentService.findById(id);
        HttpStatus status = enrollment != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(enrollment, status);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer save(@RequestBody Enrollment enrollment) {
        return enrollmentService.save(enrollment).getId();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Integer update(@RequestBody Enrollment enrollment) {
        return enrollmentService.update(enrollment).getId();
    }

    @DeleteMapping(value = "/{id}")
    public HttpStatus delete(@PathVariable(value = "id") Integer id) {
        boolean isDeleted = enrollmentService.delete(id);
        return isDeleted ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    }
}
