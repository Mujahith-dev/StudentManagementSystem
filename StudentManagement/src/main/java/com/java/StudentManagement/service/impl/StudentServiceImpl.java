package com.java.StudentManagement.service.impl;

import com.java.StudentManagement.dto.StudentDto;
import com.java.StudentManagement.entity.Student;
import com.java.StudentManagement.mapper.StudentMapper;
import com.java.StudentManagement.repository.StudentRepository;
import com.java.StudentManagement.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        System.out.println("Retrieved students: " + students);
        return students.stream()
                .map(StudentMapper::mapToStudentDto)
                .collect(Collectors.toList());
    }
}