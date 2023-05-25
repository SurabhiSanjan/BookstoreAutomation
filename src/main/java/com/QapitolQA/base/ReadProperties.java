package com.QapitolQA.base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    String propertyFilePath = "C:\\Users\\kumarisurabhi.sanjan\\IdeaProjects\\BookStore-Test-Assignment\\src\\resources\\data.properties";
    public Properties properties;
    public ReadProperties() throws FileNotFoundException {
        FileReader reader = new FileReader(propertyFilePath);
        properties = new Properties();
        try {
            properties.load(reader);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e + "data.properties file not found");
        }
    }
}
