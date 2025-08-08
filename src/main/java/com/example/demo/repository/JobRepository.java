package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.entity.Job;

public interface JobRepository extends PagingAndSortingRepository<Job, Long> {
    // Additional query methods can be defined here if needed
    Job findById(Long id); // Method to find a job by its ID
    List<Job> findByCompanyId(Long companyId); // Method to find jobs by company ID
}