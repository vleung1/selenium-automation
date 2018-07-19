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
import org.junit.Assert;

public class ContactUsSteps {
	
	WebDriver driver;

	@Before()
	public void setUp() throws IOException {
		System.setProperty("webdriver.chrome.driver", Paths.get(System.getProperty("user.dir")).toRealPath() + "//src//test//java//resources//other//chromedriver");
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@After()
	public void tearDown() {
		this.driver.manage().deleteAllCookies();
		this.driver.quit();
	}
	
	@Given("^the user is at the contact us form$")
    public void the_user_is_at_the_contact_us_form() {
		driver.get("http://www.webdriveruniversity.com/Contact-Us/contactus.html");
    }

    @When("^the user enters a valid firstname$")
    public void the_user_enters_a_valid_firstname() {
    		driver.findElement(By.cssSelector("input[name='first_name']")).sendKeys("tom");
    }

    @And("^the user enters a valid lastname$")
    public void the_user_enters_a_valid_lastname(DataTable dataTable) {
    		List<List<String>> data = dataTable.raw();
    		driver.findElement(By.cssSelector("input[name='last_name']")).sendKeys(data.get(0).get(1));
    	}

    @And("^the user enters a valid email address$")
    public void the_user_enters_a_valid_email_address() {
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("tom@mail.com");
    }

    @And("^the user enters comments$")
    public void the_user_enters_comments(DataTable dataTable) {
		List<List<String>> data = dataTable.raw();
		driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys(data.get(0).get(0));
		driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys(data.get(0).get(1));
    }

    @And("^the user clicks on the submit button$")
    public void the_user_clicks_on_the_submit_button() {
    		driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
    }

    @Then("^the information is successfully submitted$")
    public void the_information_is_successfully_submitted() {
    	//Thank You for your Message!
    	WebElement thanksContactUsPage = driver.findElement(By.xpath(".//*[@id='contact_reply']/h1"));
    	Assert.assertEquals("thankyouforyourmessage!", thanksContactUsPage.getText().toLowerCase().replaceAll("[ ()0-9]", ""));
    }
    
}
