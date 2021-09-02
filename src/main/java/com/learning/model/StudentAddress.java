package com.learning.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student_address")
public class StudentAddress {

    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long addressId;

    @Column(name = "flat_no", nullable = false, length = 10)
    private Integer flatNo;

    @Column(name = "street", nullable = false, length = 100)
    private String street;

    @Column(name = "district", nullable = false, length = 10)
    private String district;

    @Column(name = "state", nullable = false, length = 20)
    private String state;

    @Column(name = "country", nullable = false, length = 50)
    private String country;

    @OneToOne
    @MapsId
    @JoinColumn(name = "address_id")
    private Student student;
}
