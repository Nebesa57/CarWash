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
    private String time;
    @JoinColumn(name = "date_record")
    private String date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public Records(String time, String date, User user, String service) {
        this.time = time;
        this.service = service;
        this.date = date;
        this.user = user;
    }

}
