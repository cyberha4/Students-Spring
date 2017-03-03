package ru.ramazanov.controllers;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ru.ramazanov.services.IUserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 23.02.2017.
 */
public class RegistrationServlet extends HttpServlet{
    @Autowired
    private IUserService userService;

    public static final Logger logger = Logger.getLogger(RegistrationServlet.class);
    static {
        DOMConfigurator.configure("C:\\Users\\admin\\IdeaProjects\\Innopolis\\servlet\\log4j.xml");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext
                (this, config.getServletContext());
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.trace("test");
        req.getRequestDispatcher("registration.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if(userService.registration(login, password)) {
            resp.sendRedirect("login");
        } else {
            resp.sendRedirect("error.jsp");
        }
    }
}
