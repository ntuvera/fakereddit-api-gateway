package com.example.apigateway.repository;

import com.example.apigateway.bean.UserBean;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserRepositoryTest {
    private UserBean tempUser;
    private UserBean foundUser;

    @InjectMocks
    private UserRepository userRepository;

    @InjectMocks
    private JdbcTemplate jdbcTemplate;

    @Before
    public void initUser() {
        tempUser = new UserBean(1,"iam@batman.com", "batman", "bat");
        System.out.println(tempUser);
    }

//    @Test
//    public void getUserByUsername_User_Success() {
//        when(jdbcTemplate.queryForObject(anyString(), eq(String.class)))
//                .thenReturn("\"id\":1," +
//                            "\"email\":\"iam@batman.com\"," +
//                            "\"password\":\"bat\"," +
//                            "\"username\":\"batman\"");
//
//        .thenReturn(String.valueOf(tempUser));
//
//        foundUser = userRepository.getUserByUsername(foundUser.getUsername());
//
//        assertEquals(tempUser.getId(), foundUser.getId());
//        assertEquals(tempUser.getEmail(), foundUser.getEmail());
//        assertEquals(tempUser.getPassword(), foundUser.getPassword());
//        assertEquals(tempUser.getUsername(), foundUser.getUsername());
//    }

// TODO: how does the below work and what is the expected response for a user not found?

//    @Test
//    public void getUserByUsername_User_Failure() {
//        when(jdbcTemplate.queryForObject(anyString(), eq(String.class))).thenReturn("{}");
//
//        foundUser = userRepository.getUserByUsername(foundUser.getUsername());
//
//        assertEquals(0, foundUser.getId());
//        assertEquals(null, foundUser.getEmail());
//        assertEquals(null, foundUser.getPassword());
//        assertEquals(null, foundUser.getUsername());
//    }
}
