package ru.ramazanov;

import ru.ramazanov.models.Model;
import ru.ramazanov.models.pojo.Student;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

/**
 * Created by admin on 23.02.2017.
 */
public class TestFunc {
    public static void main(String[] args) throws SQLException {
        LocalDateTime localDate = LocalDateTime.of(2017, Month.FEBRUARY, 24, 13, 15);

        //Timestamp timestamp = new Timestamp(1479250540110L);
//
//        LocalDateTime date2 = LocalDateTime.ofInstant(timestamp.toInstant(), ZoneId.systemDefault());
        //LocalDateTime now = LocalDateTime.now();
//
        //System.out.println(date);
        //System.out.println((now.plusHours(1)).isAfter(date));
        //System.out.println(timestamp.getTime());
        //System.out.println(date2.getYear());

//        Model.getStatement().executeQuery("INSERT INTO ")
        Date date = new Date(System.currentTimeMillis());
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm");

        //System.out.println((LocalDateTime.parse("2017-03-02", formatter)).format(formatter));
//
        //System.out.println(localDate.format(formatter));

//        ResultSet rs = Model.getStatement().executeQuery("SELECT * FROM Students.journal");
//        rs.next();
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm");
//        Timestamp time = rs.getTimestamp("date");
//        localDate = LocalDateTime.ofInstant(time.toInstant(), ZoneId.systemDefault());
//
//        //System.out.println(localDate.format(formatter));
//
//        Timestamp tms = Timestamp.valueOf(localDate);
        //System.out.println(tms.getTime());

//        String sql = "SELECT * FROM Students.journal LEFT JOIN Students.lection ON journal.id_lection = lection.id " +
//                " WHERE date < ?";
//
//        HashMap<String, Student> studentOnLection = new HashMap<>();
//
//        try(Connection connection = Model.getConnection()){
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setTimestamp(1,new Timestamp(System.currentTimeMillis()));
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            while(resultSet.next()) {
//                System.out.println(resultSet.getTimestamp("date"));
//                System.out.println(resultSet.getString("lection.title"));
//                System.out.println(resultSet.getString("id_group"));
//            }
//        }

        Integer[] test = new Integer[5];
        System.out.println(test.length);
        test[1] = 5;
        System.out.println(test.length);

    }
}
