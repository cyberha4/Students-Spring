package ru.ramazanov.models.dao;

import ru.ramazanov.models.Model;
import ru.ramazanov.models.pojo.Lection;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 24.02.2017.
 */
public class LectionDao {
    public static final Logger logger = Logger.getLogger(LectionDao.class);
    static {
        DOMConfigurator.configure("C:\\Users\\admin\\IdeaProjects\\Innopolis\\servlet\\log4j.xml");
    }

    public static List<Lection> getAllLection() {
        Lection lection = new Lection();
        List<Lection> lections = new ArrayList<>();

        try {
            ResultSet rs = Model.getStatement().executeQuery("SELECT * FROM lection ");
            while(rs.next()){
                lection = new Lection();
                lection.setId(rs.getInt("id"));
                lection.setTitle(rs.getString("title"));
                lection.setText(rs.getString("text"));
                lection.setSubject(rs.getString("subject"));

                lections.add(lection);
            }
        } catch (SQLException e) {
            logger.error("SQLException");
            e.printStackTrace();
        }

        return lections;

    }


    public static List<Lection> getNearestLections() {
        String SQL_NEARED_LECTIONS =
                "SELECT * FROM \"journal\" WHERE date >? AND date <?";
        List<Lection> lections = new ArrayList<>();
        try(Connection connection = Model.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_NEARED_LECTIONS);
            preparedStatement.setTimestamp(1,new Timestamp(System.currentTimeMillis()));
            preparedStatement.setTimestamp(2,new Timestamp(System.currentTimeMillis()+60*60*1000));
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                logger.debug(resultSet.getString("name"));
                Lection lection = new Lection();

                //Lection lection = new Lection(resultSet.getInt("id"),
                //        resultSet.getString("name"),
                //        resultSet.getString("subject"),
                //        resultSet.getString("textLection"),
                //        resultSet.getInt("groupid"),
                //        resultSet.getDate("date"));
                lections.add(lection);
            }
        } catch (SQLException e) {
            logger.error(e);
        }

        logger.debug(lections.size());
        return lections;

    }
}
