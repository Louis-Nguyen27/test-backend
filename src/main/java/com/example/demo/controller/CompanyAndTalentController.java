package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CompanyAndTalentDto;
import com.example.demo.dto.ResultObject;
import com.example.demo.entity.Company;
import com.example.demo.entity.CompanyAndTalent;
import com.example.demo.entity.Talent;
import com.example.demo.repository.CompanyAndTalentRepository;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.TalentRepository;

import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/company-and-talent")
public class CompanyAndTalentController {
    private CompanyAndTalentRepository companyAndTalentRepository;
    private CompanyRepository companyRepository;
    private TalentRepository talentRepository;
    public CompanyAndTalentController(
        CompanyAndTalentRepository companyAndTalentRepository,
        CompanyRepository companyRepository,
        TalentRepository talentRepository
    ) {
        this.companyAndTalentRepository = companyAndTalentRepository;
        this.companyRepository = companyRepository;
        this.talentRepository = talentRepository;
    }

    @GetMapping("/all")
    public ResultObject getAllRelationShip() {
        return new ResultObject(
            "Success",
            200,
            companyAndTalentRepository.findAll(Pageable.unpaged()).toList()
        );
    }

    @GetMapping("/{companyId}/{talentId}")
    public ResultObject getRelationShip(@PathVariable Long companyId, @PathVariable Long talentId) {
        return new ResultObject(
            "Success",
            200,
            companyAndTalentRepository.findByCompanyIdAndTalentId(companyId, talentId)
        );
    }
    

    @PostMapping("/save-talent")
    public ResultObject saveTalent(@RequestBody CompanyAndTalentDto body) {
        CompanyAndTalent companyAndTalent = companyAndTalentRepository.findByCompanyIdAndTalentId(body.getCompanyId(), body.getTalentId());
        String groupName = body.getGroupName() == null ? "Default" : body.getGroupName();
        if (companyAndTalent == null) {
            companyAndTalent = new CompanyAndTalent();
            Company company = this.companyRepository.findById(body.getCompanyId());
            Talent talent = this.talentRepository.findById(body.getTalentId());
            if (company == null || talent == null) {
                throw new IllegalArgumentException("Company or Talent not found");
            }

            companyAndTalent.setCompany(company);
            companyAndTalent.setTalent(talent);
            companyAndTalent.setGroupName(groupName);
        } else {
            companyAndTalent.setGroupName(groupName);
        }
        companyAndTalentRepository.save(companyAndTalent);
        
        return new ResultObject("Success", 200, companyAndTalent);
    }
    
}
