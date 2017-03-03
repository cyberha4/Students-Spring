package ru.ramazanov.models.dao;

import ru.ramazanov.common.StudentDaoException;
import ru.ramazanov.models.pojo.Student;

import java.util.List;

/**
 * Created by admin on 02.03.2017.
 */
public interface StudentsRepository {
    public List<Student> getAllStudents();
    public Student getStudentById(int id);
    public boolean updateStudents(int id, int group_id, String name, String birthday, String sex);
    public boolean addStudent(int group_id, String name, String birthday, String sex) throws StudentDaoException;
    public  List<Student> getStudentByGroup(int groupId);


    public boolean addStudent(Student student) throws StudentDaoException;
}
