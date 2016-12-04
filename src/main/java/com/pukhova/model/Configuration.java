package com.pukhova.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by dish on 04.12.16.
 */
public class Configuration {

    private Properties properties = new Properties();

    public Configuration() {
        try {
            properties.load(new FileInputStream("configuration.properties"));
        } catch (IOException e) {
            System.err.println("Cannot read configutration from current directory" + e.getMessage());
            System.exit(1);
        }
    }

    public String getParam(String s){
        return properties.getProperty(s);
    }

}
