package com.example.model;

import java.sql.Date;

public class StudentModel {
    private Integer id;
    private String studentId;
    private String studentName;
    private int studentAge;
    private String studentGender;
    private Date studentDate;
    private String academicPerformance;

    public StudentModel(Integer id, String studentId, String studentName, int studentAge, String studentGender,
            Date studentDate, String academicPerformance) {
        this.id = id;
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentGender = studentGender;
        this.studentDate = studentDate;
        this.academicPerformance = academicPerformance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public Date getStudentDate() {
        return studentDate;
    }

    public void setStudentDate(Date studentDate) {
        this.studentDate = studentDate;
    }

    public String getAcademicPerformance() {
        return academicPerformance;
    }

    public void setAcademicPerformance(String academicPerformance) {
        this.academicPerformance = academicPerformance;
    }

    @Override
    public String toString() {
        return " [id=" + id + ", studentId=" + studentId + ", studentName=" + studentName + ", studentAge="
                + studentAge + ", studentGender=" + studentGender + ", studentDate=" + studentDate
                + ", academicPerformance=" + academicPerformance + "]";
    }

}
