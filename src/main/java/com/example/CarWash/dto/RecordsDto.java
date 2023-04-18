package com.example.CarWash.dto;

import lombok.Data;

@Data
public class RecordsDto {
    private UserDto userDto;
    private Long id;
    private String service;
    private String date;
    private String startTime;
    private String endTime;
}
