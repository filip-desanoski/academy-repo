package mk.iwec.scheduler.controller;

import mk.iwec.scheduler.model.Meeting;
import mk.iwec.scheduler.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/meetings")
public class MeetingController {

    private final MeetingService meetingService;

    @Autowired
    public MeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @GetMapping(produces = "application/json")
    @ResponseBody
    public List<Meeting> findAllMeetings() {
        return meetingService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Meeting> findMeetingById(@PathVariable(value = "id") Integer id) {
        Meeting meeting = meetingService.findById(id);
        HttpStatus status = meeting != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(meeting, status);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer save(@RequestBody Meeting meeting) {
        return meetingService.save(meeting).getId();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Integer update(@RequestBody Meeting meeting) {
        return meetingService.update(meeting).getId();
    }

    @DeleteMapping(value = "/{id}")
    public HttpStatus delete(@PathVariable(value = "id") Integer id) {
        boolean isDeleted = meetingService.delete(id);
        return isDeleted ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    }
}
