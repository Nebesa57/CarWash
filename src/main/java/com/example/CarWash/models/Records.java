package com.example.CarWash.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Records {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String service;
    @JoinColumn(name = "time_record")
    private String startTime;
    private String endTime;
    private String duration;
    @JoinColumn(name = "date_record")
    private String date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Records(String service, String startTime, String endTime, String duration, String date, User user) {
        this.service = service;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
        this.date = date;
        this.user = user;
    }
}
