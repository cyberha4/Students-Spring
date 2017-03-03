package ru.ramazanov.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ramazanov.common.StudentDaoException;
import ru.ramazanov.models.dao.StudentDAO;
import ru.ramazanov.models.dao.StudentsRepository;
import ru.ramazanov.models.pojo.Student;

import javax.rmi.CORBA.StubDelegate;
import java.util.List;

/**
 * Created by bot on 23.02.17.
 */
@Service
public class StudentService implements StudentServiceInterface{

    private StudentsRepository studentsRepository;

    @Autowired
    public StudentService(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    public List<Student> getAllStudents(){
        List<Student> students = studentsRepository.getAllStudents();
        for (Student st:
                students){
            System.out.println(st.getName());
        }
        return students;
    }

    public Student getStudentById(int id) {
        return studentsRepository.getStudentById(id);
    }

    public boolean updateStudent(int id, int group_id, String name, String birthday, String sex) {
            return studentsRepository.updateStudents( id, group_id, name, birthday, sex);
    }

    public boolean addStudent(int group_id, String name, String birthday, String sex) throws StudentDaoException {
        return studentsRepository.addStudent(group_id, name, birthday, sex);
    }

    public List<Student> getStudentsByGroup() {
        return studentsRepository.getStudentByGroup(66);
    }

    public List<Student> getStudentsByGroup(int groupId) {
        return studentsRepository.getStudentByGroup(groupId);
    }

    @Override
    public boolean addStudent(Student student) throws StudentDaoException{
        return studentsRepository.addStudent(student);
    }
}
