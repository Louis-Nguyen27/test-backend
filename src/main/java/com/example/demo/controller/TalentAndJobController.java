package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResultObject;
import com.example.demo.dto.TalentAndJobDto;
import com.example.demo.entity.TalentAndJob;
import com.example.demo.enumeration.JobApplicationStatus;
import com.example.demo.enumeration.JobOfferStatus;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.JobRepository;
import com.example.demo.repository.TalentAndJobRepository;
import com.example.demo.repository.TalentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/talent-and-job")
public class TalentAndJobController {
    private TalentAndJobRepository talentAndJobRepository;
    private TalentRepository talentRepository;
    private CompanyRepository companyRepository;
    private JobRepository jobRepository;

    public TalentAndJobController(
        TalentAndJobRepository talentAndJobRepository,
        TalentRepository talentRepository,
        CompanyRepository companyRepository,
        JobRepository jobRepository
    ) {
        this.talentAndJobRepository = talentAndJobRepository;
        this.talentRepository = talentRepository;
        this.companyRepository = companyRepository;
        this.jobRepository = jobRepository;
    }

    @GetMapping("/all")
    public ResultObject getAllTalentAndJobs() {
        return new ResultObject(
            "Success",
            200,
            talentAndJobRepository.findAll()
        );
    }

    @GetMapping("/{jobId}/offers")
    public ResultObject getOffersByJobId(@PathVariable Long jobId) {
        return new ResultObject(
            "Success",
            200,
            talentAndJobRepository.findByJobId(jobId)
        );
    }
    
    @PostMapping("/make-offer")
    public ResultObject makeOffer(@RequestBody TalentAndJobDto talentAndJobDto) {
        TalentAndJob talentAndJob = talentAndJobRepository.findByTalentIdAndJobId(
            talentAndJobDto.getTalentId(), talentAndJobDto.getJobId()
        );
        if (talentAndJob == null) {
            TalentAndJob newTalentAndJob = new TalentAndJob();
            newTalentAndJob.setTalent(talentRepository.findById(talentAndJobDto.getTalentId()));
            newTalentAndJob.setJob(jobRepository.findById(talentAndJobDto.getJobId()));
            newTalentAndJob.setJobOfferStatus(JobOfferStatus.PENDING);
            newTalentAndJob.setJobApplicationStatus(JobApplicationStatus.NONE);
            newTalentAndJob.setDateApplied(java.util.Date.from(java.time.Instant.now()));
            talentAndJobRepository.save(newTalentAndJob);
            return new ResultObject("Offer made successfully", 201, newTalentAndJob);
        }
        else if (talentAndJob.getJobOfferStatus() != JobOfferStatus.NONE && talentAndJob.getJobApplicationStatus() == JobApplicationStatus.NONE){
            talentAndJob.setJobOfferStatus(JobOfferStatus.PENDING);
            talentAndJob.setDateOffered(java.util.Date.from(java.time.Instant.now()));
            talentAndJobRepository.save(talentAndJob);
            return new ResultObject("Offer updated successfully", 201, talentAndJob);
        } else {
            return new ResultObject("Offer already exists or cannot be made", 400, null);
        }
    }
    
    /// Reject an offer
    /// Reject an application
    /// Accept an offer
    /// Accept an application
    /// Make an application
    /// Cancel an application
    /// Schedule an interview
    /// Accept an interview
}
