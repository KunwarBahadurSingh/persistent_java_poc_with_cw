package com.persistent.jobportal.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.persistent.jobportal.entity.Users;
import com.persistent.jobportal.service.impl.UsersServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UsersController.class)

class UsersControllerTest {

    // mock dependency
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsersServiceImpl usersService;

    @Test
    void registerUser() throws Exception {
        Users user = new Users();
        user.setUserId(1);
        user.setUserName("Test");
        user.setEmail("test@gmail.com");
        user.setPassword("Test12345");
        user.setQualification("B.Tech");

        given(usersService.registerUser(user)).willReturn(user);
        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(post("/api/v1/user/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
    @Test
    void getAllUsers() throws Exception{
        // mock data for List<Applications> collection

        List<Users> users =  new ArrayList<Users>();
        Users users1 = new Users();
        users1.setUserId(1);
        users1.setUserName("Test");
        users1.setEmail("test@gmail.com");
        users1.setPassword("Test12345");
        users1.setQualification("B.Tech");

        users.add(users1);

        given(usersService.getAllUsers()).willReturn(users);
        // mock data for ApplicationsJobsController class
        mockMvc.perform(get("/api/v1/user/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    void verifyUser() throws Exception {

        Users users1 = new Users();
        users1.setUserId(1);
        users1.setUserName("Test");
        users1.setEmail("test@gmail.com");
        users1.setPassword("Test12345");
        users1.setQualification("B.Tech");

        ObjectMapper objectMapper = new ObjectMapper();


        given(usersService.verifyUser(users1.getEmail(), users1.getPassword())).willReturn(users1);

        mockMvc.perform(post("/api/v1/user/verifyLogin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(users1))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
}