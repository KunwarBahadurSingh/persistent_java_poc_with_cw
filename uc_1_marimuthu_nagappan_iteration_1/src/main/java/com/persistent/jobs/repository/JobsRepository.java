package com.persistent.jobs.repository;

//create JobsRepository interface here.

import com.persistent.jobs.entity.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobsRepository extends JpaRepository<Jobs, Long> {
    //create a method to save the jobs details.
    Jobs save(Jobs jobs);

    //create a method to get all the jobs details.
    List<Jobs> findAll();
}
