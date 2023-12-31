package com.example.dao;

import java.util.*;

import com.example.model.StudentModel;

public interface DaoInterface<T> {
    public boolean addStudent(T t);

    public boolean updateStudent(T t);

    public boolean deleteStudent(String studentId);

    public List<T> getAllStudents();

    public StudentModel getStudentByStudentId(String studentId);

}
