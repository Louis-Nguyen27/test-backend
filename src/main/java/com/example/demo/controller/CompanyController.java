package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResultObject;
import com.example.demo.entity.Company;
import com.example.demo.repository.CompanyRepository;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/companies")
public class CompanyController {
    private CompanyRepository companyRepository;
    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping("/all")
    public ResultObject getAllCompanies() {
        return new ResultObject(
            "Success",
            200,
            companyRepository.findAll(Pageable.unpaged()).toList()
        );
    }

    @GetMapping("/{id}")
    public ResultObject getCompanyById(@PathVariable Long id) {
        Company company = companyRepository.findById(id);
        if (company != null) {
            return new ResultObject("Success", 200, company);
        } else {
            return new ResultObject("Company not found", 404, null);
        }
    }


    
}
