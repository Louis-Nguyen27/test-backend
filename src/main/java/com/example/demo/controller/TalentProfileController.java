package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResultObject;
import com.example.demo.entity.Talent;
import com.example.demo.repository.TalentRepository;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/{talentId}")
    public ResultObject getProfile(@PathVariable Long talentId) {
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
