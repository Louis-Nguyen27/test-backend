package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Talent;
import com.example.demo.repository.TalentRepository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/talent-information")
public class TalentInformationController {
    private TalentRepository talentRepository;
    public TalentInformationController(TalentRepository talentRepository) {
        this.talentRepository = talentRepository;
    }

    @GetMapping("/all")
    public List<Talent> getAllTalents() {
        return talentRepository.findAll(Pageable.unpaged()).toList();
    }
    
}
