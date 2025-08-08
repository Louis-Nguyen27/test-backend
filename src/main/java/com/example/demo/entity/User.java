package com.example.demo.entity;

import com.example.demo.enumeration.TypeOfUser;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@MappedSuperclass
public class User {
    private String username;
    @JsonIgnore
    private String password;

}
