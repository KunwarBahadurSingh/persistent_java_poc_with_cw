package com.persistent.jobs.entity;
// create Entity class for Jobs

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "jobs")
public class Jobs {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long jobId;
    private String jobTitle;
    private String jobSkills;
    private String jobsDescription;
    private String jobLocation;
    private String company;
    private LocalDate postedDate;
    public Jobs() {
    }
    public Jobs(Long jobId, String jobTitle, String jobSkills, String jobsDescription, String jobLocation, String company, LocalDate postedDate) {
        super();
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.jobSkills = jobSkills;
        this.jobsDescription = jobsDescription;
        this.jobLocation = jobLocation;
        this.company = company;
        this.postedDate = postedDate;
    }
    public Jobs(Long jobId, String jobTitle, String jobSkills, String jobsDescription, String jobLocation, String company) {
        super();
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.jobSkills = jobSkills;
        this.jobsDescription = jobsDescription;
        this.jobLocation = jobLocation;
        this.company = company;
    }
    public Long getJobId() {
        return jobId;
    }
    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }
    public String getJobTitle() {
        return jobTitle;
    }
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    public String getJobSkills() {
        return jobSkills;
    }
    public void setJobSkills(String jobSkills) {
        this.jobSkills = jobSkills;
    }
    public String getJobsDescription() {
        return jobsDescription;
    }
    public void setJobsDescription(String jobsDescription) {
        this.jobsDescription = jobsDescription;
    }
    public String getJobLocation() {
        return jobLocation;
    }
    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public LocalDate getPostedDate() {
        return postedDate;
    }
    public void setPostedDate(LocalDate postedDate) {
        this.postedDate = postedDate;
    }
}
