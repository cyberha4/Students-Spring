package ru.ramazanov.controllers;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ru.ramazanov.common.UserDaoException;
import org.springframework.beans.factory.annotation.Autowired;
import ru.ramazanov.services.IUserService;
import ru.ramazanov.services.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by admin on 22.02.2017.
 */
public class AuthorizationsServlet extends HttpServlet {
    //public static final Logger logger = Logger.getLogger(UsersServlet.class);
    private IUserService userService;

    @Autowired(required = true)
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext
                (this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("test", "testValue");
        //resp.sendRedirect("/authorizations.jsp");
        req.setAttribute("autorizationsFiled", true);
        //logger.error(123);
        req.getRequestDispatcher("/authorizations.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login_name");
        String password = req.getParameter("password_name");
        System.out.println("try auth");
        try {
            if(userService.autorise(login, password)) {
                resp.sendRedirect("hello?name="+login);
                System.out.println("auth");
            } else {
                System.out.println("not auth");
                resp.sendRedirect("error.jsp?error=bad login or password, or both!");
            }
        } catch (UserDaoException e) {
            System.out.println("exception sql");
            resp.sendRedirect("error.jsp?error=sorry, we have some problem at server");
        }
    }
}
