package ru.ramazanov.services;

import ru.ramazanov.models.dao.LectionDao;
import ru.ramazanov.models.pojo.Lection;

import java.util.List;

/**
 * Created by admin on 24.02.2017.
 */
public class LectionService {
    public static List<Lection> getAllLection() {
        return LectionDao.getAllLection();
    }

    public static List<Lection> getNearestLection() {
        LectionDao.getNearestLection();

        return null;
    }
}
