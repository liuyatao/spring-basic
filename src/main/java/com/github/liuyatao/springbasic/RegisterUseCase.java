package com.github.liuyatao.springbasic;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

/**
 * RegisterUseCase
 */

@Service
@RequiredArgsConstructor
public class RegisterUseCase {

    private final UserRepository userRepository;

    public User registerUser(User user) {
        user.setRegistrationDate(LocalDateTime.now());
        return userRepository.save(user);
    }

    

    
}