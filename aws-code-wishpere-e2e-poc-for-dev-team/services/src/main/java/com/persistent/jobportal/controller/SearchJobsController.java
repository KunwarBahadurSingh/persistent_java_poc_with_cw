package com.persistent.jobportal.controller;

import com.persistent.jobportal.entity.Jobs;
import com.persistent.jobportal.service.impl.SearchJobsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/jobs")
public class SearchJobsController {

    @Autowired
    private SearchJobsServiceImpl searchJobsServiceImpl;

    // create method for searching all jobs
    @GetMapping("/all")
    public ResponseEntity<List<Jobs>> searchJobs() {
          List<Jobs> jobs = searchJobsServiceImpl.searchJobs();
         return new ResponseEntity<List<Jobs>>(jobs, HttpStatus.OK);
    }


    //create method for searching by jobID
    @GetMapping("/jobId/{jobId}")
    public ResponseEntity<Jobs> searchJobsByJobId(@PathVariable("jobId") Long jobId) {
        Jobs searchJobs = searchJobsServiceImpl.searchJobsByJobId(jobId);
        return new ResponseEntity<Jobs>(searchJobs, HttpStatus.OK);
    }

    // create method for searching jobs by location
    @GetMapping("/location/{location}")
    public ResponseEntity<List<Jobs>> searchJobsByLocation(@PathVariable("location")  String location) {
        List<Jobs> searchJobs = searchJobsServiceImpl.searchJobsByJobLocation(location);
        return new ResponseEntity<List<Jobs>>(searchJobs, HttpStatus.OK);
    }

    //create method for searching jobs by skill
    @GetMapping("/jobSkills/{jobSkills}")
    public ResponseEntity<List<Jobs>> searchJobsBySkill(@PathVariable("jobSkills")
                                                            String jobSkills) {
        List<Jobs> searchJobs = searchJobsServiceImpl.searchJobsByJobSkills(jobSkills);
        return new ResponseEntity<List<Jobs>>(searchJobs, HttpStatus.OK);
    }

    //create method for searching jobs by job title
    @GetMapping("/jobTitle/{jobTitle}")
    public ResponseEntity<List<Jobs>> searchJobsByTitle(@PathVariable("jobTitle") String jobTitle) {
        List<Jobs> searchJobs = searchJobsServiceImpl.searchJobsByJobTitle(jobTitle);
        return new ResponseEntity<List<Jobs>>(searchJobs, HttpStatus.OK);
    }

    //create method for searching jobs by company
    @GetMapping("/company/{company}")
    public ResponseEntity<List<Jobs>> searchJobsByCompany(@PathVariable("company") String company) {
        List<Jobs> searchJobs = searchJobsServiceImpl.searchJobsByJobCompany(company);
        return new ResponseEntity<List<Jobs>>(searchJobs, HttpStatus.OK);
    }

    //create method for searching jobs by jobDescription
    @GetMapping("/description/{description}")
    public ResponseEntity<List<Jobs>> searchJobsByDescription(@PathVariable("jobDescription") String jobDescription) {
        List<Jobs> searchJobs = searchJobsServiceImpl.searchJobsByJobDescription(jobDescription);
        return new ResponseEntity<List<Jobs>>(searchJobs, HttpStatus.OK);
    }

    // create searchjob
    @PostMapping("/createjob")
    public ResponseEntity<Jobs> createJob(@RequestBody Jobs jobs) {
        Jobs searchJobs = searchJobsServiceImpl.searchJob(jobs);
        return new ResponseEntity<Jobs>(searchJobs, HttpStatus.OK);
    }
}

