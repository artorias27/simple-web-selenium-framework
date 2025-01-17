package com.art.utils;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class JsonUtils {
    private JsonUtils() {}

    public static JSONObject loadJSON(String fileName) {
        try (InputStream inputStream = JsonUtils.class.getClassLoader().getResourceAsStream(fileName)) {
            JSONTokener token = new JSONTokener(Objects.requireNonNull(inputStream));
            return new JSONObject(token);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Below getJsonValue methods are redundant. Will remove
    public static String getJsonValue(String key) {
        JSONObject jsonObject = loadJSON("config/config.json");
        return jsonObject.getString(key);
    }
}
