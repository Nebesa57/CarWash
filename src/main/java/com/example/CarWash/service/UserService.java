package com.example.CarWash.service;

import com.example.CarWash.models.User;
import com.example.CarWash.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }
}
