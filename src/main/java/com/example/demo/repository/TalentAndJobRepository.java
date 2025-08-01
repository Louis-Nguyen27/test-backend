package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.TalentAndJob;

public interface TalentAndJobRepository extends JpaRepository<TalentAndJob, Long> {
    // Additional query methods can be defined here if needed
    
}
