package com.example.school_proje.service;

import com.example.school_proje.dto.TeacherDto;
import com.example.school_proje.entity.School;
import com.example.school_proje.entity.Teacher;
import com.example.school_proje.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    ClassroomService classroomService;

    public TeacherDto saveTeacher(TeacherDto teacherDto) {
        return toDto(teacherRepository.save(toEntity(teacherDto)));
    }

    public TeacherDto findTeacherById(String id) {
        return toDto(teacherRepository.findById(Integer.parseInt(id)).get());
    }

    public List<TeacherDto> findAllTeachers() {
        List<TeacherDto> teacherDtoList = new ArrayList<>();
        for (Teacher teacher: teacherRepository.findAll()) {
            teacherDtoList.add(toDto(teacher));
        }
        return teacherDtoList;
    }



    private TeacherDto toDto(Teacher entity){
        TeacherDto dto = new TeacherDto();
        dto.teacherName = entity.getTeacherName();
        dto.branch = entity.getBranch();
        dto.teacherId = entity.getTeacherId();
        dto.classroomId = entity.getClassroom().getClassroomId();
        return dto;
    }

    private Teacher toEntity(TeacherDto dto){
        Teacher entity = new Teacher();
        entity.setTeacherName(dto.teacherName);
        entity.setBranch(dto.branch);
        entity.setClassroom(classroomService.findClassroomEntityById(dto.classroomId));
        return entity;
    }

    public List<TeacherDto> toDtoList(List<Teacher> teacherList) {
        List<TeacherDto> dtoList = new ArrayList<>();
        for (Teacher teacher : teacherList) {
            dtoList.add(toDto(teacher));
        }
        return dtoList;
    }
    public List<TeacherDto> getTeachersByClassroom(String classroomId) {
        return toDtoList(teacherRepository.findAllByClassroom_ClassroomId(Integer.parseInt(classroomId)));
    }
}
