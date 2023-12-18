package com.example.school_proje.service;

import com.example.school_proje.dto.SchoolDto;
import com.example.school_proje.entity.School;
import com.example.school_proje.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolService {

    @Autowired
    SchoolRepository schoolRepository;
    @Autowired
    ManagerService managerService;

    public SchoolDto saveSchool(SchoolDto schoolDto) {
        return toDto(schoolRepository.save(toEntity(schoolDto)));
    }

    public SchoolDto findSchoolById(String id) {
        return toDto(schoolRepository.findById(Integer.parseInt(id)).get());
    }

    public List<SchoolDto> getAllSchools() {
        List<SchoolDto> schoolDtoList = new ArrayList<>();
        for (School school:schoolRepository.findAll()) {
            schoolDtoList.add(toDto(school));
        }
        return schoolDtoList;
    }


    public School toEntity(SchoolDto schoolDto){
        School school = new School();
        school.setSchoolName(schoolDto.schoolName);
        school.setManager(managerService.findManagerById(String.valueOf(schoolDto.managerId)));

        return school;
    }

    public SchoolDto toDto(School entity){
        SchoolDto school = new SchoolDto();
        school.schoolName = entity.getSchoolName();
        school.managerId = entity.getManager().getManagerId();
        school.schoolId = entity.getSchoolId();
        return school;
    }

    public School findSchoolEntityById(String id) {
        return schoolRepository.findById(Integer.parseInt(id)).get();
    }
}
