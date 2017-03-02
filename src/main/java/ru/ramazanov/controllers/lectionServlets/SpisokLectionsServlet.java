package ru.ramazanov.controllers.lectionServlets;

import ru.ramazanov.models.pojo.Lection;
import ru.ramazanov.services.LectionService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by admin on 24.02.2017.
 */
public class SpisokLectionsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Lection> lections = LectionService.getAllLection();
        req.setAttribute("lections", lections);

        getServletContext().getRequestDispatcher("/lections/spisok.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
