/**
 * 
 */
package com.Sample.Java;

import com.Driver.DriverManager;
import com.framework.SeleniumBase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

 

public class Mediware extends SeleniumBase {
	
	By med_user;
	By med_pass;
	By med_login;
	By med_appoinmentselect;
	By med_appoinment;
	//By select_time;
	//List<WebElement> select_time;
	By med_patientid;
	By med_search;
	By med_patient;
	By med_saveappoint;
	
	public Mediware()
	{
		med_user = getWebelement("Mediware_Username");
		med_pass = getWebelement("Mediware_Passdword");
		med_login = getWebelement("LOGIN_ID");
		med_appoinmentselect = getWebelement("APPLICATION_SELECTION");
		med_appoinment = getWebelement("APPOINMENT");
		//select_time = getWebelements("TIME_SELECT");
		med_patientid = getWebelement("PATIENT_ID");
		med_search = getWebelement("SEARCH");
		med_patient = getWebelement("SELECT_PATIENT");
		med_saveappoint= getWebelement("SAVE_PATIENT");
		
	}
	
	public void enter_usernamefield()
	{
		String name = getWdataelement("Username");
		waitForElementToBeVisible(med_user);
		enterKeys(med_user, name);
	}
	
	public void enter_password()
	{
		String pass = getWdataelement("Password");
		waitForElementToBeVisible(med_pass);
		enterKeys(med_pass, pass);
	}
	
	public void clickonlogin()
	{
		waitForElementToBeClickable(med_login);
		click(med_login);
	}
	
	public void login_page()
	{
		Assert.assertTrue(element_displayed(med_user));
	}
	
	public void appoinment_selector()
	{
		waitForElementToBeClickable(med_appoinmentselect);
		click(med_appoinmentselect);
		minwait();
	}
	
	public void appoinment_field()
	{
		DriverManager.getWebdriver().switchTo().frame("CallingPageDiv");
		waitForElementToBeVisible(med_appoinment);
	   click(med_appoinment);
	   maxwait(4000);
	   DriverManager.getWebdriver().switchTo().defaultContent();
	}
	
	public void select_time()
	{
		 List<WebElement> select_time=getWebelements("TIME_SELECT");
		maxwait(5000);
		jexecute(select_time);
		
	}
	
	public void new_appoinment()
	{
		DriverManager.getWebdriver().switchTo().frame("AppointmentDiv");
		Assert.assertTrue(element_displayed(med_patientid));
	}
	
	public void search_patient()
	{
		
		//DriverManager.getWebdriver().switchTo().frame("AppointmentDiv");
		click(med_patientid);
		enterKeys(med_patientid, getWdataelement("PATIENT"));
		waitForElementToBeClickable(med_search);
		click(med_search);
		minwait();
	}
	
	public void select_patient()
	{
		waitForElementToBeVisible(med_patient);
		click(med_patient);
		
	}

	public void selects_appoinment()
	{
		waitForElementToBeClickable(med_saveappoint);
		click(med_saveappoint);
	}

}
