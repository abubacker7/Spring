package com.learning.dao;

import com.learning.model.Student;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface StudentRepository extends JpaRepository<Student, Long>, JpaSpecificationExecutor<Student> {

    @Query(value = "SELECT max(age) FROM Student")
    Integer getAgePerStudent();

    @Query("select name from Student std where std.age >= :ageStart AND std.age <= :ageEnd")
    List<String> getStudentAgeBetween( @Param("ageStart") int ageStart, @Param("ageEnd") int ageEnd );
}
