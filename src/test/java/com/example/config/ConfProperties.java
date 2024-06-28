package com.example.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

public class ConfProperties {

    private static FileInputStream fileInputStream;
    private static Properties properties;

    static {
        try {
            fileInputStream = new FileInputStream("./src/test/resources/conf.properties");
            properties = new Properties();
            properties.load(new InputStreamReader(fileInputStream, Charset.forName("UTF-8")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

}