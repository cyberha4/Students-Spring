package ru.ramazanov.controllers.listners;

import ru.ramazanov.common.utils.LectionNotificator;
import ru.ramazanov.models.pojo.Lection;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import ru.ramazanov.services.LectionService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.time.LocalDateTime;
import java.util.List;

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
        Runnable run = new Runnable() {
            @Override
            public void run() {
                int time = 1;
                while (true) {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    time+=10;
                    System.out.println(LocalDateTime.now());
                }
            }
        };

            List<Lection> lections = LectionService.getAllLection();
            if (lections.size()>0){
                for (Lection lection:
                        lections){
                    LectionNotificator.notifyByLection(lection);

                }
            } else {
                logger.trace("lections not found");
            }



        Thread timeTread = new Thread(run);
        //timeTread.start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.trace("site is dead");
    }
}
