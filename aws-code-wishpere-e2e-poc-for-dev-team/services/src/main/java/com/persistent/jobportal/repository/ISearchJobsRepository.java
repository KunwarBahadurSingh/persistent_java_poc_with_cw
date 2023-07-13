package com.persistent.jobportal.repository;

import com.persistent.jobportal.entity.Jobs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//create SearchJobsRepository interface
@Repository
public interface ISearchJobsRepository extends CrudRepository<Jobs, Long> {
    //create SearchJobsRepository interface
    public List<Jobs> findAll();

    //create SearchJobs based on jobID
    public Jobs findByJobId(Long jobId);

    //create SearchJobs based on jobTitle
    public List<Jobs> findByJobTitle(String jobTitle);

    //create SearchJobs based on location
    public List<Jobs> findByLocation(String location);

    //create SearchJobs based on skills
    public List<Jobs> findByJobSkills(String skills);

    //create SearchJobs based on company
    public List<Jobs> findByCompany(String company);

    //create SearchJobs based on jobDescription
    public List<Jobs> findByJobDescription(String jobDescription);



}
