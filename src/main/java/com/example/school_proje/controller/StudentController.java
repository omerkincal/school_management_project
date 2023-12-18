package com.example.school_proje.controller;

import com.example.school_proje.dto.StudentDto;
import com.example.school_proje.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public StudentDto saveStudent(@Valid @RequestBody StudentDto studentDto){
        return studentService.saveStudent(studentDto);
    }

    @GetMapping("filter/{id}")
    public List<StudentDto> getStudentsByClassroom(@PathVariable String id){
        return studentService.getStudentByClassroom(id);
    }

    @GetMapping("{id}")
    public StudentDto getStudent(@PathVariable String id){
        return studentService.findStudentById(id);
    }

    @GetMapping
    public List<StudentDto> getAllStudents(){
        return studentService.findAllStudents();
    }

    @DeleteMapping("{id}")
    public String deleteStudent(@PathVariable String id){
        return studentService.deleteStudent(id);
    }
}
