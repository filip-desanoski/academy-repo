package mk.iwec.scheduler.service;

import mk.iwec.scheduler.model.Meeting;
import mk.iwec.scheduler.repository.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingService {

    private final MeetingRepository meetingRepository;

    @Autowired
    public MeetingService(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    public List<Meeting> findAll() {
        return meetingRepository.findAll();
    }

    public Meeting findById(Integer id) {
        return meetingRepository.findById(id).orElse(null);
    }

    public Meeting save(Meeting meeting) {
        return meetingRepository.save(meeting);
    }

    public Meeting update(Meeting meeting) {
        if (meetingRepository.existsById(meeting.getId())) {
            return meetingRepository.save(meeting);
        }
        return null;
    }

    public boolean delete(Integer id) {
        if (meetingRepository.existsById(id)) {
            meetingRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
