package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.entity.Job;

public interface JobRepository extends PagingAndSortingRepository<Job, Long> {
    // Additional query methods can be defined here if needed

}