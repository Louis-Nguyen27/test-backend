package com.example.demo.entity;

import com.example.demo.enumeration.TypeOfUser;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class User {
    private String username;
    @JsonIgnore
    private String password;

}
