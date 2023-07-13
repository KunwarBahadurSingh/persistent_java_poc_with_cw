package com.persistent.jobportal.service.impl;

import com.persistent.jobportal.entity.Jobs;
import com.persistent.jobportal.repository.ISearchJobsRepository;
import com.persistent.jobportal.service.ISearchJobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//create service class for search jobs based on service interface
@Service
public class SearchJobsServiceImpl implements ISearchJobsService {

    //Autowired for SearchJobsRepository
    @Autowired
    private ISearchJobsRepository searchJobsRepository;

    @Override
    public List<Jobs> searchJobs() {
        return searchJobsRepository.findAll();
    }

    @Override
    public Jobs searchJobsByJobId(long jobId) {
        return searchJobsRepository.findByJobId(jobId);
    }

    @Override
    public List<Jobs> searchJobsByJobTitle(String jobTitle) {
        return searchJobsRepository.findByJobTitle(jobTitle);
    }

    @Override
    public List<Jobs> searchJobsByJobLocation(String jobLocation) {
        return searchJobsRepository.findByLocation(jobLocation);
    }

    @Override
    public List<Jobs> searchJobsByJobSkills(String jobSkills) {
        return searchJobsRepository.findByJobSkills(jobSkills);
    }

    @Override
    public List<Jobs> searchJobsByJobCompany(String jobCompany) {
        return searchJobsRepository.findByCompany(jobCompany);
    }

    @Override
    public List<Jobs> searchJobsByJobDescription(String jobDescription) {
        return searchJobsRepository.findByJobDescription(jobDescription);
    }


    public  Jobs searchJob(Jobs jobs) {
        return searchJobsRepository.save(jobs);
    }
}
