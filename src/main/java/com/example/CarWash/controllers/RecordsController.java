package com.example.CarWash.controllers;

import com.example.CarWash.Mapper.RecordsMapper;
import com.example.CarWash.Mapper.RecordsMapperTime;
import com.example.CarWash.dto.RecordsDto;
import com.example.CarWash.dto.RecordsDtoTime;
import com.example.CarWash.models.Records;
import com.example.CarWash.repository.RecordsRepository;
import com.example.CarWash.service.RecordsService;
import com.example.CarWash.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class RecordsController {
    private final RecordsMapperTime recordsMapperTime;
    private final RecordsMapper recordsMapper;
    private final RecordsRepository recordsRepository;
    private final UserService userService;
    private final RecordsService recordsService;

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
        ArrayList<Integer> TimeOfRecords= new ArrayList<>();
        int start = Integer.parseInt(records.getStartTime());
        int durat = Integer.parseInt(records.getDuration());
        for(int a = 0; a<durat; a++){
            TimeOfRecords.add(start);
            start++;
        }
        List<Records> arrayList = new ArrayList<>();
        ArrayList<Integer> TimeError = new ArrayList<>();
        for(int a = 20; a<=23; a++){
            TimeError.add(a);
        }
        recordsRepository.findAll().forEach(arrayList::add);
        for(Records arrayList1:arrayList) {
            if(records.getDate().equals(arrayList1.getDate())){
                int StartTime = Integer.parseInt(arrayList1.getStartTime());
                int DuringTime = Integer.parseInt(arrayList1.getDuration());
                for(int a=0; a<DuringTime;a++){
                    TimeError.add(StartTime);
                    StartTime++;
                }
            }
        }
        for(int a = 0; a<TimeOfRecords.size(); a++){
            for (int b = 0 ; b<TimeError.size(); b++){
                if(TimeOfRecords.get(a)==TimeError.get(b)){
                    return "Время занято";
                }
            }
        }
        try {
            recordsRepository.save(new Records(records.getService(),records.getStartTime(),records.getEndTime(),records.getDuration(),records.getDate(),userService.findById(id).get()));
            return "Вы записались";
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong", e);
        }
    }

    @DeleteMapping(value = "deleteRecords/{id}")
        public String deleteRecords( @PathVariable("id") Long id){
        try {
            recordsRepository.deleteById(id);
            return "Запись удалена";
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong", e);
        }
    }


    @GetMapping("recordsTime")
    public List<Integer> getTime(@RequestParam String date){
        List<Records> arrayList = new ArrayList<>();
        List<Integer> allTime = new ArrayList<>();
        for(int a = 8 ; a<=18; a++){
            allTime.add(a);
        }
        recordsRepository.findAll().forEach(arrayList::add);

        for(Records arrayList1:arrayList){
            if(arrayList1.getDate().equals(date)) {
                int stTime = Integer.parseInt(arrayList1.getStartTime());
                int dur = Integer.parseInt(arrayList1.getDuration());
                for (int a = 0; a < dur; a++) {
                   int numberIndex = allTime.indexOf(stTime);
                   allTime.remove(numberIndex);
                    stTime++;
                }
            }
        }
         return allTime;

    }

}
