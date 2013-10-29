package com.oggi.delivery.Tests;

import java.io.*;
import java.util.Properties;

public class ConfigInitializer {

    static Properties properties = new Properties();
    public static String MONGO_HOST;
    public static int MONGO_PORT;
    public static String SERVICE_HOST;
    public static int SERVICE_PORT;
    static {
        initializePropertiesReader();
        MONGO_HOST = properties.getProperty("mongo.host");
        MONGO_PORT = Integer.parseInt(properties.getProperty("mongo.port"));
        SERVICE_HOST = properties.getProperty("service.host");
        SERVICE_PORT = Integer.parseInt(properties.getProperty("service.port"));
    }

    private static void initializePropertiesReader() {
        try {
            FileInputStream propertyFile = new FileInputStream("configuration.properties");
            properties.load(propertyFile);
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
