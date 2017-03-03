package ru.ramazanov.services;

import ru.ramazanov.models.LectionsWithGroups;
import ru.ramazanov.models.Model;
import ru.ramazanov.models.dao.LectionDao;
import ru.ramazanov.models.pojo.Lection;
import ru.ramazanov.models.pojo.Student;

import java.sql.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by admin on 24.02.2017.
 */
public class LectionService {
    public static List<Lection> getAllLection() {
        return LectionDao.getAllLection();
    }


    public static List<Lection> getNearedLections() {
        return LectionDao.getNearestLections();

    }

    public static HashMap<Integer, HashSet<LectionsWithGroups>> getNearedLectionsId() {
        //LinkedList<LectionsWithGroups> nearedLections;
        LectionsWithGroups lectionsWithGroups;

        String sql = "SELECT * FROM Students.journal LEFT JOIN Students.lection ON journal.id_lection = lection.id " +
                " WHERE date > ?";

        HashSet<LectionsWithGroups> setLectionsWithGroups;

        HashMap<Integer, HashSet<LectionsWithGroups>> groupsOnLections = new HashMap<>();

        try (Connection connection = Model.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                lectionsWithGroups = new LectionsWithGroups();
                lectionsWithGroups.setDatetime(resultSet.getTimestamp("date"));
                lectionsWithGroups.setLectionTitle(resultSet.getString("lection.title"));
                lectionsWithGroups.setGroupId(resultSet.getInt("id_group"));
                lectionsWithGroups.setLectionId(resultSet.getInt("id_lection"));
                lectionsWithGroups.setLectionSubject(resultSet.getString("lection.subject"));

                System.out.println("Group id = " + lectionsWithGroups.getGroupId());

                if (groupsOnLections.containsKey(lectionsWithGroups.getLectionId()))
                {
                    System.out.println("key is found");
                    groupsOnLections.get(resultSet.getInt("id_lection")).add(lectionsWithGroups);
                } else {
                    System.out.println("key not found");
                    setLectionsWithGroups = new HashSet<>(6);
                    setLectionsWithGroups.add(lectionsWithGroups);
                    groupsOnLections.put(lectionsWithGroups.getLectionId(),setLectionsWithGroups);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groupsOnLections;
    }
}
