package com.persistent.jobportal.service.impl;

import com.persistent.jobportal.entity.Applications;
import com.persistent.jobportal.repository.IApplicationsJobsRepository;
import com.persistent.jobportal.service.IApplicationsJobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationsJobsServiceImpl implements IApplicationsJobsService {

    // Autowired for interface IApplicationsJobsRepository
    @Autowired
    private IApplicationsJobsRepository applicationsJobsRepository;


    @Override
    public Applications addApplications(Applications applications) {
        return applicationsJobsRepository.save(applications);
    }

    @Override
    public Applications viewApplications(Long applicationId, String userId) {
        return applicationsJobsRepository.findByApplicationIdAndUserId(applicationId, userId);
    }
    @Override
    public List<Applications> viewAllApplications() {
        return applicationsJobsRepository.findAll();
    }
}
