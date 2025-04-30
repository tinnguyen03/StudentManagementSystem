package com.university.controller;

import com.university.dao.GradeDAO;
import com.university.model.Grade;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "GradeController", urlPatterns = {"/grade/add"})
public class GradeController extends HttpServlet {

    private GradeDAO gradeDAO;

    @Override
    public void init() {
        gradeDAO = new GradeDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int studentId = Integer.parseInt(request.getParameter("studentId"));
        String subject = request.getParameter("subject");
        String gradeValue = request.getParameter("grade");

        Grade grade = new Grade();
        grade.setStudentId(studentId);
        grade.setSubject(subject);
        grade.setGrade(gradeValue);

        gradeDAO.addGrade(grade);

        response.sendRedirect(request.getContextPath() + "/student/view?id=" + studentId);
    }
}
