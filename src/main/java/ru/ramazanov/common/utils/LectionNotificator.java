package ru.ramazanov.common.utils;

import ru.ramazanov.models.pojo.Lection;
import ru.ramazanov.services.StudentService;

/**
 * Created by admin on 24.02.2017.
 */
public class LectionNotificator {
    public static void notifyByLection(Lection lection){
        StudentService.getStudentsByGroup();
    }
}
