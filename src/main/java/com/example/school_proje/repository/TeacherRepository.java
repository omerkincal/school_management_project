package com.example.school_proje.repository;

import com.example.school_proje.entity.Classroom;
import com.example.school_proje.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    List<Teacher> findAllByClassroom_ClassroomId(int classroomId);
}
