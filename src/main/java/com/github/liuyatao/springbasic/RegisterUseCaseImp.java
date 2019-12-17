package com.github.liuyatao.springbasic;

import java.time.LocalDateTime;

import com.github.liuyatao.springbasic.service.RegisterUseCase;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

/**
 * RegisterUseCase
 */

@Service
@RequiredArgsConstructor
@Log4j2
public class RegisterUseCaseImp implements RegisterUseCase {

    private final UserRepository userRepository;

    public User registerUser(User user) {
        user.setRegistrationDate(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    public User registerUser(UserDTO userDTO, boolean sendWelcomeMail) {
        log.info("Do some stuff");
        User user = new User("userName", "email");
        return user;
    }
    
}