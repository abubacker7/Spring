package com.learning.service;

import com.learning.dao.StudentRepository;
import com.learning.model.Student;
import com.learning.model.StudentAddress;
import com.learning.model.StudentRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void registerStudent(StudentRegistration studentRegistration) {

        Student student = new Student();
        StudentAddress studentAddress = new StudentAddress();

        student.setName(studentRegistration.getName());
        student.setAge(studentRegistration.getAge());
        student.setDob(studentRegistration.getDob());
        student.setGender(studentRegistration.getGender());

        studentAddress.setFlatNo(studentRegistration.getFlatNo());
        studentAddress.setStreet(studentRegistration.getStreet());
        studentAddress.setDistrict(studentRegistration.getDistrict());
        studentAddress.setState(studentRegistration.getState());
        studentAddress.setCountry(studentRegistration.getCountry());

        student.setStudentAddress(studentAddress);
        studentAddress.setStudent(student);

        studentRepository.save(student);
    }
}
