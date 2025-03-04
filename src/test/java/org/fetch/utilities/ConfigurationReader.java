package org.fetch.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties = new Properties();                                //1- Create the Properties object (create object)
    //make it "private" so we are limiting access to the object
    //"static" is to make sure its created and loaded before everything else.

    static {
        try {
            FileInputStream file = new FileInputStream("configuration.properties");  //2- Open file using FileInputStream (open file)
            properties.load(file);                                                         //3- Load the "properties" object with "file" (load properties)
            file.close();                                                                  //close the file in the memory
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load configuration.properties file.");
        }
    }

    //create a utility method to use the object to read
    public static String getProperty(String keyword) {
        return properties.getProperty(keyword);
    }
}
