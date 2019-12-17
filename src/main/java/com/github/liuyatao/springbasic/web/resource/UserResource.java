package com.github.liuyatao.springbasic.web.resource;

import javax.validation.Valid;

import com.github.liuyatao.springbasic.User;
import com.github.liuyatao.springbasic.UserDTO;
import com.github.liuyatao.springbasic.service.RegisterUseCase;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

/**
 * UserResource
 */
@RestController
@RequiredArgsConstructor
public class UserResource {

    private final RegisterUseCase registerUseCase;



    @PostMapping("/forums/{forumId}/register")
    public UserDTO register(@PathVariable("forumId") Long forumId, 
                                @Valid @RequestBody UserDTO userVM,
                                @RequestParam("sendWelcomeMail") boolean sendWelcomeMail){

        UserDTO userDTO = new UserDTO(userVM.getName(),userVM.getEmail());
        
        User user = registerUseCase.registerUser(userDTO, sendWelcomeMail);

        return new UserDTO(user.getUserName(), user.getEmail());
    }

    
}