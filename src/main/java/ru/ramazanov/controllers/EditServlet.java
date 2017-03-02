package ru.ramazanov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ru.ramazanov.common.UserDaoException;
import ru.ramazanov.models.pojo.Student;
import ru.ramazanov.services.StudentService;
import ru.ramazanov.services.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 23.02.2017.
 */
public class EditServlet extends HttpServlet{
    @Autowired
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext
                (this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id;
        try {
            userService.autorise("test", "fsd");
        } catch (UserDaoException e) {
            e.printStackTrace();
        }
        if (req.getParameter("id") != null) {
            id = Integer.parseInt(req.getParameter("id"));
            Student student = StudentService.getStudentById(id);
            System.out.println(student.getName());
            req.setAttribute("student", student);
            getServletContext().getRequestDispatcher("/edit.jsp").forward(req, resp);
        }
        resp.sendRedirect("spisok");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String birthday = req.getParameter("birthday");
        String sex = req.getParameter("sex");
        int id = Integer.parseInt(req.getParameter("id"));
        int group_id = Integer.parseInt(req.getParameter("group"));
        if (StudentService.updateStudent(id, group_id, name, birthday, sex)) {
            resp.sendRedirect("spisok");
        } else {
            resp.sendRedirect("error.jsp");
        }
    }
}
