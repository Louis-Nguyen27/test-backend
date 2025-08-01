package com.example.demo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.example.demo.enumeration.JobOfferStatus;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CompanyAndTalent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company; // Company that the talent is associated with
    @ManyToOne
    @JoinColumn(name = "talent_id", nullable = false)
    private Talent talent; // Talent associated with the company

    private String groupName;
    private boolean isInterested; // Indicates if the employer is interested in the talent
    @Enumerated(EnumType.STRING)
    private JobOfferStatus jobOfferStatus; // Status of the job offer
    @Convert(converter = com.example.demo.converter.StringListConverter.class)
    private List<String> tags = new ArrayList<>(); // Tags associated with the talent
    private String note;
    private Date dateViewed;
}
