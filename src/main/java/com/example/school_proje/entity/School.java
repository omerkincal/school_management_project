package com.example.school_proje.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int schoolId;
    private String schoolName;
    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    private List<Classroom> classroomList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "managerId")
    private Manager manager;

    public School() {
    }

    public School(int schoolId, String schoolName, List<Classroom> classroomList, Manager manager) {
        this.schoolId = schoolId;
        this.schoolName = schoolName;
        this.classroomList = classroomList;
        this.manager = manager;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }


    public List<Classroom> getClassroomList() {
        return classroomList;
    }

    public void setClassroomList(List<Classroom> classroomList) {
        this.classroomList = classroomList;
    }



    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
