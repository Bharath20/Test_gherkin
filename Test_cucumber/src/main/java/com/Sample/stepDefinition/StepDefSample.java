package com.Sample.stepDefinition;

import java.util.List;
import java.util.Map;

import org.testng.asserts.SoftAssert;

import com.Sample.Java.SampleClass;
import com.TestData.ReadExcelData;
import com.framework.SeleniumBase;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefSample extends SeleniumBase {

	SampleClass sampleClass;
	ReadExcelData excelData;

	public StepDefSample() {

		sampleClass = new SampleClass();
		excelData = new ReadExcelData();
	}

	@Given("^User is on the landing page$")
	public void user_is_on_the_landing_page() throws Throwable {

		sampleClass.clickOnLoginLink();
	}

	@When("^User fills both email and password$")
	public void user_fills_both_email_and_password(DataTable userCred) throws Throwable {

//		String aEmailOrPhone = excelData.getData("LOGIN_USERNAME");
//		String aPassword = excelData.getData("LOGIN_PASSWORD");
		List<Map<String, String>> data = userCred.asMaps(String.class, String.class);
		sampleClass.enterValueOnEmailOrPhoneField(data.get(0).get("USERNAME"));
		sampleClass.clickOnBtnContinueOnLogin();
		sampleClass.enterValueOnPasswordField(data.get(0).get("PASSWORD"));
	}

	@And("^Click on the login button$")
	public void click_on_the_login_button() throws Throwable {

		sampleClass.clickOnBtnLoginOnLogin();
		maxwait(3000);
	}

	@Then("^User is logged in$")
	public void user_is_logged_in() throws Throwable {

		String aUserName = excelData.getData("LOGGEDIN_USERNAME_HOME_PAGE");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(sampleClass.isLoggedInUserNameDisplayed(aUserName), "User is logged in");
		softAssert.assertAll();
	}
}
