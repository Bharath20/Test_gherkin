
Feature: To log and take an appoinment in Mediware

@Login
Scenario: User is logged in

Given User is in the log in page
When user enters username and password
And clicks on the login button
Then the user is logged in

@Appoinment
Scenario: To take an appoinment

When user selects the appoinment selector
And the user clicks on the appoinments field
And selects the available time
Then the user is navigated to the New Appoinment section
When the user search the patient id
And selects the patient
Then takes the appoinment for the patient
