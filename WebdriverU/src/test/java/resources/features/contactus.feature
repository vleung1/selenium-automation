Feature: Submit data to webdriveruniversity.com using contact form

Scenario: Contact us form submits valid data
	Given the user is at the contact us form
	When the user enters a valid firstname
	And the user enters a valid lastname
	| woods | jackson | jones|
	And the user enters a valid email address 
	And the user enters comments
	| example comment one | example comment two |
	And the user clicks on the submit button
	Then the information is successfully submitted