package com.learning.model;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "roll_no")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rollNo;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "gender")
    private String gender;

    @Column(name = "dob")
    private String dob;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sudent_address_id")
    private StudentAddress studentAddress;

    public Student() {
    }

    public Student(Long rollNo, String name, int age, String gender, String dob, StudentAddress studentAddress) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.dob = dob;
        this.studentAddress = studentAddress;
    }

    public Long getRollNo() {
        return rollNo;
    }

    public void setRollNo(Long rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public StudentAddress getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(StudentAddress studentAddress) {
        this.studentAddress = studentAddress;
    }
}
