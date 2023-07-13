package com.persistent.jobportal.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.persistent.jobportal.entity.Applications;
import com.persistent.jobportal.service.impl.ApplicationsJobsServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
@WebMvcTest(ApplicationsJobsController.class)
class ApplicationsJobsControllerTest {

    // mock dependency
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ApplicationsJobsServiceImpl  applicationsJobsService;
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllApplications() throws Exception {
           // mock data for List<Applications> collection

        List<Applications> applications =  new ArrayList<Applications>();
        Applications applications1 = new Applications();
        applications1.setApplicationId(1L);
        applications1.setUserId("1");
        applications1.setJobId(1L);

        applications.add(applications1);

        given(applicationsJobsService.viewAllApplications()).willReturn(applications);
        // mock data for ApplicationsJobsController class
        mockMvc.perform(get("/api/v1/applications/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    void getApplicationsByApplicationId_and_User_Id() throws Exception {
        Applications applications = new Applications();
        applications.setApplicationId(1L);
        applications.setUserId("1");
        applications.setJobId(1L);

        given(applicationsJobsService.viewApplications(1L, "1")).willReturn(applications);
        mockMvc.perform(get("/api/v1/applications/application/1/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.applicationId").value(1L));
    }

    // write unit test for saveApplications()
        @Test
    void saveApplications_test() throws Exception {
        Applications applications = new Applications();
        applications.setApplicationId(1L);
        applications.setUserId("1");
        applications.setJobId(1L);

        given(applicationsJobsService.addApplications(applications)).willReturn(applications);
            ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(post("/api/v1/applications/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(applications))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
        }
}