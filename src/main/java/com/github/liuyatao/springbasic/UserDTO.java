package com.github.liuyatao.springbasic;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * UserResource
 */

 @Data
 @AllArgsConstructor
public class UserDTO {

    private String name;

    private String email;
    
}