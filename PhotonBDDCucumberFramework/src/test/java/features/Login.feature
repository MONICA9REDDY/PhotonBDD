Feature: vTiger login Test

#used to write pre condition which is required for each scenario in feature file
Background:
Given I want to launch the browser and I will enter the url

@SmokeTest @RegressionTest
Scenario: As a user I want to login to application by using valid credentials

When login page is displayed I will enter username and password
And click on login button
Then It should navigate me to Home page

@RegressionTest
Scenario: As a user I will enter invalid username and password and it should throw me error message
When login page is displayed I will enter username "admin123" and password "manager123"
And click on login button
Then Error message should be displayed for user

@RegressionTest
Scenario: As a user I will not enter username and password I will click on login button

When click on login button
Then Error message should be displayed "You must specify a valid username and password."