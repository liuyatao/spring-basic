package com.github.liuyatao.springbasic;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.liuyatao.springbasic.service.RegisterUseCase;
import com.github.liuyatao.springbasic.web.resource.UserResource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

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
    public void helloworldTest() throws Exception {
        mockMvc.perform(get("/helloWorld"))
        .andExpect(status().isOk())
        .andExpect(content().string("Hello World"));
    }

    @Test
    public void whenValidInput_thenReturns200() throws JsonProcessingException, Exception {
        UserDTO userDTO = new UserDTO("刘亚涛", "739697044@qq.com");

        when(mockRegisterUseCase.registerUser(any(UserDTO.class), any(Boolean.class)))
                .thenReturn(new User("UserName","email"));


        MvcResult mvcResult = mockMvc.perform(post("/forums/{forumId}/register",42L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("sendWelcomeMail", "true")
                        .content(objectMapper.writeValueAsString(userDTO)))
                .andExpect(status().isOk())
                .andReturn();

        //参数捕获
        ArgumentCaptor<UserDTO> uArgumentCaptor = ArgumentCaptor.forClass(UserDTO.class);

        verify(mockRegisterUseCase, times(1)).registerUser(uArgumentCaptor.capture(), eq(true));

        assertThat(uArgumentCaptor.getValue().getName(),is("刘亚涛"));
        assertThat(uArgumentCaptor.getValue().getEmail(),is("739697044@qq.com"));
        
        //验证返回结果
        UserDTO actual = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), UserDTO.class);
        assertThat(actual.getEmail(), is("email"));
        assertThat(actual.getName(), is("UserName"));
    }    
}