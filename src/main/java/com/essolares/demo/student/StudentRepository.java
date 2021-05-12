package com.essolares.demo.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository 
    extends JpaRepository<Student,Long>{

    @Query("SELECT s FROM com.essolares.demo.student.Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}
