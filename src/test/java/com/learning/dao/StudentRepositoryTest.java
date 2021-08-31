package com.learning.dao;

import com.learning.model.Student;
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
        assertTrue(studentRepository.findAll().size() == 0);
        studentRepository.save(new Student(1, "Abu"));
        assertTrue(studentRepository.findAll().size() == 1);
        assertTrue(studentRepository.findById(1).isPresent());
        assertTrue(studentRepository.findById(1).get().getName().equalsIgnoreCase("abu") );
    }
}