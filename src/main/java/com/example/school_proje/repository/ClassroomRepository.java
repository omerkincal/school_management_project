package com.example.school_proje.repository;

import com.example.school_proje.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {
    List<Classroom> getAllBySchool_SchoolId(int schoolId);
}
