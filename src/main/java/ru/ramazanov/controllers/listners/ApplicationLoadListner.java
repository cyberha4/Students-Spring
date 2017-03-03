package ru.ramazanov.controllers.listners;

import ru.ramazanov.common.utils.LectionNotificator;
import ru.ramazanov.models.LectionsWithGroups;
import ru.ramazanov.models.pojo.Lection;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import ru.ramazanov.services.LectionService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by admin on 24.02.2017.
 */
public class ApplicationLoadListner implements ServletContextListener {
    public static final Logger logger = Logger.getLogger(ApplicationLoadListner.class);
    static {
        DOMConfigurator.configure("C:\\Users\\admin\\IdeaProjects\\Innopolis\\servlet\\log4j.xml");
    }
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        logger.trace("site started");

//            List<Lection> lections = LectionService.getAllLection();
//            if (lections.size()>0){
//                for (Lection lection:
//                        lections){
//                    logger.trace(lection.getTitle() + " lection notify");
//                    LectionNotificator.notifyByLection(lection);
//
//                }
//            } else {
//                logger.trace("lections not found");
//            }

        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(20 * 1000);
                        notifyByNearestLection();
                        Thread.sleep(60 * 60 * 1000);
                    } catch (InterruptedException e) {
                        logger.error(e);
                    }
                }
            }

        });

        th1.start();

    }

    private void notifyByNearestLection() {
        HashMap<Integer, HashSet<LectionsWithGroups>> lections = LectionService.getNearedLectionsId();

        if (lections.size() > 0) {
            logger.trace("lections founded");
            for (Map.Entry entry :
                    lections.entrySet()) {
                System.out.println(entry.getKey());
                LectionNotificator.notifyAboutLectionByGroup((HashSet<LectionsWithGroups>) entry.getValue());
            }
        } else {
            logger.trace("neared lections not found");
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.trace("site is dead");
    }
}
