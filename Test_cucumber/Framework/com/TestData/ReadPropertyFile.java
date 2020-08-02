package com.TestData;

import java.io.FileInputStream;
import java.nio.file.Paths;
import java.util.Properties;

import org.testng.log4testng.Logger;

public class ReadPropertyFile {

	private static Logger logger = Logger.getLogger(ReadPropertyFile.class);

	public static String readApplicationProperty(String key) {

		Properties prop = new Properties();
		try {
			FileInputStream file = new FileInputStream(
					Paths.get("").toAbsolutePath().toString() + "/Config/PropertyFiles/ApplicationProperty.properties");
			prop.load(file);

		} catch (Exception e) {
			logger.debug("Unable to read from property file");
		}
		return prop.getProperty(key);
	}

	public static String readDataProperty(String key_d) {

		Properties prop = new Properties();
		try {
			FileInputStream file = new FileInputStream(
					Paths.get("").toAbsolutePath().toString() + "/Config/PropertyFiles/Data.properties");
			prop.load(file);

		} catch (Exception e) {
			logger.debug("Unable to read from property file");
		}
		return prop.getProperty(key_d);
	}
}


