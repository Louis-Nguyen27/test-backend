package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResultObject;
import com.example.demo.entity.Talent;
import com.example.demo.repository.TalentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/talent-profile")
public class TalentProfileController {
    private TalentRepository talentRepository;

    public TalentProfileController(TalentRepository talentRepository) {
        this.talentRepository = talentRepository;
    }

    @GetMapping("/")
    public ResultObject getProfile(@RequestParam Long talentId) {
        return new ResultObject(
            "Success",
            200,
            talentRepository.findById(talentId)
        );
    }

    @PostMapping("/edit")
    public ResultObject editProfile(@RequestBody Talent entity) {
        Talent existingTalent = talentRepository.findById(entity.getId());
        if (existingTalent == null) {
            return new ResultObject("Talent not found", 404, null);
        }
        talentRepository.save(entity);
        return new ResultObject("Profile updated successfully", 201, entity);
    }
    
    
}
