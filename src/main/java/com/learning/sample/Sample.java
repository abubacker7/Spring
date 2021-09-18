package com.learning.sample;

import com.learning.model.Student;
import com.learning.model.StudentAddress;

public class Sample {
    public static void main(String[] args) {
        Student student = Student.builder().name("jos").build();
        System.out.println(student.getName());
        System.out.println(student.getAge());
        try {
            System.out.println(student.getStudentAddress().getFlatNo());
        } catch( NullPointerException ex ) {
            System.out.println( "Address can't be null " + ex.getMessage() );
        }


        Student student1 = new Student();
        student1.setName("jos1");

        StudentAddress studentAddress = new StudentAddress();
        student1.setStudentAddress(studentAddress);
    }
}
