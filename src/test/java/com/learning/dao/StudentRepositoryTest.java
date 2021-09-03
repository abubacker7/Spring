package com.learning.dao;

import com.learning.model.Student;
import com.learning.model.StudentAddress;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    List<Student> studentList;
    List<String> studentNameList;

    @BeforeAll
    void setup() {
        this.studentList = new ArrayList<>();

        this.studentNameList = new ArrayList<String>( List.of("john", "ram", "som"));

        int i = 0;
        for ( String stdName : studentNameList ) {
            Student student = new Student();
            student.setName(stdName);
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
            i++;
        }
    }

    @Test
    @Order(1)
    void testInsert() {

        assertTrue(studentRepository.findAll().size() == 0);
        studentList.stream().forEach( studentRepository::save );
        assertTrue(studentRepository.findAll().size() == 3);

        int i = 0;
        for ( String stdName : studentNameList ) {
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
            i++;
        }
    }

    @Test
    @Order(2)
    void testUpdate() {
        if ( studentList.size() > 1 ) {
            studentList.get(1).setAge(50);
            studentRepository.save(studentList.get(1));
            assertTrue(studentList.get(1).getAge() == 50 );
        }
    }

    @Test
    @Order(3)
    void testDelete() {
        boolean isStudentPresent = studentRepository.findById(1L).isPresent();
        if ( isStudentPresent ) {
            studentRepository.deleteById(1L);
        } else {
            assertTrue(studentRepository.findById(1L).isEmpty());
        }
    }
}