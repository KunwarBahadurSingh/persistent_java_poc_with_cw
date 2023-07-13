package com.persistent.jobs.controller;

import com.persistent.jobs.entity.Jobs;
import com.persistent.jobs.service.impl.JobsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

//create a class for JobsController
@RestController
@RequestMapping("/api/v2/jobs")
public class JobsController {

    @Autowired
    private JobsServiceImpl jobsServiceImpl;

    //create a method for JobsController for save the jobs
    @PostMapping("/saveJob")
    public ResponseEntity<Jobs>  saveJob(@RequestBody Jobs jobs) {
        Jobs job = jobsServiceImpl.saveJob(jobs);
        return new ResponseEntity<Jobs>(job, HttpStatus.CREATED);
    }

    //create a method for JobsController for all the jobs
    @GetMapping("/allJobs")
    public ResponseEntity<List<Jobs>> allJobs() {
        List<Jobs> jobs = jobsServiceImpl.getAllJobs();
        return new ResponseEntity<List<Jobs>>(jobs, HttpStatus.OK);
    }

    //create a method for JobsController for downloading excel
    @GetMapping("/downloadExcel")
    public ResponseEntity<Resource> downloadExcel() throws IOException
    {
        String fileName = "Jobs_Data.xlsx";
        ByteArrayInputStream in = jobsServiceImpl.downloadExcel();
        InputStreamResource file = new InputStreamResource(in);
        ResponseEntity<Resource> body = ResponseEntity.ok().
                header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=" + fileName).contentType(MediaType.parseMediaType("application/vnd.ms-excel")).body(file);
        return body;
    }

    //create a method to save the list jobs
    @PostMapping("/bulk")
    public ResponseEntity<List<Jobs>> saveJobs(@RequestBody List<Jobs> jobsList) {
        List<Jobs> jobsAll = jobsServiceImpl.saveAllJobs(jobsList);
        return new ResponseEntity<List<Jobs>>(jobsAll, HttpStatus.CREATED);
    }
}
