package ru.ramazanov.services;

import ru.ramazanov.common.StudentDaoException;
import ru.ramazanov.models.dao.StudentDAO;
import ru.ramazanov.models.pojo.Student;

import java.util.List;

/**
 * Created by bot on 23.02.17.
 */
public class StudentService {

    public static List<Student> getAllStudents(){
        List<Student> students = StudentDAO.getAllStudents();
        for (Student st:
                students){
            System.out.println(st.getName());
        }
        return students;
    }

    public static Student getStudentById(int id) {
        return StudentDAO.getStudentById(id);
    }

    public static boolean updateStudent(int id, int group_id, String name, String birthday, String sex) {
            return StudentDAO.updateStudents( id, group_id, name, birthday, sex);
    }

    public static boolean addStudent(int group_id, String name, String birthday, String sex) throws StudentDaoException {
        return StudentDAO.addStudent(group_id, name, birthday, sex);
    }

    public static List<Student> getStudentsByGroup() {
        return StudentDAO.getStudentByGroup(66);
    }
}
