package com.example.demo.converter;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.enumeration.Experience;
import com.example.demo.utils.UtilsType.JobExperience;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class JobExperienceListConverter implements AttributeConverter<List<JobExperience>, String> {
    @Override
    public String convertToDatabaseColumn(List<JobExperience> attribute) {
        if (attribute == null || attribute.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (JobExperience jobExperience : attribute) {
            sb.append(jobExperience.getTitle()).append(":").append(jobExperience.getExperience().toString()).append(",");
        }
        return sb.substring(0, sb.length() - 1); // Remove the last comma
    }
    @Override
    public List<JobExperience> convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return List.of();
        }
        String[] jobExperiencesArray = dbData.split(",");
        List<JobExperience> jobExperiences = new ArrayList<>();
        for (String jobExperienceStr : jobExperiencesArray) {
            String[] parts = jobExperienceStr.split(":");
            if (parts.length == 2) {
                JobExperience jobExperience = new JobExperience();
                jobExperience.setTitle(parts[0]);
                jobExperience.setExperience(Experience.valueOf(parts[1]));
                jobExperiences.add(jobExperience);
            }
        }
        return jobExperiences;
    }
    
}
