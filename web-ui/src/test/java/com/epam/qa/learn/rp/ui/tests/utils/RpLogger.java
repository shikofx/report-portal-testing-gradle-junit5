package com.epam.qa.learn.rp.ui.tests.utils;

import com.epam.reportportal.service.ReportPortal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class RpLogger {

    public static void sendLaunch(Class<?> clazz, String level, String msg){
        send(clazz, msg, level);
        ReportPortal.emitLaunchLog(msg, level, new Date());
    }

    public static void send(Class<?> clazz, String level, String msg) {
        final Logger LOGGER = LoggerFactory.getLogger(clazz);

        switch (level){
            case "info": LOGGER.info(msg); break;
            case "error": LOGGER.error(msg); break;
            case "debug": LOGGER.debug(msg); break;
        }
    }

}
