package com.mckinsey.util;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

    private final static Logger LOGGER = Logger.getLogger(PropertiesUtil.class);

    private static final String APPLICATION_PROPERTIES_FILE_NAME = "application.properties";
    private static final String MAIN_URL_PROPERTY_NAME = "main.url";

    private static Properties properties = new Properties();

    static {
        try {
            properties.load(PropertiesUtil.class.getClassLoader().getResourceAsStream(APPLICATION_PROPERTIES_FILE_NAME));
        } catch (IOException e) {
            LOGGER.error("Exception while properties file loading", e);
        }
    }

    public static String getMainUrl() {
        return properties.getProperty(MAIN_URL_PROPERTY_NAME);
    }


}
