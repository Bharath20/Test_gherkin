/**
 * 
 */
package com.Sample.stepDefinition;

import com.Sample.Java.Mediware;
import com.framework.SeleniumBase;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author SE-MENTOR
 *
 */
public class Stepdef_Login extends SeleniumBase {
	
	Mediware med;
	//ReadExcelData excelData;

	public Stepdef_Login() {

		med = new Mediware();
		
	}
	
	@Given("^User is in the log in page$")
	public void user_is_in_the_log_in_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    med.login_page();
	}

	@When("^user enters username and password$")
	public void user_enters_and() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		med.enter_usernamefield();
		maxwait(5000);
		med.enter_password();
	    
	}

	@And("^clicks on the login button$")
	public void clicks_on_the_login_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // maxwait(5000);
	    med.clickonlogin();
	}

	@Then("^the user is logged in$")
	public void user_is_logged_in() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("logged in");
	}
	
	@When("^user selects the appoinment selector$")
	public void user_selects_the_appoinment_selector() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 maxwait(15000);
		 med.appoinment_selector();
	}

	@When("^the user clicks on the appoinments field$")
	public void the_user_clicks_on_the_appoinments_field() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		maxwait(5000);
	    med.appoinment_field();
	}

	@When("^selects the available time$")
	public void selects_the_available_time() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		maxwait(5000);
		med.select_time();
	    
	}

	@Then("^the user is navigated to the New Appoinment section$")
	public void the_user_is_navigated_to_the_New_Appoinment_section() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		maxwait(5000);
		med.new_appoinment();
	}

	@When("^the user search the patient id$")
	public void the_user_search_the_patient_id() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		maxwait(5000);
		med.search_patient();
	}

	@And("^selects the patient$")
	public void selects_the_patient() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		maxwait(5000);
		med.select_patient();
	}
	
	@Then("^takes the appoinment for the patient$")
	public void takes_the_appoinment_for_the_patient() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		maxwait(5000);
		med.selects_appoinment();
	}

}
