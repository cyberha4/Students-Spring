package ru.ramazanov;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;

/**
 * Created by admin on 23.02.2017.
 */
public class TestFunc {
    public static void main(String[] args) throws SQLException {
        LocalDateTime date = LocalDateTime.of(2017, Month.FEBRUARY, 24, 13, 15);
        Timestamp timestamp = new Timestamp(1479250540110L);

        LocalDateTime date2 = LocalDateTime.ofInstant(timestamp.toInstant(), ZoneId.systemDefault());
        LocalDateTime now = LocalDateTime.now();

        System.out.println(date);
        System.out.println((now.plusHours(1)).isAfter(date));
        System.out.println(timestamp.getTime());
        System.out.println(date2.getYear());
    }
}
