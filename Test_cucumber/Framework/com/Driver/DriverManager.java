package com.Driver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import com.TestData.ReadPropertyFile;

import cucumber.api.java.Before;

public class DriverManager {

	private static String url;
	protected static WebDriver driver;

	@Before
	public static WebDriver getWebdriver() {
		url = ReadPropertyFile.readApplicationProperty("APPLICATION_URL");
		if (driver == null) {
			driver = DriverFactory.initializeDriver(url);
		}
		return driver;
	}

}
