package com.harsh.demo.entity;

import com.harsh.demo.entity.embedded.Address;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;

import java.time.LocalDate;

@Entity
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Past
    private LocalDate dob;

    @Embedded
    private Address address;
}
