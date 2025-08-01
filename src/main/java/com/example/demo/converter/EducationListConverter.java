package com.example.demo.converter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.enumeration.EducationClassification;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class EducationListConverter implements AttributeConverter<List<EducationClassification>, String> {

    @Override
    public String convertToDatabaseColumn(List<EducationClassification> attribute) {
        if (attribute == null || attribute.isEmpty()) {
            return null;
        }
        return attribute.stream()
                        .map(Enum::name)
                        .collect(Collectors.joining(","));
    }

    @Override
    public List<EducationClassification> convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return List.of();
        }
        return Arrays.stream(dbData.split(","))
                     .map(EducationClassification::valueOf)
                     .collect(Collectors.toList());
    }
    
}
