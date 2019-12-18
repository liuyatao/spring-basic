package com.github.liuyatao.springbasic;

import com.fasterxml.jackson.annotation.JsonCreator;

import org.springframework.boot.context.properties.ConstructorBinding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UserResource
 */

 @Data
 @AllArgsConstructor
 @NoArgsConstructor
public class UserDTO {

    private String name;

    private String email;
    
}