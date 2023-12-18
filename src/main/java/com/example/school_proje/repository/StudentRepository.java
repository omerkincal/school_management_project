package com.example.school_proje.repository;

import com.example.school_proje.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
   List<Student> findAllByClassroom_ClassroomId(int classroomId);
   Student findStudentByStudentName(String name);
}
