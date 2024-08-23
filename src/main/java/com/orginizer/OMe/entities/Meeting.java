package com.orginizer.OMe.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "meetings", schema = "public")
@Getter
@Setter
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long meetingId;

    private String meetingName;
    private LocalDateTime meetingStart;
    private LocalDateTime  meetingFinish;

}
