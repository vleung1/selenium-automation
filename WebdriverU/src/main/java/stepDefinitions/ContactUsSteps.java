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

	WebDriver driver;

	@Given("^the user is at the contact us form$")
	public void the_user_is_at_the_contact_us_form() {
		getDriver().get("http://www.webdriveruniversity.com/Contact-Us/contactus.html");
	}

	@When("^the user enters a valid firstname$")
	public void the_user_enters_a_valid_firstname() {
		getDriver().findElement(By.cssSelector("input[name='first_name']")).sendKeys("tom");
	}

	@And("^the user enters a valid lastname$")
	public void the_user_enters_a_valid_lastname(DataTable dataTable) {
		List<List<String>> data = dataTable.raw();
		getDriver().findElement(By.cssSelector("input[name='last_name']")).sendKeys(data.get(0).get(1));
	}

	@And("^the user enters a valid email address$")
	public void the_user_enters_a_valid_email_address() {
		getDriver().findElement(By.cssSelector("input[name='email']")).sendKeys("tom@mail.com");
	}

	@And("^the user enters comments$")
	public void the_user_enters_comments(DataTable dataTable) {
		List<List<String>> data = dataTable.raw();
		getDriver().findElement(By.cssSelector("textarea[name='message']")).sendKeys(data.get(0).get(0));
		getDriver().findElement(By.cssSelector("textarea[name='message']")).sendKeys(data.get(0).get(1));
	}

	@And("^the user clicks on the submit button$")
	public void the_user_clicks_on_the_submit_button() {
		getDriver().findElement(By.xpath("//input[@value='SUBMIT']")).click();
	}

	@Then("^the information is successfully submitted$")
	public void the_information_is_successfully_submitted() {
		// Thank You for your Message!
		WebElement thanksContactUsPage = getDriver().findElement(By.xpath(".//*[@id='contact_reply']/h1"));
		Assert.assertEquals("thankyouforyourmessage!",
				thanksContactUsPage.getText().toLowerCase().replaceAll("[ ()0-9]", ""));
	}

}
