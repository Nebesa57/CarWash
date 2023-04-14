package com.example.CarWash.service;

import com.example.CarWash.models.Records;
import com.example.CarWash.repository.RecordsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecordsService {
    private final RecordsRepository recordsRepository;
    public Optional<Records> findAllByDate(String Date) {
        return recordsRepository.findAllByDate(Date);
    }
}
