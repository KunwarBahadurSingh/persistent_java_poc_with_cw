package com.persistent.jobs;

//create main class for JobsApplication
//@SpringBootTest
public class TestJobsApplication {
    public static void main(String[] args) {
        JobsApplication.main(args);
    }


}




/*import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

//create main class for JobsApplicationTests
@SpringBootTest(classes = JobsApplicationTests.class)
public class JobsApplicationTests {

    @Mock
    private SpringApplicationBuilder springApplicationBuilder;

    @Test
    public void testConfigure() {
        JobsApplication app = new JobsApplication();

        Mockito.when(springApplicationBuilder.sources(JobsApplication.class)).thenReturn(springApplicationBuilder);

        SpringApplicationBuilder result = app.configure(springApplicationBuilder);

        Mockito.verify(springApplicationBuilder).sources(JobsApplication.class);

        assertEquals(springApplicationBuilder, result);
    }
}*/