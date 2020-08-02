package com.framework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeTest;
import org.testng.log4testng.Logger;

import com.Driver.DriverManager;
import com.TestData.ReadPropertyFile;

public class SeleniumBase {

	WebDriver driver = DriverManager.getWebdriver();
	private static Logger logger = Logger.getLogger(SeleniumBase.class);

//	@BeforeTest
//	public void getSampleUrl() {
//
//		DriverManager.getWebdriver().get(ReadPropertyFile.readApplicationProperty("APPLICATION_URL"));
//	}

	public void click(By pElement) {
		try {
			DriverManager.getWebdriver().findElement(pElement).click();
		} catch (Exception e) {
			logger.debug("Unable to click");
		}
	}

	public void enterKeys(By pElement, String pKey) {
		try {
			DriverManager.getWebdriver().findElement(pElement).sendKeys(pKey);
		} catch (Exception e) {
			logger.debug("Unable to enter data");
		}
	}

	public By getWebelement(String pElement) {
		String aElement = ReadPropertyFile.readApplicationProperty(pElement);
		String temp[] = aElement.split(";");
		By aLocator = null;
		switch (temp[0]) {
		case "id":
			aLocator = By.id(temp[1]);
			break;
		case "xpath":
			aLocator = By.xpath(temp[1]);
			break;
		case "name":
			aLocator = By.name(temp[1]);
			break;
		case "class":
			aLocator = By.className(temp[1]);
			break;
		case "cssSelector":
			aLocator = By.cssSelector(temp[1]);
			break;
		case "linkText":
			aLocator = By.linkText(temp[1]);
			break;
		case "partialLinkText":
			aLocator = By.partialLinkText(temp[1]);
			break;
		case "tagName":
			aLocator = By.tagName(temp[1]);
			break;
		default:
			logger.debug("Invalid locator type");
			break;
		}
		return aLocator;
	}
	
	public String getWdataelement(String det) 
		{
		String aElement = ReadPropertyFile.readDataProperty(det);
		return aElement;
		}
	

	public List<WebElement> getWebelements(String pElement) {
		String aElement = ReadPropertyFile.readApplicationProperty(pElement);
		String temp[] = aElement.split(";");
		List<WebElement> aLocator = new ArrayList<WebElement>();
		switch (temp[0]) {
		case "id":
			aLocator = DriverManager.getWebdriver().findElements(By.id(temp[1]));
			break;
		case "xpath":
			aLocator = DriverManager.getWebdriver().findElements(By.xpath(temp[1]));
			break;
		case "name":
			aLocator = DriverManager.getWebdriver().findElements(By.name(temp[1]));
			break;
		case "class":
			aLocator = DriverManager.getWebdriver().findElements(By.className(temp[1]));
			break;
		case "cssSelector":
			aLocator = DriverManager.getWebdriver().findElements(By.cssSelector(temp[1]));
			break;
		case "linkText":
			aLocator = DriverManager.getWebdriver().findElements(By.linkText(temp[1]));
			break;
		case "partialLinkText":
			aLocator = DriverManager.getWebdriver().findElements(By.partialLinkText(temp[1]));
			break;
		case "tagName":
			aLocator = DriverManager.getWebdriver().findElements(By.tagName(temp[1]));
			break;
		default:
			logger.debug("Invalid locator type");
			break;
		}
		return aLocator;
	}


	public void maxwait(long timeInMilliseconds) {
		long aCurrentTime = System.currentTimeMillis();
		boolean isTimeUp = true;
		while (isTimeUp) {
			if (aCurrentTime + timeInMilliseconds == System.currentTimeMillis()) {
				isTimeUp = false;
			}
		}
	}

	public void minwait() {
		long aCurrentTime = System.currentTimeMillis();
		long aTimeOut = 2000;
		boolean isTimeUp = true;
		while (isTimeUp) {
			if (aCurrentTime + aTimeOut == System.currentTimeMillis()) {
				isTimeUp = false;
			}
		}
	}

	public Wait<WebDriver> fluentWait() {
		@SuppressWarnings("deprecation")
		Wait<WebDriver> wait = new FluentWait<WebDriver>(DriverManager.getWebdriver()).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(150, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
		return wait;
	}

	public void waitForElementToBeVisible(By pElement) {

		fluentWait().until(ExpectedConditions.visibilityOfElementLocated(pElement));
	}

	public void waitForElementToBeClickable(By pElement) {

		fluentWait().until(ExpectedConditions.elementToBeClickable(pElement));
	}

	public boolean isElementPresent(By pElement) {
		return DriverManager.getWebdriver().findElement(pElement).isDisplayed();
	}

	public String getTextFromElement(By pElement) {
		return DriverManager.getWebdriver().findElement(pElement).getText();
	}
	
	public Boolean element_displayed(By pElement)
	{
		if(driver.findElement(pElement).isDisplayed())
		{
			return true;
		}
		else {
		return false;
		}
	}
		
		public void jexecute(List<WebElement> pElement)
		{
			
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", pElement.get(0));
			//js.executeScript("arguments[0].click();", pElement.get(0));
			pElement.get(0).click();
		}
		
		public List<WebElement> getlistElement(String elem)
		{
			String el=ReadPropertyFile.readApplicationProperty(elem);
			List<WebElement> web_elems = driver.findElements(By.xpath(el));
			return web_elems;
		}
		
	}
