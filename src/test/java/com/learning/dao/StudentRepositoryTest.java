package com.learning.dao;

import com.learning.model.Student;
import com.learning.model.StudentAddress;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    void testInsert() {

        List<Student> studentList = new ArrayList<>();

        for( int i = 0; i < 3; i++ ) {
            Student student = new Student();
            student.setName("john" + i );
            student.setAge(30 + i);
            student.setGender("male" + i);
            student.setDob(LocalDate.now().plusDays(i));

            StudentAddress studentAddress = new StudentAddress();
            studentAddress.setFlatNo(20 + i);
            studentAddress.setStreet("23, Antony Street" + i);
            studentAddress.setDistrict("madurai" + i);
            studentAddress.setState("tamil nadu" + i);
            studentAddress.setCountry("india" + i);

            student.setStudentAddress(studentAddress);
            studentAddress.setStudent(student);
            studentList.add(student);
        }

        assertTrue(studentRepository.findAll().size() == 0);
        studentList.stream().forEach( studentRepository::save );
        assertTrue(studentRepository.findAll().size() == 3);

        for( int i = 0; i < 3; i++ ) {
            Optional<Student> studentObject = studentRepository.findById(((long) i + 1));
            assertTrue(studentObject.isPresent());
            Student studentResult = studentObject.get();
            Student studentInput = studentList.get(i);
            assertTrue(studentResult.getName().equals(studentList.get(i).getName()));
            assertTrue(studentResult.getAge() == studentInput.getAge() );
            assertTrue(studentResult.getDob().equals(studentInput.getDob()));
            assertTrue(studentResult.getStudentAddress() != null);
            StudentAddress studentInputAddress = studentInput.getStudentAddress();
            assertTrue(studentResult.getStudentAddress().getStreet().equals(studentInputAddress.getStreet()));
            assertTrue(studentResult.getStudentAddress().getDistrict().equals(studentInputAddress.getDistrict()));
            assertTrue(studentResult.getStudentAddress().getState().equals(studentInputAddress.getState()));
            assertTrue(studentResult.getStudentAddress().getCountry().equals(studentInputAddress.getCountry()));
        }
    }
}