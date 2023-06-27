package org.example.utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {

    private final Properties properties;

    public PropertiesUtility(String filePath){
        FileReader fileReader = null;
        properties = new Properties();
        try {
            fileReader = new FileReader(filePath);
            properties.load(fileReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String keyName){
        return properties.getProperty(keyName);
    }

    public Object setProperty(String keyName, String value){
        return properties.setProperty(keyName,value);
    }

}
