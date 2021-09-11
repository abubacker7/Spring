package com.learning.model;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class StudentRegistration {

    @NotNull(message = "Name can't be null")
    @NotBlank(message = "Name can't be blank")
    private String name;

    private int age;

    private String gender;

    private LocalDate dob;

    private Integer flatNo;

    private String street;

    private String district;

    private String state;

    private String country;
}
