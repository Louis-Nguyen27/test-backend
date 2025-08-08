package com.example.demo.entity;

import java.util.Date;
import java.util.List;

import com.example.demo.enumeration.JobApplicationStatus;
import com.example.demo.enumeration.JobOfferStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class TalentAndJob {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "talent_id", nullable = false)
    private Talent talent;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    @JsonIgnore
    private Job job;
    private boolean isInterested; // Indicates if the job seeker is interested in the job
    private String note; // Note from the job seeker about the job
    @Enumerated(EnumType.STRING)
    private JobApplicationStatus jobApplicationStatus; // Status of the job application
    @Enumerated(EnumType.STRING)
    private JobOfferStatus jobOfferStatus; // Status of the job offer
    private Date dateOffered;
    private Date dateApplied; // Date when the job seeker applied for the job
    /// between offered and applied, only one can be set
    private Date dateViewed; // Date when the job seeker viewed the job
    //private List<String> interviews;
}
