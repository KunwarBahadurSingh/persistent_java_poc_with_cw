package com.persistent.jobs.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.persistent.jobs.entity.Jobs;
import com.persistent.jobs.service.impl.JobsServiceImpl;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.hamcrest.Matchers.hasSize;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//write a unit test for JobsController
@RunWith(SpringRunner.class)
@WebMvcTest(JobsController.class)
public class TestJobsController {
        @Autowired
        private MockMvc mockMvc;
        @MockBean
        private JobsServiceImpl jobsServiceImpl;

        @BeforeEach
        void setUp() {
        }

        @AfterEach
        void tearDown() {
        }

        // write unit test for saveJob()
        @Test
        void testSaveJob() throws Exception {
            Jobs jobs = new Jobs();
            jobs.setJobId(1L);
            jobs.setJobTitle("Java");
            jobs.setJobLocation("Bengaluru");
            jobs.setJobSkills("JavaSpringBoot");
            jobs.setCompany("Persistent");
            jobs.setJobsDescription("Lead Developer");

            given(jobsServiceImpl.saveJob(jobs)).willReturn(jobs);
            // when - action or behaviour that we are going test and then -verify the result
            mockMvc.perform( MockMvcRequestBuilders
                            .post("/api/v2/jobs/saveJob")
                            .content(asJsonString(new Jobs(1L, "Java", "Bengaluru", "JavaSpringBoot", "Persistent", "Lead Developer")))
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isCreated());

        }

      //write unit test method for getAllJobs
       @Test
       public void testGetAllJobs() throws Exception {
           // mock data for List<Applications> collection
           List<Jobs> jobsList =  new ArrayList<>();
           Jobs jobs = new Jobs();
           jobs.setJobId(1L);
           jobs.setJobTitle("Java");
           jobs.setJobLocation("Bengaluru");
           jobs.setJobSkills("JavaSpringBoot");
           jobs.setCompany("Persistent");
           jobs.setJobsDescription("Lead Developer");
           jobsList.add(jobs);
           given(jobsServiceImpl.getAllJobs()).willReturn(jobsList);
           // mock data for JobsController class
           mockMvc.perform(MockMvcRequestBuilders.get("/api/v2/jobs/allJobs")
                           .accept(MediaType.APPLICATION_JSON))
                           .andDo(print())
                   .andExpect(status().isOk())
                   .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)));
       }

        public static String asJsonString(final Object obj) {
            try {
                return new ObjectMapper().writeValueAsString(obj);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    //write unit test for saveAllJobs()
    @Test
    public void testSaveAllJobs() throws Exception {
        List<Jobs> jobsList = new ArrayList<>();
        Jobs jobs = new Jobs();
        jobs.setJobId(1L);
        jobs.setJobTitle("Java");
        jobs.setJobLocation("Bengaluru");
        jobs.setJobSkills("JavaSpringBoot");
        jobs.setCompany("Persistent");
        jobs.setJobsDescription("Lead Developer");
        jobsList.add(jobs);
        given(jobsServiceImpl.saveAllJobs(jobsList)).willReturn(jobsList);
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/v2/jobs/bulk")
                        .content(asJsonString(jobsList))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
}
