package com.persistent.jobportal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

//create a class for Applications
@Entity
@Table(name ="applications")
public class Applications {
    //create a field for applicationId
    @Id
    private Long applicationId;
    //create a field for jobId
    private Long jobId;
    //create a field for userId
    private String userId;

    //create a field for appliedAt
    private LocalDateTime appliedAt;
    //create a field for ca

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobID) {
        this.jobId = jobId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDateTime getAppliedAt() {
        return appliedAt;
    }

    public void setAppliedAt(LocalDateTime appliedAt) {
        this.appliedAt = appliedAt;
    }




}
