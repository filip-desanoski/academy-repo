package mk.iwec.scheduler.controller;

import mk.iwec.scheduler.model.Image;
import mk.iwec.scheduler.model.Meeting;
import mk.iwec.scheduler.model.Training;
import mk.iwec.scheduler.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/trainings")
public class TrainingController {

    private final TrainingService trainingService;

    @Autowired
    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @GetMapping(produces = "application/json")
    @ResponseBody
    public List<Training> findAllTrainings() {
        return trainingService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Training> findTrainingById(@PathVariable(value = "id") Integer id) {
        Training training = trainingService.findById(id);
        HttpStatus status = training != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(training, status);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer save(@RequestBody Training training) {
        return trainingService.save(training).getId();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Integer update(@RequestBody Training training) {
        return trainingService.update(training).getId();
    }

    @DeleteMapping(value = "/{id}")
    public HttpStatus delete(@PathVariable(value = "id") Integer id) {
        boolean isDeleted = trainingService.delete(id);
        return isDeleted ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    }
}
