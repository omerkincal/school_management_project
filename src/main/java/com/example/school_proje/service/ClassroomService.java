package com.example.school_proje.service;

import com.example.school_proje.dto.ClassroomDto;
import com.example.school_proje.dto.StudentDto;
import com.example.school_proje.entity.Classroom;
import com.example.school_proje.entity.Student;
import com.example.school_proje.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassroomService {

    @Autowired
    ClassroomRepository classroomRepository;

    @Autowired
    SchoolService schoolService;

    @Autowired
    StudentService studentService;

    @Autowired
    TeacherService teacherService;

    public ClassroomDto saveClassroom(ClassroomDto classroomDto) {
        Classroom classroom = classroomRepository.save(toEntity(classroomDto));
        return toDto(classroom);
    }

    public ClassroomDto findClassroomById(String id) {
        return toDto(classroomRepository.findById(Integer.parseInt(id)).get());
    }

    public List<ClassroomDto> findAllClassrooms() {
        List<ClassroomDto> classroomDtoList  = new ArrayList<>();
        for (Classroom classroom: classroomRepository.findAll()) {
            classroomDtoList.add(toDto(classroom));
        }
        return classroomDtoList;
    }


    public Classroom toEntity(ClassroomDto dto){
        Classroom classroom = new Classroom();
        classroom.setClassroomName(dto.classroomName);
        classroom.setSchool(schoolService.findSchoolEntityById(String.valueOf(dto.schoolId)));
        return classroom;
    }

    public ClassroomDto toDto(Classroom entity){
        ClassroomDto dto = new ClassroomDto();
        dto.classroomId = entity.getClassroomId();
        dto.classroomName = entity.getClassroomName();
        dto.schoolId = entity.getSchool().getSchoolId();
        dto.studentList = studentService.toDtoList(entity.getStudentList());
        dto.teacherList = teacherService.toDtoList(entity.getTeacherList());
        return dto;
    }

    /*private List<StudentDto> toDtoList(List<Student> studentList) {
        List<StudentDto> studentDtoList = new ArrayList<>();
        for (Student student:studentList) {
            studentDtoList.add(studentService.findStudentById(String.valueOf(student.getStudentId())));
        }
        return studentDtoList;
    }*/


    public Classroom findClassroomEntityById(int classroomId) {
        return classroomRepository.findById(classroomId).get();
    }

    public List<ClassroomDto> findClassroomBySchool(String schoolId) {
        return toDtoList(classroomRepository.getAllBySchool_SchoolId(Integer.parseInt(schoolId)));
    }

    private List<ClassroomDto> toDtoList(List<Classroom> classroomList) {
        List<ClassroomDto> classroomDtoList = new ArrayList<>();
        for (Classroom classroom: classroomList) {
            classroomDtoList.add(toDto(classroom));
        }
        return classroomDtoList;
    }
}
