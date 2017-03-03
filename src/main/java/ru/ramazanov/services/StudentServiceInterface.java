package ru.ramazanov.services;

import ru.ramazanov.common.StudentDaoException;
import ru.ramazanov.models.pojo.Student;

import java.util.List;

/**
 * Created by admin on 02.03.2017.
 */
public interface StudentServiceInterface {
    public List<Student> getAllStudents();
    public Student getStudentById(int id);
    public boolean updateStudent(int id, int group_id, String name, String birthday, String sex);
    public boolean addStudent(int group_id, String name, String birthday, String sex) throws StudentDaoException;
    public List<Student> getStudentsByGroup();

    public boolean addStudent(Student student) throws StudentDaoException;
}
