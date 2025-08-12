package com.example.demo.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.demo.entity.CompanyAndTalent;
import com.example.demo.entity.TalentAndJob;
import com.example.demo.enumeration.JobsSearchIntentions;
import com.example.demo.utils.UtilsType.Education;
import com.example.demo.utils.UtilsType.JobExperience;
import com.example.demo.utils.UtilsType.Skill;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Convert;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TalentProfileDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean isJobOffersAcceptable;
    private JobsSearchIntentions jobsSearchIntentions;
    private String country;
    private String city;
    private String introduction; 
    private List<String> files;
    private List<Skill> skills;
    private List<JobExperience> jobsExperience; // jobs experienced in
    private List<Education> education;
    private Date dateUpdated;
    private List<TalentAndJob> talentAndJobs;
    private List<CompanyAndTalent> companyAndTalents;

}
