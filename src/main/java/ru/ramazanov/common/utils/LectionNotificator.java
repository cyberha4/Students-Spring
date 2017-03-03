package ru.ramazanov.common.utils;

import ru.ramazanov.models.LectionsWithGroups;
import ru.ramazanov.models.dao.StudentDAO;
import ru.ramazanov.models.pojo.Lection;
import ru.ramazanov.models.pojo.Student;
import ru.ramazanov.services.StudentService;

import java.util.HashSet;
import java.util.List;

/**
 * Created by admin on 24.02.2017.
 */
public class LectionNotificator {
    private StudentService studentService = new StudentService(new StudentDAO());
    public static void notifyByLection(Lection lection){
        //studentService.getStudentsByGroup();
    }

    public static void notifyAboutLectionByGroup(HashSet<LectionsWithGroups> setLectionsWithGroups) {
        LectionsWithGroups lectionsWithGroups;
        List<Student> students;
        //while(setLectionsWithGroups.iterator().hasNext()){
            lectionsWithGroups = setLectionsWithGroups.iterator().next();
            System.out.println("notify about lection id group " + lectionsWithGroups.getGroupId());
            StudentService studentService = new StudentService(new StudentDAO());
            students = studentService.getStudentsByGroup(lectionsWithGroups.getGroupId());

            for(Student student:
                    students){
                Mailer.sendFaikMail(student.getEmail(), lectionsWithGroups.getLectionSubject(), "test");
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        //}

    }
}
