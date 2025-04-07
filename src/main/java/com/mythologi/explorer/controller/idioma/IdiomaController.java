package com.mythologi.explorer.controller.idioma;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * @author alexfdb
 * @version 1.0.0
 */
public class IdiomaController {

    private IdiomaController() {
    }

    public static class ConfigProperties {

        private ConfigProperties() {
        }

        static String path;
        private static final Properties PROPERTIES = new Properties();

        public static String getProperties(String key) {
            return PROPERTIES.getProperty(key);
        }

        public static void setPath(String rutaPath) {
            path = rutaPath;
            try (FileInputStream input = new FileInputStream(path);
                    InputStreamReader isr = new InputStreamReader(input, StandardCharsets.UTF_8);) {
                PROPERTIES.load(isr);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}