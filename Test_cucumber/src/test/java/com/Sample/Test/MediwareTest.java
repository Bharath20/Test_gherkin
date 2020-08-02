/**
 * 
 */
package com.Sample.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "Feature/Login.feature", glue = "com.Sample.stepDefinition", format = { "pretty",
		"html:target/cucumber-reports/cucumber-pretty", "json:target/cucumber-reports/CucumberTestReport.json",
		"rerun:target/cucumber-reports/rerun.txt" }, monochrome = true, dryRun = false, strict = true, tags= {"@Login,@Appoinment"})
public class MediwareTest extends AbstractTestNGCucumberTests {

}
