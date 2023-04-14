package com.example.CarWash.controllers;

import com.example.CarWash.Mapper.UserMapper;
import com.example.CarWash.dto.UserDto;
import com.example.CarWash.models.User;
import com.example.CarWash.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserMapper userMapper;
    private final UserService userService;


    @GetMapping("user/{id}")
    public UserDto getUser(@PathVariable("id") Long id) {
        try {
            User user = userService.findById(id).get();
            return userMapper.INSTANCE.toDTO(user);
        }catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found", e);
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong", e);
        }
    }
}
