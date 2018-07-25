package stepDefinitions;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.DriverFactory;

import org.junit.Assert;

public class ContactUsSteps extends DriverFactory {

	//page object model using custom methods defined in sub page
	
	@Given("^the user is at the contact us form$")
	public void the_user_is_at_the_contact_us_form() throws IOException {
		contactUsPage.getContactUsPage();
	}

	@When("^the user enters a valid firstname$")
	public void the_user_enters_a_valid_firstname() throws Exception {
		contactUsPage.enterFirstName("Vin");
	}

	@And("^the user enters a valid lastname$")
	public void the_user_enters_a_valid_lastname(DataTable dataTable) throws Exception {
		contactUsPage.enterLasttName(dataTable, 0, 2);
	}

	@And("^the user enters a valid email address$")
	public void the_user_enters_a_valid_email_address() throws Exception {
		contactUsPage.enterEmailAddress("vin@mail.com");
	}

	@And("^the user enters comments$")
	public void the_user_enters_comments(DataTable dataTable) throws Exception {
		contactUsPage.enterComments(dataTable, 0, 1);
	}

	@And("^the user clicks on the submit button$")
	public void the_user_clicks_on_the_submit_button() throws Exception {
		contactUsPage.clickOnSubmiButton();
	}

	@Then("^the information is successfully submitted$")
	public void the_information_is_successfully_submitted() throws Exception {
		contactUsPage.confirmContactUsFormSubmissionWasSuccessful();
	}

}
