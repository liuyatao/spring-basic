package com.github.liuyatao.springbasic;

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