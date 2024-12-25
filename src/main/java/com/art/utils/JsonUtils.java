package com.art.utils;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class JsonUtils {
    private JsonUtils() {}

    public static JSONObject loadJSON(String fileName) {
        InputStream inputStream = null;
        try {
            inputStream = JsonUtils.class.getClassLoader().getResourceAsStream(fileName);
            JSONTokener token = new JSONTokener(Objects.requireNonNull(inputStream));
            return new JSONObject(token);
        } finally {
            try {
                Objects.requireNonNull(inputStream).close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Below getJsonValue methods are redundant. Will remove
    public static String getJsonValue(String key) {
        JSONObject jsonObject = loadJSON("config/config.json");
        return jsonObject.getString(key);
    }

    public static String getJsonValue(String key, String fileName) {
        JSONObject jsonObject = loadJSON(fileName);
        return jsonObject.getString(key);
    }
}
