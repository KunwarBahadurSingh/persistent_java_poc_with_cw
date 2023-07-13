package com.persistent.jobportal.entity;

import jakarta.persistence.*;

//create jobs table
@Entity
@Table(name ="jobs")
public class Jobs {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    //create jobId column
    private Long jobId;

    //create jobTitle column
    private String jobTitle;

    //create jobSkills column
    private String jobSkills;

    //create jobDescription column
    private String jobDescription;

    //create company column
    private String company;

    //create location column
    private String location;

    private String img;

    public String getImg() {
        return img;
    }
    public void setImg(String img) {
            this.img = img;
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

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
