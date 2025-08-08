package com.example.demo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.demo.enumeration.JobsSearchIntentions;
import com.example.demo.utils.UtilsType.Education;
import com.example.demo.utils.UtilsType.JobExperience;
import com.example.demo.utils.UtilsType.Skill;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Talent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean isJobOffersAcceptable;
    @Enumerated(EnumType.STRING)
    private JobsSearchIntentions jobsSearchIntentions;
    private String country;
    private String city;
    private String introduction; 
    @Convert(converter = com.example.demo.converter.StringListConverter.class)
    private List<String> files;
    @Convert(converter = com.example.demo.converter.SkillListConverter.class)
    private List<Skill> skills;
    @Convert(converter = com.example.demo.converter.JobExperienceListConverter.class)
    private List<JobExperience> jobsExperience; // jobs experienced in
    @Convert(converter = com.example.demo.converter.EducationListConverter.class)
    private List<Education> education;
    private Date dateUpdated;
    @JsonIgnore
    @OneToMany(mappedBy = "talent", fetch = FetchType.LAZY)
    private List<TalentAndJob> talentAndJobs = new ArrayList<>();
    @JsonIgnore
    @OneToMany(mappedBy = "talent", fetch = FetchType.LAZY)
    private List<CompanyAndTalent> companyAndTalents = new ArrayList<>();

}