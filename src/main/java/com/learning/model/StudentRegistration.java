package com.learning.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentRegistration {

    private Long rollNo;

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
