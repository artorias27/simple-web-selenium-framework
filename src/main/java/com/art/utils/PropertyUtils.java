package com.art.utils;

import com.art.constants.FrameworkConstants;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public class PropertyUtils {
    private static final Properties props = new Properties();

    private PropertyUtils() {
    }

    static {
        try (InputStream ins = new FileInputStream(FrameworkConstants.CONFIG_FILE_PATH)) {
            props.load(ins);
        } catch (IOException e) {
            e.printStackTrace(); // To implement logging
        }
    }

    public static String getValue(String key) {
        try {
            String propValue = props.getProperty(key);
            if (Objects.isNull(key) || Objects.isNull(propValue)) {
                throw new NullPointerException("Property name '" + key + "' is not found. Please Check 'config.properties'");
            }
            return propValue;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
