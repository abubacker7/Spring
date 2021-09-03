package com.learning.dao;

import com.learning.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
interface StudentRepository extends JpaRepository<Student, Long>{

//    @Modifying
//    @Query("DELETE Student std WHERE std.roll_no = ?1")
//    void deleteByStudentRollNo(int rollNo);
}
