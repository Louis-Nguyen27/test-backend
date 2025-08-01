package com.example.demo.utils;

import com.example.demo.enumeration.EducationClassification;
import com.example.demo.enumeration.Experience;

import lombok.Getter;
import lombok.Setter;

public class UtilsType {
    @Getter
    @Setter
    public static class Skill {
        private String name; // Skill name
        private Experience experience; // Skill experience level
    }

    @Getter
    @Setter
    public static class JobExperience {
        private String title; // Job title
        private Experience experience;
    }
    @Getter
    @Setter
    public static class CustomDate {
        private String date;
        private Integer hour;
        private Integer minute;
    }
    @Getter
    @Setter
    public static class Education {
        private String schoolName;
        private String startTime;
        private String endTime;
        private EducationClassification classification;
        private String location;
        private String major;
        private Float credits;
    }
}
