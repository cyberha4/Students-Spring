package ru.ramazanov.services;

import org.junit.Test;
import ru.ramazanov.common.utils.LectionNotificator;
import ru.ramazanov.models.LectionsWithGroups;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by admin on 03.03.2017.
 */
public class LectionServiceTest {
    @Test
    public void getNearedLectionsId() throws Exception {
        HashMap<Integer, HashSet<LectionsWithGroups>> lections = LectionService.getNearedLectionsId();

        for (Map.Entry entry :
                lections.entrySet()) {
            //LectionNotificator.notifyByLectionAndGroup(entry.getValue());
            System.out.println(entry.getKey());
            HashSet<LectionsWithGroups> set = (HashSet<LectionsWithGroups>) entry.getValue();
            System.out.println("Set size " + set.size());
        }

    }

}