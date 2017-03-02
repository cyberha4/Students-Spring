package ru.ramazanov.controllers;

import ru.ramazanov.models.pojo.Student;
import ru.ramazanov.services.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SpisokServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("myParam", "paramparam");

        List<Student> studentList = StudentService.getAllStudents();


        req.setAttribute("userlist", studentList);
        req.setAttribute("test", "test Attribute");
        getServletContext().getRequestDispatcher("/spisok.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
