package ru.ramazanov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ru.ramazanov.common.StudentDaoException;
import ru.ramazanov.models.pojo.Student;
import ru.ramazanov.services.StudentService;
import ru.ramazanov.services.StudentServiceInterface;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 23.02.2017.
 */
public class AddStudentServlet extends HttpServlet {

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
        req.getRequestDispatcher("addstudent.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = req.getParameter("name");
            String birthday = req.getParameter("birthday");
            String sex = req.getParameter("sex");
            String email = req.getParameter("email");
            int group_id = Integer.parseInt(req.getParameter("group"));

            Student student = new Student();
            student.setName(name);
            student.setSex(sex);
            student.setBirthdate(birthday);
            student.setEmail(email);
            student.setGroup_id(group_id);

            if (studentService.addStudent(student)) {
                resp.sendRedirect("spisok");
            } else {
                resp.sendRedirect("error.jsp?error=cant add student with this parametres");
            }
        } catch (StudentDaoException e) {
            resp.sendRedirect("error.jsp?error=some problems with connection to db");
        } catch (NumberFormatException e) {
            resp.sendRedirect("addstudent.jsp?error=wrong input value");
        }
    }
}
