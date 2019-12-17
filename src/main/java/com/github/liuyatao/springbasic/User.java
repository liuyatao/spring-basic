package com.github.liuyatao.springbasic;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * User
 */

@Data
@Entity
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private String email;

    private LocalDateTime registrationDate;

    public User(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }

}