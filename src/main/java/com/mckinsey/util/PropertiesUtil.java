package com.mckinsey.util;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

    private final static Logger LOGGER = Logger.getLogger(PropertiesUtil.class);

    private static final String EPAM_PROPERTIES_FILE_NAME = "epam.properties";
    private static final String GMAIL_PROPERTIES_FILE_NAME = "gmail.properties";
    private static final String URL_PROPERTY_NAME = "url";

    private static Properties epamProperties = new Properties();
    private static Properties gmailProperties = new Properties();

    static {
        try {
            epamProperties.load(PropertiesUtil.class.getClassLoader().getResourceAsStream(EPAM_PROPERTIES_FILE_NAME));
            gmailProperties.load(PropertiesUtil.class.getClassLoader().getResourceAsStream(GMAIL_PROPERTIES_FILE_NAME));
        } catch (IOException e) {
            LOGGER.error("Exception while properties file loading", e);
        }
    }

    public static String getEpamUrl() {
        return epamProperties.getProperty(URL_PROPERTY_NAME);
    }

    public static String getGmailUrl() {
        return gmailProperties.getProperty(URL_PROPERTY_NAME);
    }

}
