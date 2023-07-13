package com.persistent.jobportal.service.impl;

import com.persistent.jobportal.entity.Applications;
import com.persistent.jobportal.repository.IApplicationsJobsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class ApplicationsJobsServiceImplTest {
    @InjectMocks
    ApplicationsJobsServiceImpl applicationsJobsServiceImpl;

    @Mock
    IApplicationsJobsRepository applicationsJobsRepository;

    // addApplications unit tests
    @Test
    void addApplicationsJob() {
            Applications applications = new Applications();
            applications.setApplicationId(1L);
            applications.setJobId(1L);
            applications.setUserId("1");
            Mockito.when(applicationsJobsRepository.save(applications))
                    .thenReturn(applications);

            Applications applications1= applicationsJobsServiceImpl.addApplications(applications);

            // then -verify the output
            assertThat(applications1).isNotNull();
            assertThat(applications1.getApplicationId()).isEqualTo(1L);
            //assertThat(applications1.getJobId()).isEqualTo(1L);
            //assertThat(applications1.getUserId()).isEqualTo("1");
    }

    //viewApplications unit tests
        @Test
    void viewApplicationsJob() {
            Applications applications = new Applications();
            applications.setApplicationId(1L);
            applications.setJobId(1L);
            applications.setUserId("1");

            Mockito.when(applicationsJobsRepository.findByApplicationIdAndUserId(1L,"1")).thenReturn(applications);
            Applications applications2 = applicationsJobsServiceImpl.viewApplications(1L,"1");
            assertThat(applications2).isNotNull();
            assertThat(applications2.getApplicationId()).isEqualTo(1L);
            //assertThat(applications2.getJobId()).isEqualTo(1L);
            //assertThat(applications2.getUserId()).isEqualTo("1");
        }

        //viewAllApplications unit tests
    @Test
        void viewAllApplicationsJob() {
        Applications applications = new Applications();
        applications.setApplicationId(1L);
        applications.setJobId(1L);
        applications.setUserId("1");

        Mockito.when(applicationsJobsRepository.findAll()).thenReturn(List.of(applications));
        List<Applications> applicationsList = applicationsJobsServiceImpl.viewAllApplications();
        assertThat(applicationsList).isNotNull();
        assertThat(applicationsList.get(0).getApplicationId()).isEqualTo(1L);
        //assertThat(applicationsList.get(0).getJobId()).isEqualTo(1L);
        //assertThat(applicationsList.get(0).getUserId()).isEqualTo("1");
    }
}