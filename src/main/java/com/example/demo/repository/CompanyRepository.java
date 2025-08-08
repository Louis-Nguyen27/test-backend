package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.entity.Company;

public interface CompanyRepository extends PagingAndSortingRepository<Company, Long> {
    // Additional query methods can be defined here if needed
    Company findById(Long id); // Method to find a company by its ID
}
