package com.example.CarWash.Mapper;

import com.example.CarWash.dto.RecordsDtoTime;
import com.example.CarWash.models.Records;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RecordsMapperTime {
    RecordsMapperTime INSTANCE = Mappers.getMapper(RecordsMapperTime.class);
    RecordsDtoTime toDTO(Records records);
}
