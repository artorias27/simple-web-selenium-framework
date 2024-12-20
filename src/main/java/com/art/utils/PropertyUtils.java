package com.art.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public class PropertyUtils {
    private static final Properties props = new Properties();
    final String filePath = System.getProperty("user.dir") + "/src/test/resources/config/config.properties";

    private PropertyUtils() {
    }

    static {
        try (InputStream ins = new FileInputStream(new PropertyUtils().filePath)) {
            props.load(ins);
        } catch (IOException e) {
            e.printStackTrace(); // To implement logging
        }
    }

    public static String getPropertyValue(String key) throws Exception {
        String propValue = props.getProperty(key);
        if (Objects.isNull(propValue))
            throw new Exception("Property name '" + key + "' is not found. Please Check 'config.properties'");
        return propValue;
    }
}
