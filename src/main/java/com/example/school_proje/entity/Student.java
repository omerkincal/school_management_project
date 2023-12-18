package com.example.school_proje.entity;

import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int studentId;
    private String studentName;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "classroomId")
    private Classroom classroom;


    public Student() {
    }

    public Student(int studentId, String studentName, Classroom classroom) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.classroom = classroom;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}
