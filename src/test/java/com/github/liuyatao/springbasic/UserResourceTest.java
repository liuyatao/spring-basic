package com.github.liuyatao.springbasic;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.liuyatao.springbasic.service.RegisterUseCase;
import com.github.liuyatao.springbasic.web.resource.UserResource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

/**
 * UserResourceTest
 */
@WebMvcTest(controllers = { UserResource.class })
@ExtendWith(MockitoExtension.class)
public class UserResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private RegisterUseCase mockRegisterUseCase;


    @Test
    public void whenValidInput_thenReturns200() throws JsonProcessingException, Exception {
        UserDTO userDTO = new UserDTO("Zaphod", "zaphod@galaxy.net");

        mockMvc.perform(post("/forums/{forumId}/register",42L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("sendWelcomeMail", "true")
                        .content(objectMapper.writeValueAsString(userDTO)))
                .andExpect(status().isOk());

    }
    
}