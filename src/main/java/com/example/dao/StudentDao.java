package com.example.dao;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import com.example.database.JavaUtil;
import com.example.model.StudentModel;

public class StudentDao implements DaoInterface<StudentModel> {

    @Override
    public boolean addStudent(StudentModel t) {
        Connection conn = JavaUtil.getConnection();
        String sql = "INSERT INTO students (`student_id`, `student_name`, `student_age`, " +
                "`student_gender`, `student_date`, `academic_performance`) " +
                "VALUES(?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, t.getStudentId());
            psmt.setString(2, t.getStudentName());
            psmt.setInt(3, t.getStudentAge());
            psmt.setString(4, t.getStudentGender());
            psmt.setDate(5, t.getStudentDate());
            psmt.setString(6, t.getAcademicPerformance());
            int check = psmt.executeUpdate();
            psmt.close();
            if (check > 0) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            JavaUtil.closeConnection(conn);
        }

        return false;
    }

    @Override
    public boolean updateStudent(StudentModel t) {
        Connection conn = JavaUtil.getConnection();
        String sql = "UPDATE students SET " +
                "`student_name` = ?, " +
                "`student_age` = ?, " +
                "`student_gender` = ?, " +
                "`student_date` = ?, " +
                "`academic_performance` = ? " +
                "WHERE `student_id` = ?";

        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, t.getStudentName());
            psmt.setInt(2, t.getStudentAge());
            psmt.setString(3, t.getStudentGender());
            psmt.setDate(4, t.getStudentDate());
            psmt.setString(5, t.getAcademicPerformance());
            psmt.setString(6, t.getStudentId());
            int check = psmt.executeUpdate();
            psmt.close();
            if (check > 0) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            JavaUtil.closeConnection(conn);
        }
        return false;
    }

    @Override
    public boolean deleteStudent(String studentId) {
        Connection conn = JavaUtil.getConnection();
        String sql = "DELETE FROM `students` WHERE  `student_id` = ?";
        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, studentId);
            int check = psmt.executeUpdate();
            if (check > 0) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            JavaUtil.closeConnection(conn);
        }

        return false;
    }

    @Override
    public List<StudentModel> getAllStudents() {
        Connection conn = JavaUtil.getConnection();
        List<StudentModel> listStudent = new ArrayList<>();

        String sql = "SELECT * FROM `students`";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String studentId = rs.getString("student_id");
                String studentName = rs.getString("student_name");
                int studentAge = rs.getInt("student_age");
                String studentGender = rs.getString("student_gender");
                Date studentDate = rs.getDate("student_date");
                String academicPerformance = rs.getString("academic_performance");

                StudentModel student = new StudentModel(id, studentId, studentName, studentAge, studentGender,
                        studentDate, academicPerformance);
                listStudent.add(student);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            JavaUtil.closeConnection(conn);
        }
        return listStudent;
    }

    @Override
    public StudentModel getStudentByStudentId(String idStudent) {
        Connection conn = JavaUtil.getConnection();
        String sql = "SELECT * FROM `students` WHERE `student_id` = ?";
        StudentModel studentSearch = null;
        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            psmt.setString(1, idStudent);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String studentId = rs.getString("student_id");
                String studentName = rs.getString("student_name");
                int studentAge = rs.getInt("student_age");
                String studentGender = rs.getString("student_gender");
                Date studentDate = rs.getDate("student_date");
                String academicPerformance = rs.getString("academic_performance");

                studentSearch = new StudentModel(id, studentId, studentName, studentAge, studentGender, studentDate,
                        academicPerformance);

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            JavaUtil.closeConnection(conn);
        }
        return studentSearch;
    }

}
