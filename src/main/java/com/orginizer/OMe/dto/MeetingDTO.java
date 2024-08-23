package com.orginizer.OMe.dto;

import com.orginizer.OMe.entities.Meeting;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class MeetingDTO {
    private Long meetingId;
    private String meetingName;
    private LocalDateTime  meetingStart;
    private LocalDateTime meetingFinish;
    public static MeetingDTO fromEntity(Meeting meeting) {
        MeetingDTO meetingDTO = new MeetingDTO();
        meetingDTO.setMeetingId(meeting.getMeetingId());
        meetingDTO.setMeetingName(meeting.getMeetingName());
        meetingDTO.setMeetingStart(meeting.getMeetingStart());
        meetingDTO.setMeetingFinish(meeting.getMeetingFinish());
        return meetingDTO;
    }

    public static Meeting fromDTO(MeetingDTO meetingDTO) {
        Meeting meeting = new Meeting();
        meeting.setMeetingId(meetingDTO.getMeetingId());
        meeting.setMeetingName(meetingDTO.getMeetingName());
        meeting.setMeetingStart(meetingDTO.getMeetingStart());
        meeting.setMeetingFinish(meetingDTO.getMeetingFinish());
        return meeting;
    }
}
