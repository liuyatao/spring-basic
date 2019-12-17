package com.github.liuyatao.springbasic;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * RegisterUseCaseTest
 */

 @ExtendWith(MockitoExtension.class)
public class RegisterUseCaseTest {


    @Mock
    private UserRepository userRepository ;

    @InjectMocks
    private RegisterUseCase registerUseCase;


    @Test
    void savedUserHasRegistrationDate() {
        User user = new User("zaphod", "zaphod@mail.com");
        when(userRepository.save(any(User.class))).then(returnsFirstArg());
        User savedUser = registerUseCase.registerUser(user);
        assertThat(savedUser.getRegistrationDate(),is(not(equals(null))));
    }


    
}