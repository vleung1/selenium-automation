package stepDefinitions;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.DriverFactory;

public class ProductSteps extends DriverFactory {

	WebDriver driver;
	
	@Given("^the user is at the \"([^\"]*)\" page$")
    public void the_user_is_at_the_something_page(String url) {
		getDriver().get(url);
    }

    @When("^the user clicks on \"([^\"]*)\"$")
    public void the_user_clicks_on_something(String button) {
    		getDriver().findElement(By.id(button)).click();
    }

    @Then("^the user is presented with a promo alert$")
    public void the_user_is_presented_with_a_promo_alert() throws InterruptedException {
    		WebDriverWait wait = new WebDriverWait(getDriver(), 15);
    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Proceed']")));
    		getDriver().findElement(By.xpath("//button[text()='Proceed']")).click();
    }
	
}
