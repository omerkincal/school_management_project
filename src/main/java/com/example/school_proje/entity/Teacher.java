package com.example.school_proje.entity;

import jakarta.persistence.*;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int teacherId;
    private String teacherName;
    private String branch;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "classroomId")
    private Classroom classroom;

    public Teacher() {
    }

    public Teacher(int teacherId, String teacherName, String branch, Classroom classroom) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.branch = branch;
        this.classroom = classroom;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}
