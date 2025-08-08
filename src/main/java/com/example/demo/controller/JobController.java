package com.example.demo.controller;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResultObject;
import com.example.demo.entity.Job;
import com.example.demo.repository.JobRepository;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/jobs")
public class JobController {
    private JobRepository jobRepository;
    public JobController(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }
    @GetMapping("/all") /// dashboard, job list, job search
    public ResultObject getAllJobs() {
        return new ResultObject(
            "Success",
            200,
            jobRepository.findAll(Pageable.unpaged()).toList()
        );
    }
    @GetMapping("/{id}") /// profile view, profile register
    public ResultObject getJobById(@PathVariable Long id) {
        Job job = jobRepository.findById(id);
        if (job != null) {
            return new ResultObject("Success", 200, job);
        } else {
            return new ResultObject("Job not found", 404, null);
        }
    }
    @GetMapping("/manage/{companyId}") /// company profile, company job list
    public ResultObject getJobsByCompanyId(@PathVariable Long companyId, Pageable pageable) {
        List<Job> jobs = jobRepository.findByCompanyId(companyId);
        if (jobs != null && !jobs.isEmpty()) {
            return new ResultObject("Success", 200, jobs);
        } else {
            return new ResultObject("No jobs found for this company", 200, null);
        }
    }
    
}
