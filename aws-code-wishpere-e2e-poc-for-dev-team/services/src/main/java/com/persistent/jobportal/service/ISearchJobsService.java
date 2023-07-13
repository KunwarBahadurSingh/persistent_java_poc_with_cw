package com.persistent.jobportal.service;

import com.persistent.jobportal.entity.Jobs;

import java.util.List;

//Create Interface for ISearchJobsService
public interface ISearchJobsService {

    //create a method all searchJobs as list
    public List<Jobs> searchJobs();


    //Create a method searchJobs by jobID
    public Jobs searchJobsByJobId(long jobId);

    //Create a method searchJobs by jobTitle as list
    public List<Jobs> searchJobsByJobTitle(String jobTitle);


    //Create a method searchJobs by Location
    public List<Jobs> searchJobsByJobLocation(String jobLocation);

    //Create a method searchJobs by Skills
    public List<Jobs> searchJobsByJobSkills(String jobSkills);

    //Create a method searchJobs by Company
    public List<Jobs> searchJobsByJobCompany(String jobCompany);

    //create a method searchJobs by jobDescription
    public List<Jobs> searchJobsByJobDescription(String jobDescription);
}
