package com.learning.controller;

import com.learning.model.BaseResponse;
import com.learning.model.StudentRegistration;
import com.learning.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/student")
    public BaseResponse registerStudent( @Valid @RequestBody StudentRegistration studentRegistration) {
        studentService.registerStudent(studentRegistration);
        return new BaseResponse(true,"Student Added");
    }
}
