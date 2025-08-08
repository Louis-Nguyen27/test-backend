package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.entity.CompanyAndTalent;

public interface CompanyAndTalentRepository extends PagingAndSortingRepository<CompanyAndTalent, Long> {
    // Additional query methods can be defined here if needed
    CompanyAndTalent findById(Long id); // Method to find a relationship by its ID
    // Method to find by companyId and talentId
    CompanyAndTalent findByCompanyIdAndTalentId(Long companyId, Long talentId);
    void save(CompanyAndTalent companyAndTalent); // Method to save a relationship
    
}
