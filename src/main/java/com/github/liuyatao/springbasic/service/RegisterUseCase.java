package com.github.liuyatao.springbasic.service;

import com.github.liuyatao.springbasic.User;
import com.github.liuyatao.springbasic.UserDTO;

/**
 * RegisterUseCase
 */
public interface RegisterUseCase {

    User registerUser(UserDTO user, boolean sendWelcomeMail);

    User registerUser(User user);

}