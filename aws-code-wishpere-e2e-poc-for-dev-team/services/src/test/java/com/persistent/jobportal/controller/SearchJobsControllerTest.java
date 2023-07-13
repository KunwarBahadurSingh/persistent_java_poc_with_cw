package com.persistent.jobportal.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.persistent.jobportal.entity.Jobs;
import com.persistent.jobportal.service.impl.SearchJobsServiceImpl;
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
@WebMvcTest(SearchJobsController.class)
class SearchJobsControllerTest {

    // mock dependency
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SearchJobsServiceImpl searchJobsServiceImpl;
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void testSearchJobs() throws Exception {
        //mock data for searchJobs()
        List<Jobs> listJobs =  new ArrayList<Jobs>();
        Jobs jobs = new Jobs();
        jobs.setJobId(1L);
        jobs.setJobTitle("Java");
        jobs.setLocation("Bengaluru");
        jobs.setJobSkills("JavaSpringBoot");
        jobs.setCompany("Persistent");
        jobs.setJobDescription("Lead Developer");

        listJobs.add(jobs);

        given(searchJobsServiceImpl.searchJobs()).willReturn(listJobs);
        // mock data for ApplicationsJobsController class
        mockMvc.perform(get("/api/v1/jobs/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    void testSearchJobsByJobId() throws Exception {
        Jobs jobs = new Jobs();
        jobs.setJobId(1L);
        jobs.setJobTitle("Java");
        jobs.setLocation("Bengaluru");
        jobs.setCompany("Persistent");
        jobs.setJobSkills("JavaSpringBoot");

        given(searchJobsServiceImpl.searchJobsByJobId(1L)).willReturn(jobs);
        mockMvc.perform(get("/api/v1/jobs/jobId/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.jobId").value(1L));
    }

    @Test
    void testSearchJobsByLocation() throws Exception {
        List<Jobs> jobsList = new ArrayList<>();
        Jobs jobs = new Jobs();
        jobs.setJobId(1L);
        jobs.setJobTitle("Java");
        jobs.setLocation("Bengaluru");
        jobs.setCompany("Persistent");
        jobs.setJobSkills("JavaSpringBoot");
        jobsList.add(jobs);

        given(searchJobsServiceImpl.searchJobsByJobLocation("Bengaluru")).willReturn(jobsList);
        mockMvc.perform(get("/api/v1/jobs/location/Bengaluru")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    void testSearchJobsBySkill() throws Exception {
        List<Jobs> jobsList = new ArrayList<>();
        Jobs jobs = new Jobs();
        jobs.setJobId(1L);
        jobs.setJobTitle("Java");
        jobs.setLocation("Bengaluru");
        jobs.setCompany("Persistent");
        jobs.setJobSkills("JavaSpringBoot");
        jobsList.add(jobs);

        given(searchJobsServiceImpl.searchJobsByJobSkills("JavaSpringBoot")).willReturn(jobsList);
        mockMvc.perform(get("/api/v1/jobs/jobSkills/JavaSpringBoot")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    void testSearchJobsByTitle() throws Exception {
        List<Jobs> jobsList = new ArrayList<>();
        Jobs jobs = new Jobs();
        jobs.setJobId(1L);
        jobs.setJobTitle("Java");
        jobs.setLocation("Bengaluru");
        jobs.setCompany("Persistent");
        jobsList.add(jobs);

        given(searchJobsServiceImpl.searchJobsByJobTitle("Java")).willReturn(jobsList);
        mockMvc.perform(get("/api/v1/jobs/jobTitle/Java")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    void testSearchJobsByCompany() throws Exception {
        List<Jobs> jobsList = new ArrayList<>();
        Jobs jobs = new Jobs();
        jobs.setJobId(1L);
        jobs.setJobTitle("Java");
        jobs.setLocation("Bengaluru");
        jobs.setCompany("Persistent");
        jobsList.add(jobs);

        given(searchJobsServiceImpl.searchJobsByJobCompany("Persistent")).willReturn(jobsList);
        mockMvc.perform(get("/api/v1/jobs/company/Persistent")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    void searchJobsByDescription() {
    }

    @Test
    void testCreateJob() throws Exception {
        Jobs jobs = new Jobs();
        jobs.setJobId(1L);
        jobs.setJobTitle("Java");
        jobs.setLocation("Bengaluru");
        jobs.setJobSkills("JavaSpringBoot");
        jobs.setCompany("Persistent");
        jobs.setJobDescription("Lead Developer");

        given(searchJobsServiceImpl.searchJob(jobs)).willReturn(jobs);
        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(post("/api/v1/jobs/createjob")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(jobs))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}