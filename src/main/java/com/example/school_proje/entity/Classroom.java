package com.example.school_proje.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int classroomId;
    private String classroomName;
    @OneToMany(mappedBy = "classroom",cascade = CascadeType.ALL)
    private List<Student> studentList;

    @OneToMany(mappedBy = "classroom",cascade = CascadeType.ALL)
    private List<Teacher> teacherList;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "schoolId")
    private School school;


    public Classroom() {
    }

    public Classroom(int classroomId, String classroomName, List<Student> studentList, List<Teacher> teacherList, School school) {
        this.classroomId = classroomId;
        this.classroomName = classroomName;
        this.studentList = studentList;
        this.teacherList = teacherList;
        this.school = school;
    }

    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}

