package ru.ramazanov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ru.ramazanov.models.pojo.Student;
import ru.ramazanov.services.StudentService;
import ru.ramazanov.services.StudentServiceInterface;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SpisokServlet extends HttpServlet {

    private StudentServiceInterface studentService;

    @Autowired
    public void setStudentService(StudentServiceInterface studentService) {
        this.studentService = studentService;
    }

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext
                (this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("myParam", "paramparam");

        List<Student> studentList = studentService.getAllStudents();


        req.setAttribute("userlist", studentList);
        req.setAttribute("test", "test Attribute");
        getServletContext().getRequestDispatcher("/spisok.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }


}
