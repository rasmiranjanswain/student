package com.student.controller;

import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Student;
import com.student.service.StudentService;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@Slf4j
public class StudentController {

    @Autowired
    private StudentService service;


    @PostMapping("/add")
    public String postMethodName(@RequestBody Student student) {
        
        log.info("Before request: " + student.toString());

        service.addStudent(student);
        
        log.info("final response: " + student.toString());
        return "user with " + student.getName() + "added";
    }

    @GetMapping("/getAll/{page}")
    public Page<Student> getMethodName(@PathVariable int page) {
        return service.getAllUser(page);
    }

    @GetMapping("/get/{id}")
    public Optional<Student> getStudent(@PathVariable int id) {
        return service.getStudent(id);
    }

    @PutMapping("update/{id}")
    public Student putMethodName(@PathVariable int id,@RequestBody Student student) {
        return service.updateStudent(id, student);
    }

    @GetMapping("/getByMobile/{mobile}")
    public Optional<Student> getStudentByNumber(@PathVariable long mobile) {
        return service.getStudentByMobile(mobile);
    }
        
    
}
