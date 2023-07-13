package com.persistent.jobs.service;

import com.persistent.jobs.entity.Jobs;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

//create interface for IJobsService
public interface IJobsService {

    //create a method for saving job
    public Jobs saveJob(Jobs Jobs);

    //create a method for getting all job details
    public List<Jobs> getAllJobs();

    //create a method for exporting data in excel sheet
    public ByteArrayInputStream downloadExcel() throws IOException;

    //create a method for saving the list of jobs
    public List<Jobs> saveAllJobs(List<Jobs> allJobs);
}
