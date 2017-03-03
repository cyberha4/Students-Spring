package ru.ramazanov.services;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import ru.ramazanov.common.UserDaoException;
import ru.ramazanov.models.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ramazanov.models.dao.UserRepository;

import java.util.Random;

/**
 * Created by admin on 23.02.2017.
 */
@Service
public class UserService implements IUserService {
    public static final Logger logger = Logger.getLogger(UserDAO.class);
    static {
        DOMConfigurator.configure("C:\\Users\\admin\\IdeaProjects\\Innopolis\\servlet\\log4j.xml");
    }

    private int anInt = 0;

    private UserRepository userDAO;

    @Autowired
    public UserService(UserRepository userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public boolean autorise(String login, String password) throws UserDaoException {
        if(anInt == 0) {
            Random random = new Random();
            anInt = random.nextInt();
        }
        logger.trace("User Service antInt = " + anInt);

        return userDAO.getUserByLoginAndPassword(login, password).getIdUser() != 0;
    }

    public boolean registration (String login, String password){
        return userDAO.registrationUser(login, password);
    }
}
