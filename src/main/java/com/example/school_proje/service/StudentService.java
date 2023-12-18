package com.example.school_proje.service;

import com.example.school_proje.dto.StudentDto;
import com.example.school_proje.entity.Student;
import com.example.school_proje.exception.EmailAlreadyExists;
import com.example.school_proje.exception.ResourceNotFoundException;
import com.example.school_proje.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    StudentRepository studentRepository;

    ClassroomService classroomService;

    public StudentDto saveStudent(StudentDto studentDto) {
        Student student = studentRepository.findStudentByStudentName(studentDto.studentName);

        if (student != null){
            throw new EmailAlreadyExists("Email Already exists for User");
        }

        student = studentRepository.save(toEntity(studentDto));

        return toDto(student);
    }

    public StudentDto findStudentById(String id) {
        return toDto(studentRepository.findById(Integer.parseInt(id))
                .orElseThrow(
                        () -> new ResourceNotFoundException(id, "User", "id" )
                ));
    }

    public List<StudentDto> findAllStudents() {
        return toDtoList(studentRepository.findAll());
    }

    public StudentDto toDto(Student entity){
        StudentDto dto = new StudentDto();
        dto.classroomId = entity.getClassroom().getClassroomId();
        dto.studentId = entity.getStudentId();
        dto.studentName = entity.getStudentName();
        return dto;
    }


    public Student toEntity(StudentDto dto){
        Student entity = new Student();
        entity.setClassroom(classroomService.findClassroomEntityById(dto.classroomId));
        entity.setStudentName(dto.studentName);
        return entity;
    }

    public List<StudentDto> toDtoList(List<Student> studentList) {
        List<StudentDto> studentDtoList = new ArrayList<>();
        for (Student student: studentList) {
            studentDtoList.add(toDto(student));
        }
        return studentDtoList;
    }

    public String deleteStudent(String id) {
        studentRepository.deleteById(Integer.parseInt(id));
        return "Başarılı bir şekilde silindi";
    }

    public List<StudentDto> getStudentByClassroom(String id) {
        return toDtoList(studentRepository.findAllByClassroom_ClassroomId(Integer.parseInt(id)));
    }
}
