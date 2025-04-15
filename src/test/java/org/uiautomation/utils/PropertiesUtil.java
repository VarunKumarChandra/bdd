package org.uiautomation.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

    private final Properties configProp = new Properties();

    private PropertiesUtil() {
        try (InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream("config/config.properties")) {
            configProp.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static PropertiesUtil getInstance() {
        return LazyHolder.INSTANCE;
    }

    public String getProperty(String key) {
        return configProp.getProperty(key);
    }

    private static class LazyHolder {
        private static final PropertiesUtil INSTANCE = new PropertiesUtil();
    }
}
