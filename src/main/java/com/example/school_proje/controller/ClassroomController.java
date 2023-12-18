package com.example.school_proje.controller;

import com.example.school_proje.dto.ClassroomDto;
import com.example.school_proje.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("classrooms")
public class ClassroomController {

    @Autowired
    ClassroomService classroomService;

    @PostMapping
    public ClassroomDto saveClassroom(@RequestBody ClassroomDto classroomDto){
        return classroomService.saveClassroom(classroomDto);
    }

    @GetMapping("filter/{schoolId}")
    public List<ClassroomDto> getClassroomBySchool(@PathVariable String schoolId){
        return classroomService.findClassroomBySchool(schoolId);
    }

    @GetMapping("{id}")
    public ClassroomDto getClassroom(@PathVariable String id){
        return classroomService.findClassroomById(id);
    }

    @GetMapping
    public List<ClassroomDto> getAllClassrooms(){
        return classroomService.findAllClassrooms();
    }
}
