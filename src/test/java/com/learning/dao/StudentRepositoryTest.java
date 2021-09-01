package com.learning.dao;

import com.learning.model.Student;
import com.learning.model.StudentAddress;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    void testInsert() {
        Student student = new Student();
        student.setRollNo(234L);
        student.setName("john");
        student.setAge(30);
        student.setGender("male");
        student.setDob("24/08/1990");

        StudentAddress studentAddress = new StudentAddress();
        studentAddress.setId(123L);
        studentAddress.setStreet("23, Antony Street");
        studentAddress.setDistrict("madurai");
        studentAddress.setState("tamil nadu");
        studentAddress.setCountry("india");

        student.setStudentAddress(studentAddress);
        studentAddress.setStudent(student);

        assertTrue(studentRepository.findAll().size() == 0);
        studentRepository.save(student);
        assertTrue(studentRepository.findAll().size() == 1);
    }
}