package com.learning.model;

import javax.persistence.*;

@Entity
@Table(name = "student_address")
public class StudentAddress {

    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressId;

    @Column(name = "street")
    private String street;

    @Column(name = "district")
    private String district;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "studentAddress")
    private Student student;

    public StudentAddress() {
    }

    public StudentAddress(Long addressId, String street, String district, String state, String country, Student student) {
        this.addressId = addressId;
        this.street = street;
        this.district = district;
        this.state = state;
        this.country = country;
        this.student = student;
    }

    public Long getId() {
        return addressId;
    }

    public void setId(Long addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
