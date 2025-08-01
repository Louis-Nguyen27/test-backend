package com.example.demo.converter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.enumeration.EducationClassification;
import com.example.demo.utils.UtilsType.Education;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class EducationListConverter implements AttributeConverter<List<Education>, String> {

    @Override
    public String convertToDatabaseColumn(List<Education> attribute) {
        if (attribute == null || attribute.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Education education : attribute) {
            sb.append(education.getSchoolName()).append(":")
              .append(education.getStartTime()).append(":")
              .append(education.getEndTime()).append(":")
              .append(education.getClassification().toString()).append(":")
              .append(education.getLocation()).append(":")
              .append(education.getMajor()).append(":")
              .append(education.getCredits()).append(",");
        }
        return sb.substring(0, sb.length() - 1); // Remove the last comma
    }

    @Override
    public List<Education> convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return List.of();
        }
        String[] educationsArray = dbData.split(",");
        return Arrays.stream(educationsArray)
                .map(eduStr -> {
                    String[] parts = eduStr.split(":");
                    if (parts.length == 7) {
                        Education education = new Education();
                        education.setSchoolName(parts[0]);
                        education.setStartTime(parts[1]);
                        education.setEndTime(parts[2]);
                        education.setClassification(EducationClassification.valueOf(parts[3]));
                        education.setLocation(parts[4]);
                        education.setMajor(parts[5]);
                        education.setCredits(Float.parseFloat(parts[6]));
                        return education;
                    }
                    return null; // Handle invalid format
                })
                .filter(edu -> edu != null) // Filter out any null values
                .collect(Collectors.toList());
    }
    
}
