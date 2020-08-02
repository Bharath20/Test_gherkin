package com.Sample.Java;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.framework.SeleniumBase;

public class SampleClass extends SeleniumBase {

	private static Logger logger = Logger.getLogger(SampleClass.class);

	private By loginLinkOnHome;

	private By emailOrPhoneFieldOnLogin;

	private By btnContinueOnLogin;

	private By passwordFieldOnLogin;

	private By loginBtnOnLogin;

	private By loginUserMsgOnHome;

	public SampleClass() {

		loginLinkOnHome = getWebelement("SIGN_IN_AMAZON_HOME");
		emailOrPhoneFieldOnLogin = getWebelement("EMAIL_PHONE_TXT_FIELD_AMAZON_LOGIN");
		btnContinueOnLogin = getWebelement("BTN_CONTINUE_AMAZON_LOGIN");
		passwordFieldOnLogin = getWebelement("PASSWORD_TXT_FIELD_AMAZON_LOGIN");
		loginBtnOnLogin = getWebelement("BTN_LOGIN_AMAZON_LOGIN");
		loginUserMsgOnHome = getWebelement("LOGIN_USER_MESSAGE_HOME_AMAZON");
	}

	/***
	 * Click on the login link to login on home page
	 * 
	 * @Author: Sudheesh M
	 */
	public void clickOnLoginLink() {
		logger.info("Click on the login link to login on home page");
		try {
			click(loginLinkOnHome);
		} catch (Exception e) {
			logger.debug("Unable to Click on the login link to login on home page");
		}
	}

	/***
	 * Enter value on email or phone field on login page
	 * 
	 * @Author: Sudheesh M
	 */
	public void enterValueOnEmailOrPhoneField(String pEmailOrPhone) {
		logger.info("Enter value on email or phone field on login page");
		try {
			waitForElementToBeClickable(btnContinueOnLogin);
			enterKeys(emailOrPhoneFieldOnLogin, pEmailOrPhone);
		} catch (Exception e) {
			logger.debug("Unable to Enter value on email or phone field on login page");
		}
	}

	/***
	 * Click on the continue button on login page
	 * 
	 * @Author: Sudheesh M
	 */
	public void clickOnBtnContinueOnLogin() {
		logger.info("Click on the continue button on login page");
		try {
			click(btnContinueOnLogin);
		} catch (Exception e) {
			logger.debug("Unable to Click on the continue button on login page");
		}
	}

	/***
	 * Enter value on password field on login page
	 * 
	 * @Author: Sudheesh M
	 */
	public void enterValueOnPasswordField(String pPassword) {
		logger.info("Enter value on password field on login page");
		try {
			waitForElementToBeClickable(loginBtnOnLogin);
			enterKeys(passwordFieldOnLogin, pPassword);
		} catch (Exception e) {
			logger.debug("Unable to Enter value on password field on login page");
		}
	}

	/***
	 * Click on the login button on login page
	 * 
	 * @Author: Sudheesh M
	 */
	public void clickOnBtnLoginOnLogin() {
		logger.info("Click on the login button on login page");
		try {
			click(loginBtnOnLogin);
		} catch (Exception e) {
			logger.debug("Unable to Click on the login button on login page");
		}
	}

	/***
	 * Check the logged in user name is displayed on home page
	 * 
	 * @Author: Sudheesh M
	 */
	public boolean isLoggedInUserNameDisplayed(String pUserName) {
		logger.info("Check the logged in user name is displayed on home page");
		boolean isDisplayed = false;
		try {
			if (getTextFromElement(loginUserMsgOnHome).toLowerCase().contains(pUserName.toLowerCase())) {
				isDisplayed = true;
			}
		} catch (Exception e) {
			logger.debug("Unable to Check the logged in user name is displayed on home page");
		}
		return isDisplayed;
	}
}