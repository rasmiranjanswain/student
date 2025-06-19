package com.student.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.student.entity.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

    Optional<Student> findByMobile(long mobile);

    // [JOIN]

    @Query(value = "Select * from student where student.name = 'puna'", nativeQuery = true)
    Student ShowAllWithNameStartsWithS();


}