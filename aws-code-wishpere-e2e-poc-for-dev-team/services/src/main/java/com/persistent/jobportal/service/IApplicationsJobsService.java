package com.persistent.jobportal.service;

import com.persistent.jobportal.entity.Applications;

import java.util.List;

//create interface for Applications Service
public interface IApplicationsJobsService {
    //create a method for Applications add
    public Applications addApplications(Applications applications);

    //create a method for Applications view
    public Applications viewApplications(Long applicationId, String userId);

    //create a method for Applications view all
    public List<Applications> viewAllApplications();
}
