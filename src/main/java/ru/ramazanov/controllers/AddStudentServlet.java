package ru.ramazanov.controllers;

import ru.ramazanov.common.StudentDaoException;
import ru.ramazanov.services.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 23.02.2017.
 */
public class AddStudentServlet extends HttpServlet {
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
            int group_id = Integer.parseInt(req.getParameter("group"));

            if (StudentService.addStudent(group_id, name, birthday, sex)) {
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
