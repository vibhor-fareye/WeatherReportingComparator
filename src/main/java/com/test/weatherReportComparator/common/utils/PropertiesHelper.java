package com.test.weatherReportComparator.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author - Vinod Kumar
 */

@Slf4j
public class PropertiesHelper {

    /**
     * Method to load properties bases on InputStream object
     * @param inputStreamsObj
     */
    public Properties loadProperties(InputStream... inputStreamsObj) {
        Properties properties = new Properties();

        Properties childProperties = new Properties();
        try {
            for (InputStream obj : inputStreamsObj) {
                childProperties.load(obj);
                properties.putAll(childProperties);
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        log.info("Properties loaded successfully.");

        return properties;
    }


    /**
     * Method to load properties bases on properties file path
     * @param filePath
     * @return
     */
    public Properties loadProperties(String... filePath) {

        Properties properties = new Properties();

        Properties childProperties = new Properties();
        try {
            for (String file : filePath) {
                childProperties.load(new FileInputStream(file));
                properties.putAll(childProperties);
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        log.info("Properties loaded successfully.");
        return properties;
    }
}
