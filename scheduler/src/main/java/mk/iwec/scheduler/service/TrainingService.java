package mk.iwec.scheduler.service;

import mk.iwec.scheduler.model.Training;
import mk.iwec.scheduler.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingService {

    private final TrainingRepository trainingRepository;

    @Autowired
    public TrainingService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    public List<Training> findAll() {
        return trainingRepository.findAll();
    }

    public Training findById(Integer id) {
        return trainingRepository.findById(id).orElse(null);
    }

    public Training save(Training training) {
        return trainingRepository.save(training);
    }

    public Training update(Training training) {
        if (trainingRepository.existsById(training.getId())) {
            return trainingRepository.save(training);
        }
        return null;
    }

    public boolean delete(Integer id) {
        if (trainingRepository.existsById(id)) {
            trainingRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
