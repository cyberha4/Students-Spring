package ru.ramazanov.dbconnect;

import org.apache.log4j.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by admin on 26.02.2017.
 */
public class ConnectionToDB {
    private static Logger logger = Logger.getLogger(ConnectionToDB.class);

    private static final String url = "jdbc:mysql://localhost:3306/students";
    private static final String user = "root";
    private static final String password = "";

    private static Connection connection;

    private static DataSource dataSource;

    private static ConnectionToDB ourInstance = new ConnectionToDB();

    public static ConnectionToDB getInstance() {
        return ourInstance;
    }

    private ConnectionToDB() {
    }
    static {
//        Context initContext = null;
//        try {
//            initContext = new InitialContext();
//            dataSource = (DataSource) initContext.lookup("java:comp/env/jdbc/TEST");
//        } catch (NamingException e) {
//            logger.error("Не найдена конфигурация для connection pull", e);
//            e.printStackTrace();
//        }
    }

    /**Возвращает подключение к БД
     * @return connection
     */
    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);

            logger.trace("Successful connect to base: "+url);
        } catch (ClassNotFoundException e) {
            logger.error(e);
            System.out.println("Не найден драйвер");
        } catch (SQLException e) {
            logger.error(e);
            System.out.println("Ошибка подключение к БД!");
        }
        return connection;
    }

    public static Connection getConnection2() {

        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            logger.error("Connection exception", e);
            e.printStackTrace();
        }
        return connection;
    }
}
