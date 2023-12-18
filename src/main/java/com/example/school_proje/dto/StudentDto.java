package com.example.school_proje.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class StudentDto {
    public int studentId;
    @NotEmpty(message = "ismi doldur laa")
    public String studentName;
    @NotNull(message = "classroomId boş olamaz")
    @Min(value = 2, message = "classroomId 1'den küçük olamaz")
    public int classroomId;
}
