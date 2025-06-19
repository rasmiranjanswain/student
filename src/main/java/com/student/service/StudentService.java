package com.student.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public String addStudent(Student student){
        repository.save(student);
        return "added";
    }

    public Page<Student> getAllUser(int page){
        PageRequest pageRequest 
            = PageRequest
                .of(page, 2, Sort.by("name").ascending());
        return repository.findAll(pageRequest);
    }

    public Optional<Student> getStudent(int id){
        return repository.findById(id);
    }

    public Optional<Student> getStudentByMobile(long mobile){
        return repository.findByMobile(mobile);
    }

    public Student updateStudent(int id, Student student){
        Student s = repository.findById(id).orElse(null);

        if (Objects.nonNull(s)){
            s.setName(student.getName());
            s.setMobile(student.getMobile());
            return repository.save(s);
        }

        return null;
    }

}
