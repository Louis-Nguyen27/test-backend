package com.example.demo.converter;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.enumeration.Experience;
import com.example.demo.utils.UtilsType.Skill;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class SkillListConverter implements AttributeConverter<List<Skill>, String>{
    @Override
    public String convertToDatabaseColumn(List<Skill> attribute) {
        if (attribute == null || attribute.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Skill skill : attribute) {
            sb.append(skill.getName()).append(":").append(skill.getExperience().toString()).append(",");
        }
        return sb.substring(0, sb.length() - 1); // Remove the last comma
    }
    @Override
    public List<Skill> convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return List.of();
        }
        String[] skillsArray = dbData.split(",");
        List<Skill> skills = new ArrayList<>();
        for (String skillStr : skillsArray) {
            String[] parts = skillStr.split(":");
            if (parts.length == 2) {
                Skill skill = new Skill();
                skill.setName(parts[0]);
                skill.setExperience(Experience.valueOf(parts[1]));
                skills.add(skill);
            }
        }
        return skills;
    }
}
