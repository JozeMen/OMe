package com.orginizer.OMe.services;

import com.orginizer.OMe.dto.MeetingDTO;
import com.orginizer.OMe.entities.Meeting;
import com.orginizer.OMe.repos.MeetingRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingService {
    @Autowired
    private MeetingRepo meetingRepo;

    public List<Meeting> getAllMeetings() {
        return meetingRepo.findAll();
    }

    public boolean createMeeting(MeetingDTO meetingDTO) {
        Meeting meeting = MeetingDTO.fromDTO(meetingDTO);

        List<Meeting> overlappingMeetings = meetingRepo.findOverlappingMeetings(
                meeting.getMeetingStart(), meeting.getMeetingFinish());

        if (!overlappingMeetings.isEmpty() ) {
            return false;
        }
        meetingRepo.save(meeting);
        return true;
    }

    @Transactional
    public int deleteMeetingByName(String name) {
        Meeting meeting = meetingRepo.findByMeetingName(name);
        return meetingRepo.deleteMeetingByMeetingName(name);
    }

    @Transactional
    public boolean updateMeeting(Long id, MeetingDTO meetingDTO) {
        Meeting existingMeeting = meetingRepo.findByMeetingId(id);
        if (existingMeeting != null) {
            existingMeeting.setMeetingName(meetingDTO.getMeetingName());
            existingMeeting.setMeetingStart(meetingDTO.getMeetingStart());
            existingMeeting.setMeetingFinish(meetingDTO.getMeetingFinish());
            meetingRepo.save(existingMeeting);
            return true;
        } else {
            return false;
        }
    }
}
