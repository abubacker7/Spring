package com.learning.dao;

import com.learning.model.Student;
import com.learning.model.StudentAddress;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    void testInsert() {
        Student student = new Student();
        student.setName("john");
        student.setAge(30);
        student.setGender("male");
        student.setDob(LocalDate.now());

        StudentAddress studentAddress = new StudentAddress();
        studentAddress.setFlatNo(20);
        studentAddress.setStreet("23, Antony Street");
        studentAddress.setDistrict("madurai");
        studentAddress.setState("tamil nadu");
        studentAddress.setCountry("india");

        student.setStudentAddress(studentAddress);
        studentAddress.setStudent(student);

        assertTrue(studentRepository.findAll().size() == 0);
        studentRepository.save(student);
        assertTrue(studentRepository.findAll().size() == 1);
        Optional<Student> studentObject = studentRepository.findById(1L);
        assertTrue(studentObject.isPresent());
        Student studentResult = studentObject.get();
        assertTrue(studentResult.getName().equals(student.getName()));
        assertTrue(studentResult.getAge() == student.getAge() );
        assertTrue(studentResult.getDob().equals(student.getDob()));
        assertTrue(studentResult.getStudentAddress() != null);
        assertTrue(studentResult.getStudentAddress().getStreet().equals(studentAddress.getStreet()));
        assertTrue(studentResult.getStudentAddress().getDistrict().equals(studentAddress.getDistrict()));
        assertTrue(studentResult.getStudentAddress().getState().equals(studentAddress.getState()));
        assertTrue(studentResult.getStudentAddress().getCountry().equals(studentAddress.getCountry()));
    }
}