package com.example.school_proje.controller;

import com.example.school_proje.dto.SchoolDto;
import com.example.school_proje.dto.TeacherDto;
import com.example.school_proje.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("teachers")
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @PostMapping
    public TeacherDto saveTeacher(@RequestBody TeacherDto teacherDto){
        return teacherService.saveTeacher(teacherDto);
    }

   @GetMapping("filter/{classroomId}")
    public List<TeacherDto> getTeachersBySchool(@PathVariable String classroomId){
        return teacherService.getTeachersByClassroom(classroomId);
    }

    @GetMapping("{id}")
    public TeacherDto getTeacher(@PathVariable String id){
        return teacherService.findTeacherById(id);
    }

    @GetMapping
    public List<TeacherDto> getAllTeachers(){
        return teacherService.findAllTeachers();
    }
}
