package com.example.demo.controller;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResultObject;
import com.example.demo.entity.Job;
import com.example.demo.repository.JobRepository;

@RestController
@RequestMapping("/jobs")
public class JobController {
    private JobRepository jobRepository;
    public JobController(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }
    @GetMapping("/all")
    public ResultObject getAllJobs() {
        return new ResultObject(
            "Success",
            200,
            jobRepository.findAll(Pageable.unpaged()).toList()
        );
    }
}
