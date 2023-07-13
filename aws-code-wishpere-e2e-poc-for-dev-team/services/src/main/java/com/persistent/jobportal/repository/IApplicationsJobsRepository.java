package com.persistent.jobportal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.persistent.jobportal.entity.Applications;

import java.util.List;

@Repository
public interface IApplicationsJobsRepository extends CrudRepository<Applications,Long> {
    //create a method for ApplicationJobs
    public Applications save(Applications applications);

    //create a method for finding Applications by ApplicationId
    public Applications findByApplicationIdAndUserId(Long applicationId, String userId);

    //create a method for finding all ApplicationId
    public List<Applications> findAll();
}
