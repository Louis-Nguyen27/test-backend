package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResultObject;
import com.example.demo.entity.Talent;
import com.example.demo.repository.TalentRepository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/talent-information")
public class TalentInformationController {
    private TalentRepository talentRepository;
    public TalentInformationController(TalentRepository talentRepository) {
        this.talentRepository = talentRepository;
    }

    @GetMapping("/all")
    public ResultObject getAllTalents() { /// Get latest talents, get related talents,...
        return new ResultObject(
            "Success",
            200,
            talentRepository.findAll(Pageable.unpaged()).toList()
        );
    }
    @GetMapping("/{id}")
    public ResultObject getTalentById(@PathVariable Long id) {
        Talent talent = talentRepository.findById(id);
        if (talent != null) {
            return new ResultObject("Success", 200, talent);
        } else {
            return new ResultObject("Talent not found", 404, null);
        }
    }
    
}
