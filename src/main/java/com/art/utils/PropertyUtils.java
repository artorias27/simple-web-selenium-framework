package com.art.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public final class PropertyUtils {
    private final Properties props = new Properties();
    String filePath = System.getProperty("user.dir") + "/src/test/resources/config/config.properties";

    private PropertyUtils() {
        this.loadProps(filePath);
    }

    public static String getProperty(String key) throws Exception {
        String propValue = new PropertyUtils().props.getProperty(key);
        if (Objects.isNull(propValue))
            throw new Exception("Property name '" + key + "' is not found. Please Check 'config.properties'");
        return propValue;
    }

    private void loadProps(String filePath) {
        // try-with-resources
        try (InputStream ins = new FileInputStream(filePath)) {
            this.props.load(ins);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
