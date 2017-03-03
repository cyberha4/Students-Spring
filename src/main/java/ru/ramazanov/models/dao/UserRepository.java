package ru.ramazanov.models.dao;

import ru.ramazanov.common.UserDaoException;
import ru.ramazanov.models.pojo.UserNew;

/**
 * Created by admin on 02.03.2017.
 */
public interface UserRepository {
    public UserNew getUserByLoginAndPassword(String login, String password) throws UserDaoException;
    public boolean registrationUser(String login, String password);
}
