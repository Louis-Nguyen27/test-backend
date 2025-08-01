package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.CompanyAndTalent;

public interface CompanyAndTalentRepository extends JpaRepository<CompanyAndTalent, Long> {
    // Additional query methods can be defined here if needed
    
}
