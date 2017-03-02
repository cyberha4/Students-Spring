package ru.ramazanov.models.dao;

import ru.ramazanov.common.StudentDaoException;
import ru.ramazanov.models.Model;
import ru.ramazanov.models.pojo.Student;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 23.02.2017.
 */
public class StudentDAO {
    public static final Logger logger = Logger.getLogger(StudentDAO.class);
    static {
        DOMConfigurator.configure("C:\\Users\\admin\\IdeaProjects\\Innopolis\\servlet\\log4j.xml");
    }

    private static final String SQL_UPDATE_USER = "UPDATE `Students`.`students` SET `group_id` = ?," +
            " `name` = ?, `birthday` = ?, `sex` = ? WHERE `students`.`id` = ?";
    private static final String SQL_INSERT_USER = "INSERT INTO `Students`.`students` " +
            "(group_id, name, birthday, sex) VALUES (?,?,?,?)";
    public static List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();
        Student student;

        try {
            ResultSet rs = Model.getStatement().executeQuery("SELECT * FROM students");
            while(rs.next()){
                student = new Student();
                student.setId(rs.getInt("id"));
                student.setGroup_id(rs.getInt("group_id"));
                student.setName(rs.getString("name"));
                student.setBirthdate(rs.getString("birthday"));
                student.setSex(rs.getString("sex"));

                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentList;
    }

    public static Student getStudentById(int id) {
        Student student = new Student();

        try {
            ResultSet rs = Model.getStatement().executeQuery("SELECT * FROM students WHERE id="+id);
            while(rs.next()){
                student.setId(rs.getInt("id"));
                student.setGroup_id(rs.getInt("group_id"));
                student.setName(rs.getString("name"));
                student.setBirthdate(rs.getString("birthday"));
                student.setSex(rs.getString("sex"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return student;
    }

    public static boolean updateStudents(int id, int group_id, String name, String birthday, String sex) {
        try {

            PreparedStatement ps = Model.getConnection().prepareStatement(SQL_UPDATE_USER);
            ps.setInt(1, group_id);
            ps.setString(2, name);
            ps.setString(3, birthday);
            ps.setString(4, sex);
            ps.setInt(5, id);
            int count = ps.executeUpdate();
            return count > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean addStudent(int group_id, String name, String birthday, String sex) throws StudentDaoException {
        try {
            PreparedStatement ps = Model.getConnection().prepareStatement(SQL_INSERT_USER);
            ps.setInt(1, group_id);
            ps.setString(2, name);
            ps.setString(3, birthday);
            ps.setString(4, sex);
            int count = ps.executeUpdate();
            return count > 0;

        } catch (Exception e) {
            logger.error("Some problems with connection to DB", e);
            e.printStackTrace();
            throw new StudentDaoException();
        }
    }

    public static List<Student> getStudentByGroup(int groupId) {
        List<Student> students = new ArrayList<Student>();

        Student student = new Student();

        try {
            ResultSet rs = Model.getStatement().executeQuery("SELECT * FROM students WHERE group_id="+groupId);
            while(rs.next()){
                student = new Student();
                student.setId(rs.getInt("id"));
                student.setGroup_id(rs.getInt("group_id"));
                student.setName(rs.getString("name"));
                student.setBirthdate(rs.getString("birthday"));
                student.setSex(rs.getString("sex"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }
}
