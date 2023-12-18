package com.example.school_proje.controller;

import com.example.school_proje.dto.SchoolDto;
import com.example.school_proje.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("schools")
public class SchoolController {

    @Autowired
    SchoolService schoolService;
    @PostMapping
    public SchoolDto saveSchool(@RequestBody SchoolDto schoolDto){
        return schoolService.saveSchool(schoolDto);
    }


    @GetMapping("{id}")
    public SchoolDto getSchool(@PathVariable String id){
        return schoolService.findSchoolById(id);
    }

    @GetMapping
    public List<SchoolDto> getAllSchools(){
        return schoolService.getAllSchools();
    }
}
