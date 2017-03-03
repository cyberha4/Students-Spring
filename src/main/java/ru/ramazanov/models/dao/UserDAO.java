package ru.ramazanov.models.dao;

import org.springframework.stereotype.Repository;
import ru.ramazanov.common.UserDaoException;
import ru.ramazanov.dbconnect.ConnectionToDB;
import ru.ramazanov.models.Model;
import ru.ramazanov.models.pojo.UserNew;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.springframework.stereotype.Component;

import java.sql.*;

/**
 * Created by admin on 23.02.2017.
 */
@Repository
public class UserDAO implements UserRepository{
    public static final Logger logger = Logger.getLogger(UserDAO.class);
    static {
        DOMConfigurator.configure("C:\\Users\\admin\\IdeaProjects\\Innopolis\\servlet\\log4j.xml");
    }
    private static final String SQL_FIND_USER = "SELECT * FROM users WHERE login=? AND password=?";
    private static final String SQL_CREATE_USER =
            "INSERT INTO users (login, password) VALUES (?,?)";

    public UserNew getUserByLoginAndPassword(String login, String password) throws UserDaoException {
        UserNew user = new UserNew();
        String sql = "SELECT * FROM users WHERE login="+login+", password="+password;
        try {
            PreparedStatement ps = Model.getConnection().prepareStatement(SQL_FIND_USER);
            ps.setString(1, login);

            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                user.setIdUser(rs.getInt("id"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));

               return user;
            }

        } catch (SQLException e) {
            logger.error("problem with connection to DB",e);
            e.printStackTrace();
            throw new UserDaoException();
        } finally {

        }
        return user;
    }

    public boolean registrationUser(String login, String password){
        UserNew user = new UserNew();
        Connection query =  ConnectionToDB.getConnection();
        try {
            //Statement st = Model.getStatement();
            PreparedStatement ps = query.prepareStatement(SQL_CREATE_USER);
            ps.setString(1, login);

            ps.setString(2, password);
            int count = ps.executeUpdate();
            return count > 0;

        } catch (SQLException e) {
            logger.error("problem with connection to DB",e);
            e.printStackTrace();
        } finally {
            //close

        }

        return false;
    }
}
