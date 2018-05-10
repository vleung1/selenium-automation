Feature: Account page

@MobileTest
Scenario: Home page default login
Given User is on banking landing page
When User login into application with account "jane" and password "4321"
Then Home page is populated
And Cards displayed are "false"

@WebTest
Scenario: Home page default login
Given User is on banking landing page
When User login into application with account "john" and password "1234"
Then Home page is populated
And Cards displayed are "true"

@WebTest
Scenario: Home page default login
Given User is on banking landing page
When User login into application with account "jane" and password "4321"
Then Home page is populated
And Cards displayed are "false"

@MobileTest
Scenario: Home page default login
Given User is on banking landing page
When User signup with the following details
|joe|2345|joesmith@mail.com|9179170088|34|m|
Then Home page is populated
And Cards displayed are "false"