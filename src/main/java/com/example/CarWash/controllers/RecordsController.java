package com.example.CarWash.controllers;

import com.example.CarWash.Mapper.RecordsMapper;
import com.example.CarWash.Mapper.UserMapper;
import com.example.CarWash.dto.RecordsDto;
import com.example.CarWash.dto.UserDto;
import com.example.CarWash.models.Records;
import com.example.CarWash.models.User;
import com.example.CarWash.repository.RecordsRepository;
import com.example.CarWash.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class RecordsController {
    private final RecordsMapper recordsMapper;
    private final RecordsRepository recordsRepository;
    private final UserService userService;

    @GetMapping("recordsAll")
    public List<RecordsDto> getRecords() {
        try {
            return recordsRepository.findAll().stream().map(el->recordsMapper.toDTOList(el)).collect(Collectors.toList());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong", e);
        }
    }

    @PostMapping(value = "records/{id}")
    public String createMessage(@RequestBody Records records, @PathVariable("id") Long id) {
        try {
            recordsRepository.save(new Records(records.getTime(),records.getDate(), userService.findById(id).get(),records.getService()));
            return "Вы записались";
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong", e);
        }
    }

}
