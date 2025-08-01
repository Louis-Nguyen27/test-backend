package com.example.demo.entity;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Job { // job posted by employer
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title; // Job title
    private String description; // Job description
    private String country;
    private String city;
    private String type; // online, in-person, hybrid
    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    @JsonIgnore
    private Company company; // Employer who posted the job
    private Integer minSalary;
    private Integer maxSalary;
    private Integer views;
    private Integer applications; // Number of applications received for the job
    private Date dateUpdated; // Date when the job was last updated
    @OneToMany(mappedBy = "job", fetch = FetchType.LAZY)
    private List<TalentAndJob> talentAndJobs = new ArrayList<>();
}
