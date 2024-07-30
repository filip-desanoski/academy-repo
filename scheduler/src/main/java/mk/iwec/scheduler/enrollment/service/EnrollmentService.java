package mk.iwec.scheduler.enrollment.service;

import mk.iwec.scheduler.enrollment.model.Enrollment;
import mk.iwec.scheduler.enrollment.repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    @Autowired
    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    public List<Enrollment> findAll() {
        return enrollmentRepository.findAll();
    }

    public Enrollment findById(Integer id) {
        return enrollmentRepository.findById(id).orElse(null);
    }

    public Enrollment save(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    public Enrollment update(Enrollment enrollment) {
        if (enrollmentRepository.existsById(enrollment.getId())) {
            return enrollmentRepository.save(enrollment);
        }
        return null;
    }

    public boolean delete(Integer id) {
        if (enrollmentRepository.existsById(id)) {
            enrollmentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
