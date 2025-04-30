package com.university.dao;

import com.university.model.Grade;
import com.university.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GradeDAO {

    public void addGrade(Grade grade) {
        String sql = "INSERT INTO grades (student_id, subject, grade) VALUES (?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, grade.getStudentId());
            pstmt.setString(2, grade.getSubject());
            pstmt.setString(3, grade.getGrade());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Grade> getGradesByStudentId(int studentId) {
        List<Grade> grades = new ArrayList<>();
        String sql = "SELECT * FROM grades WHERE student_id = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, studentId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Grade grade = new Grade();
                    grade.setId(rs.getInt("id"));
                    grade.setStudentId(rs.getInt("student_id"));
                    grade.setSubject(rs.getString("subject"));
                    grade.setGrade(rs.getString("grade"));
                    grades.add(grade);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return grades;
    }
}
