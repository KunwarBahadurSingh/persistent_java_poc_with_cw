package com.persistent.jobportal.service.impl;

import com.persistent.jobportal.entity.Jobs;
import com.persistent.jobportal.repository.ISearchJobsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class SearchJobsServiceImplTest {
    @InjectMocks
    private SearchJobsServiceImpl iSearchJobsServiceImpl;
    @Mock
    private ISearchJobsRepository iSearchJobsRepository;

    @Test
    void testSearchJobs() {
        List<Jobs> jobsList = new ArrayList<>();
        Jobs jobs = new Jobs();
        jobs.setJobId(1L);
        jobs.setJobTitle("Java");
        jobs.setCompany("Persistent");

        jobsList.add(jobs);

        // given - precondition or setup
        given(iSearchJobsRepository.findAll())
                .willReturn(jobsList);

        // when
        List<Jobs> fetchedJobsList = iSearchJobsServiceImpl.searchJobs();

        // then -verify the output
        assertThat(fetchedJobsList).isNotNull();
        assertThat(fetchedJobsList.size()).isEqualTo(1);

    }

    @Test
    void searchJobsByJobId() {
        Jobs jobs = new Jobs();
        jobs.setJobId(1L);
        jobs.setJobTitle("Java");
        jobs.setCompany("Persistent");

        // given - precondition or setup
        given(iSearchJobsRepository.findByJobId(jobs.getJobId()))
                .willReturn(jobs);

        // when
        Jobs fetchJobById = iSearchJobsServiceImpl.searchJobsByJobId(jobs.getJobId());

        // then
        assertThat(fetchJobById).isNotNull();
    }

    @Test
    void searchJobsByJobTitle() {
        List<Jobs> jobsList = new ArrayList<>();
        Jobs jobs = new Jobs();
        jobs.setJobId(1L);
        jobs.setJobTitle("Java");
        jobs.setCompany("Persistent");

        jobsList.add(jobs);

        // given - precondition or setup
        given(iSearchJobsRepository.findByJobTitle("Java"))
                .willReturn(jobsList);

        // when
        List<Jobs> fetchedJobsListByJobSkill = iSearchJobsServiceImpl.searchJobsByJobTitle("Java");

        // then -verify the output
        assertThat(fetchedJobsListByJobSkill).isNotNull();
        assertThat(fetchedJobsListByJobSkill.size()).isEqualTo(1);
    }

    @Test
    void searchJobsByJobLocation() {
        List<Jobs> jobsList = new ArrayList<>();
        Jobs jobs = new Jobs();
        jobs.setJobId(1L);
        jobs.setJobTitle("Java");
        jobs.setCompany("Persistent");
        jobs.setLocation("Bengaluru");
        jobsList.add(jobs);

        // given - precondition or setup
        given(iSearchJobsRepository.findByLocation("Bengaluru"))
                .willReturn(jobsList);

        // when
        List<Jobs> fetchedJobsListByJobsLocation = iSearchJobsServiceImpl.searchJobsByJobLocation("Bengaluru");

        // then -verify the output
        assertThat(fetchedJobsListByJobsLocation).isNotNull();
        assertThat(fetchedJobsListByJobsLocation.size()).isEqualTo(1);
    }

    @Test
    void searchJobsByJobSkills() {
        List<Jobs> jobsList = new ArrayList<>();
        Jobs jobs = new Jobs();
        jobs.setJobId(1L);
        jobs.setJobTitle("Java");
        jobs.setCompany("Persistent");
        jobs.setLocation("Bengaluru");
        jobs.setJobSkills("JavaSpringBoot");
        jobsList.add(jobs);

        // given - precondition or setup
        given(iSearchJobsRepository.findByJobSkills("JavaSpringBoot"))
                .willReturn(jobsList);

        // when
        List<Jobs> fetchedJobsListByJobsSkill = iSearchJobsServiceImpl.searchJobsByJobSkills("JavaSpringBoot");

        // then -verify the output
        assertThat(fetchedJobsListByJobsSkill).isNotNull();
        assertThat(fetchedJobsListByJobsSkill.size()).isEqualTo(1);
    }

    @Test
    void searchJobsByJobCompany() {
        List<Jobs> jobsList = new ArrayList<>();
        Jobs jobs = new Jobs();
        jobs.setJobId(1L);
        jobs.setJobTitle("Java");
        jobs.setCompany("Persistent");
        jobs.setLocation("Bengaluru");
        jobs.setJobSkills("JavaSpringBoot");
        jobsList.add(jobs);

        // given - precondition or setup
        given(iSearchJobsRepository.findByCompany("Persistent"))
                .willReturn(jobsList);

        // when
        List<Jobs> fetchedJobsListByJobsCompany = iSearchJobsServiceImpl.searchJobsByJobCompany("Persistent");

        // then -verify the output
        assertThat(fetchedJobsListByJobsCompany).isNotNull();
        assertThat(fetchedJobsListByJobsCompany.size()).isEqualTo(1);
    }

    @Test
    void searchJobsByJobDescription() {
        List<Jobs> jobsList = new ArrayList<>();
        Jobs jobs = new Jobs();
        jobs.setJobId(1L);
        jobs.setJobTitle("Java");
        jobs.setCompany("Persistent");
        jobs.setLocation("Bengaluru");
        jobs.setJobSkills("JavaSpringBoot");
        jobs.setJobDescription("LeadDeveloper");
        jobsList.add(jobs);

        // given - precondition or setup
        given(iSearchJobsRepository.findByJobDescription("LeadDeveloper"))
                .willReturn(jobsList);

        // when
        List<Jobs> fetchedJobsListByJobDescription = iSearchJobsServiceImpl.searchJobsByJobDescription("LeadDeveloper");

        // then -verify the output
        assertThat(fetchedJobsListByJobDescription).isNotNull();
        assertThat(fetchedJobsListByJobDescription.size()).isEqualTo(1);
    }

    @Test
    void searchJob() {
        Jobs jobs = new Jobs();
        jobs.setJobId(1L);
        jobs.setJobTitle("Java");
        jobs.setCompany("Persistent");
        jobs.setLocation("Bengaluru");
        jobs.setJobSkills("JavaSpringBoot");
        jobs.setJobDescription("LeadDeveloper");

        // given - precondition or setup
        given(iSearchJobsRepository.save(jobs))
                .willReturn(jobs);

        // when
        Jobs savedJobs = iSearchJobsServiceImpl.searchJob(jobs);

        // then -verify the output
        assertThat(savedJobs).isNotNull();
    }
}