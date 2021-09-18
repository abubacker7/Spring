package com.learning.service;

import com.learning.model.StudentRegistration;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {

    public void registerStudent(StudentRegistration studentRegistration);

    public List<StudentRegistration> getStudents();

    public void deleteStudent(Long id);

    public void updateStudent(Long rollNo, StudentRegistration studentRegistration) throws Exception;
}
