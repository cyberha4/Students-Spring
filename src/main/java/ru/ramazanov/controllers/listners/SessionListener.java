package ru.ramazanov.controllers.listners;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import javax.servlet.http.*;

/**
 * Created by admin on 24.02.2017.
 */
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {
    public static final Logger logger = Logger.getLogger(SessionListener.class);
    static {
        DOMConfigurator.configure("C:\\Users\\admin\\IdeaProjects\\Innopolis\\servlet\\log4j.xml");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        se.getSession().getAttribute("test");
        logger.trace(se.getSession().getId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        logger.trace(event.getValue());
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {

    }
}
