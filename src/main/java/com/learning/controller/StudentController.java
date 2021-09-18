package com.learning.controller;

import com.learning.model.BaseResponse;
import com.learning.model.StudentRegistration;
import com.learning.service.StudentService;
import com.learning.service.StudentServiceImpl;
//import org.apache.velocity.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1")
@CrossOrigin("*")
public class StudentController {

    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    StudentServiceImpl studentService;

    @PostMapping("/student")
    public BaseResponse registerStudent( @Valid @RequestBody StudentRegistration studentRegistration) {
        studentService.registerStudent(studentRegistration);
        return new BaseResponse(true,"Student Added");
    }

    @GetMapping("/student")
    public List<StudentRegistration> getStudentService() {
        logger.info("starts getStudentService");
        List<StudentRegistration> studentRegistrationList = studentService.getStudents();
        logger.info("End getStudentService");
        return studentRegistrationList;
    }

    @DeleteMapping(value = "/student/{id}")
    public ResponseEntity<Long> deleteStudent( @Valid @PathVariable Long id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @RequestMapping(value="/student/{id}", produces = "application/json", method=RequestMethod.PUT)
    public BaseResponse updateStudent(@PathVariable(value = "id") Long rollNo, @Valid @RequestBody StudentRegistration studentRegistration) throws Exception {
        studentService.updateStudent(rollNo, studentRegistration);
        return new BaseResponse(true,"Student Update");
    }
}
