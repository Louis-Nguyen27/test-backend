package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.entity.TalentAndJob;

public interface TalentAndJobRepository extends PagingAndSortingRepository<TalentAndJob, Long> {
    // Additional query methods can be defined here if needed
    List<TalentAndJob> findAll(); // Method to find all TalentAndJob relationships
    List<TalentAndJob> findByTalentId(Long talentId); // Method to find TalentAndJob by talent ID
    List<TalentAndJob> findByJobId(Long jobId); // Method to find TalentAndJob by job ID
    TalentAndJob findById(Long id); // Method to find a TalentAndJob by
    TalentAndJob findByTalentIdAndJobId(Long talentId, Long jobId); // Method to find by talentId and jobId
    void save(TalentAndJob talentAndJob); // Method to save a TalentAndJob relationship
}
