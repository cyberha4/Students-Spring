package ru.ramazanov.services;

import ru.ramazanov.common.UserDaoException;

/**
 * Created by admin on 02.03.2017.
 */
public interface IUserService {
    public boolean autorise(String login, String password) throws UserDaoException;
    public boolean registration (String login, String password);
}
