package com.learning.service;

import com.learning.dao.StudentRepository;
import com.learning.model.Student;
import com.learning.model.StudentAddress;
import com.learning.model.StudentRegistration;
import lombok.Builder;
//import org.apache.velocity.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ModelMapper modelMapper;

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

    @Override
    public List<StudentRegistration> getStudents() {

        logger.info("Start getStudents");

        List<Student> studentList = studentRepository.findAll();

        List<StudentRegistration> studentRegistrationList = studentList.stream().map(student -> this.modelMapper.map(student, StudentRegistration.class)).collect(Collectors.toList());

//        List<StudentRegistration> studentRegistrationList = studentList.stream().map(student -> {
//            return StudentRegistration.builder().rollNo(student.getRollNo()).name(student.getName()).age(student.getAge()).gender(student.getGender()).dob(student.getDob()).flatNo(student.getStudentAddress().getFlatNo()).street(student.getStudentAddress().getStreet()).district(student.getStudentAddress().getDistrict()).state(student.getStudentAddress().getDistrict()).state(student.getStudentAddress().getState()).country(student.getStudentAddress().getCountry()).build();
//        }).collect(Collectors.toList());
        logger.info("End getStudents");
        return studentRegistrationList;
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void updateStudent(Long rollNo, StudentRegistration studentRegistration) throws Exception {
        Student student = studentRepository.findById(rollNo).orElseThrow(() -> new Exception("Student not found for this id :: " + rollNo));

        student.setName(studentRegistration.getName());
        student.setAge(studentRegistration.getAge());
        student.setDob(studentRegistration.getDob());
        student.setGender(studentRegistration.getGender());
        student.getStudentAddress().setFlatNo(studentRegistration.getFlatNo());
        student.getStudentAddress().setStreet(studentRegistration.getStreet());
        student.getStudentAddress().setDistrict(studentRegistration.getDistrict());
        student.getStudentAddress().setState(studentRegistration.getState());
        student.getStudentAddress().setCountry(studentRegistration.getCountry());

        studentRepository.save(student);
    }
}
