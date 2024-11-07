package com.art.constants;

public class FrameworkConstants {
    private static final String CHROMEDRIVER_PATH = System.getProperty("user.dir") + "/src/test/resources/executables/chromedriver.exe";

    public static String getChromedriverPath() {
        return CHROMEDRIVER_PATH;
    }
}
