package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.entity.Talent;

public interface TalentRepository extends PagingAndSortingRepository<Talent, Long> {
    // Additional query methods can be defined here if needed
    Talent findById(Long talentId);

    void save(Talent entity);
}
