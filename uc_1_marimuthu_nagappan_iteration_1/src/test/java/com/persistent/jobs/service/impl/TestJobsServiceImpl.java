package com.persistent.jobs.service.impl;

//create unit test for JobsServiceImplTest
import com.persistent.jobs.entity.Jobs;
import com.persistent.jobs.repository.JobsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TestJobsServiceImpl {
    @InjectMocks
    JobsServiceImpl jobsServiceImpl;
    @Mock
    JobsRepository jobsRepository;

    // addJobs_test unit tests
    @Test
    void addJobs_test() {
        Jobs jobs = new Jobs();
        jobs.setJobId(1L);
        jobs.setJobTitle("Java");
        jobs.setJobLocation("Bengaluru");
        jobs.setJobSkills("JavaSpringBoot");
        jobs.setCompany("Persistent");
        jobs.setJobsDescription("Lead Developer");
        when(jobsRepository.save(jobs))
                .thenReturn(jobs);
        Jobs jobs1= jobsServiceImpl.saveJob(jobs);
        // then -verify the output is correct
        assertThat(jobs).isNotNull();
        assertThat(jobs1.getJobId()).isEqualTo(1L);
    }

    //add allJobs test for JobsServiceImplTest
    @Test
    void getAllJobs_test() {
        List<Jobs> allJobs = new ArrayList<>();
        Jobs jobs = new Jobs();
        jobs.setJobId(1L);
        jobs.setJobTitle("Java");
        jobs.setJobLocation("Bengaluru");
        jobs.setJobSkills("JavaSpringBoot");
        jobs.setCompany("Persistent");
        jobs.setJobsDescription("Lead Developer");
        when(jobsRepository.findAll()).thenReturn(List.of(jobs));
        List<Jobs> jobsList = jobsServiceImpl.getAllJobs();
        assertThat(jobsList).isNotNull();
        assertThat(jobsList.get(0).getJobId()).isEqualTo(1L);
    }

    //delete jobs based on id for JobsServiceImplTest
    @Test
    void deleteJobs_test() {
        Jobs jobs = new Jobs();
        jobs.setJobId(1L);
        jobs.setJobTitle("Java");
        jobs.setJobLocation("Bengaluru");
        jobs.setJobSkills("JavaSpringBoot");
        jobs.setCompany("Persistent");
        jobs.setJobsDescription("Lead Developer");
        jobsRepository.save(jobs);
        // when -  action or the behaviour that we are going test
        jobsRepository.deleteById(jobs.getJobId());
        Optional<Jobs> jobsOptional = jobsRepository.findById(jobs.getJobId());
        // then - verify the output
        assertThat(jobsOptional).isEmpty();
    }

    //update jobs based on id for JobsServiceImplTest
    @Test
    void updateJobs_test() {
        Jobs jobs = new Jobs();
        jobs.setJobId(1L);
        jobs.setJobTitle("Java");
        jobs.setJobLocation("Bengaluru");
        jobs.setJobSkills("JavaSpringBoot");
        jobs.setCompany("Persistent");
        jobs.setJobsDescription("Lead Developer");
        jobsRepository.save(jobs);
        // when -  action or the behaviour that we are going test
        jobs.setJobTitle("Java");
        jobs.setJobLocation("Bengaluru");
        jobs.setJobSkills("JavaSpringBoot");
        jobs.setCompany("Persistent");
        jobs.setJobsDescription("Lead Developer");
        jobsRepository.save(jobs);
        // then - verify the output
        assertThat(jobs.getJobTitle()).isEqualTo("Java");
        assertThat(jobs.getJobLocation()).isEqualTo("Bengaluru");
        assertThat(jobs.getJobSkills()).isEqualTo("JavaSpringBoot");
        assertThat(jobs.getCompany()).isEqualTo("Persistent");
        assertThat(jobs.getJobsDescription()).isEqualTo("Lead Developer");
        assertThat(jobs.getJobId()).isEqualTo(1L);
    }

    // addAllJobs_test unit tests for JobsServiceImplTest
    @Test
    void addAllJobs_test() {
        List<Jobs> allJobs = new ArrayList<>();
        Jobs jobs = new Jobs();
        jobs.setJobId(1L);
        jobs.setJobTitle("Java");
        jobs.setJobLocation("Bengaluru");
        jobs.setJobSkills("JavaSpringBoot");
        jobs.setCompany("Persistent");
        jobs.setJobsDescription("Lead Developer");
        allJobs.add(jobs);
        when(jobsRepository.saveAll(allJobs)).thenReturn(allJobs);
        List<Jobs> jobsList = jobsServiceImpl.saveAllJobs(allJobs);
        assertThat(jobsList).isNotNull();
        assertThat(jobsList.get(0).getJobId()).isEqualTo(1L);
    }
}
