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

        studentResult.setAge(40);
        assertTrue(studentResult.getAge() == 40);

        studentRepository.deleteAll();
        assertTrue(studentRepository.findAll().size() == 0);

        Student student1 = new Student();
        student1.setName("ram");
        student1.setAge(32);
        student1.setGender("male");
        student1.setDob(LocalDate.now());

        StudentAddress studentAddress1 = new StudentAddress();
        studentAddress1.setFlatNo(67);
        studentAddress1.setStreet("54, ram Street");
        studentAddress1.setDistrict("chennai");
        studentAddress1.setState("kerala");
        studentAddress1.setCountry("india");

        student1.setStudentAddress(studentAddress1);
        studentAddress1.setStudent(student1);


        Student student2 = new Student();
        student2.setName("sam");
        student2.setAge(24);
        student2.setGender("male");
        student2.setDob(LocalDate.now());

        StudentAddress studentAddress2 = new StudentAddress();
        studentAddress2.setFlatNo(22);
        studentAddress2.setStreet("54, ok Street");
        studentAddress2.setDistrict("sivagangai");
        studentAddress2.setState("tamil nadu");
        studentAddress2.setCountry("india");

        student2.setStudentAddress(studentAddress2);
        studentAddress2.setStudent(student2);


        Student student3 = new Student();
        student3.setName("lara");
        student3.setAge(28);
        student3.setGender("female");
        student3.setDob(LocalDate.now());

        StudentAddress studentAddress3 = new StudentAddress();
        studentAddress3.setFlatNo(22);
        studentAddress3.setStreet("78, line Street");
        studentAddress3.setDistrict("salem");
        studentAddress3.setState("tamil nadu");
        studentAddress3.setCountry("india");

        student3.setStudentAddress(studentAddress3);
        studentAddress3.setStudent(student3);

        List<Optional<Student>> studentList = new ArrayList<>();

        studentList.add(Optional.of(student1));
        studentList.add(Optional.of(student2));
        studentList.add(Optional.of(student3));

//        for( int i = 0; i < 3; i++  ) {
//            studentRepository.save(studentList.get(i));
//        }

//        for(Optional<Student> std : studentList) {
//            studentRepository.save(std);
//        }

//        for( Optional<Student> s : studentList ) {
//            studentRepository.save(student1);
//        }

//        studentList.stream().forEach( studentRepository::save );
    }
}