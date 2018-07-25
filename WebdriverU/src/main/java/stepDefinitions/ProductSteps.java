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
import pageObjects.BasePage;
import utils.DriverFactory;

public class ProductSteps extends DriverFactory {

	//page object model using methods from base page and also custom methods from sub page
	
	@Given("^the user is at the \"([^\"]*)\" page$")
    public void the_user_is_at_the_something_page(String url) {
		getDriver().get(url);
    }

    @When("^the user clicks on \"([^\"]*)\"$")
    public void the_user_clicks_on_something(String button) throws IOException, InterruptedException {
    		basePage.waitAndClickElementsUsingByLocator(By.id(button));
     }

    @Then("^the user is presented with a promo alert$")
    public void the_user_is_presented_with_a_promo_alert() throws InterruptedException, IOException {
    		productPage.printSpecialOffersVoucherCode();
    		productPage.clickOnProceedButton_Popup();
    }
	
}
