package com.example.CarWash.Mapper;

import com.example.CarWash.dto.RecordsDto;
import com.example.CarWash.models.Records;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RecordsMapper {
    @Mapping(source = "user",target = "userDto")
    RecordsDto toDTOList(Records records);
}
