package com.example.demo.entity;

import com.example.demo.enumeration.TypeOfUser;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String companyName;
    @Column
    private String email;
    @Column
    private String location;
    @Column
    private TypeOfUser type;

}
