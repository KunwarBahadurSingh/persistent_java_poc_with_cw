package com.persistent.jobs.service.impl;

import com.persistent.jobs.entity.Jobs;
import com.persistent.jobs.repository.JobsRepository;
import com.persistent.jobs.service.IJobsService;
import com.persistent.jobs.utility.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

//create implementation class for IJobsService
@Service
public class JobsServiceImpl implements IJobsService {

    @Autowired
    private JobsRepository jobsRepository;

    //create a method for getJobs
    @Override
    public List<Jobs> getAllJobs() {
        return jobsRepository.findAll();
    }

    //create a method for saving job
    @Override
    public Jobs saveJob(Jobs jobs) {
        return jobsRepository.save(jobs);
    }

    //create a method for exporting excel sheet
    @Override
    public ByteArrayInputStream downloadExcel() throws IOException {
        List<Jobs> jobs = jobsRepository.findAll();
        ByteArrayInputStream in = Helper.dataToExcel(jobs);
        return in;
    }
    @Override
    public List<Jobs> saveAllJobs(List<Jobs> jobsList) {
        return jobsRepository.saveAll(jobsList);
    }
}
