package com.orginizer.OMe.repos;

import com.orginizer.OMe.entities.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MeetingRepo extends JpaRepository<Meeting, Long> {
    Meeting findByMeetingName(String meetingName);
    Meeting findByMeetingId(Long id);
    int deleteMeetingByMeetingName(String meetingName);

    @Query("SELECT m FROM Meeting m WHERE "
            + "(m.meetingStart < :newMeetingFinish AND m.meetingFinish > :newMeetingStart)")
    List<Meeting> findOverlappingMeetings(
            @Param("newMeetingStart") LocalDateTime newMeetingStart,
            @Param("newMeetingFinish") LocalDateTime newMeetingFinish);
}
