package com.example.CarWash.Mapper;

import com.example.CarWash.dto.UserDto;
import com.example.CarWash.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    UserDto toDTO(User user);
}
