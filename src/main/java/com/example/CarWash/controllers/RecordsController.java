package com.example.CarWash.controllers;

import com.example.CarWash.Mapper.RecordsMapper;
import com.example.CarWash.Mapper.UserMapper;
import com.example.CarWash.dto.RecordsDto;
import com.example.CarWash.dto.UserDto;
import com.example.CarWash.models.Records;
import com.example.CarWash.models.User;
import com.example.CarWash.repository.RecordsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping("recordsAll")
    public List<RecordsDto> getRecords() {
        try {
            return recordsRepository.findAll().stream().map(el->recordsMapper.toDTOList(el)).collect(Collectors.toList());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong", e);
        }
    }

}
