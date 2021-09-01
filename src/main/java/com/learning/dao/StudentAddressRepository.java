package com.learning.dao;

import com.learning.model.StudentAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentAddressRepository extends JpaRepository<StudentAddress, Long> {

}
