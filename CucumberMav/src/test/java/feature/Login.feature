Feature: Application Login

Background:
Given Validate the browser
When Browser is triggered
Then check if browser is displayed

@RegressionTest
Scenario: Home page default login
Given User is on banking landing page
When User login into application with account "john" and password "1234"
Then Home page is populated
And Cards displayed are "true"

@SmokeTest
Scenario: Home page default login
Given User is on banking landing page
When User login into application with account "jane" and password "4321"
Then Home page is populated
And Cards displayed are "false"

@RegressionTest
Scenario: Home page default login
Given User is on banking landing page
When User signup with the following details
|joe|2345|joesmith@mail.com|9179170088|34|m|
Then Home page is populated
And Cards displayed are "false"

@SanityTest
Scenario Outline: Home page default login
Given User is on banking landing page
When User login to application with account <username> and password <password>
Then Home page is populated
And Cards displayed are "true"

Examples:
|username|password|
|user1   |pass1   |
|user2   |pass2	  |
|user3   |pass3   |
|pass4   |pass4	  |