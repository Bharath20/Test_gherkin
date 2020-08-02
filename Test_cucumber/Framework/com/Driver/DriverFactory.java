package com.Driver;

import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

	private static WebDriver driver;

	public static WebDriver initializeDriver(String url) {

		BasicConfigurator.configure();
		System.setProperty("webdriver.chrome.driver",
				Paths.get("").toAbsolutePath().toString() + "/Config/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}
}
