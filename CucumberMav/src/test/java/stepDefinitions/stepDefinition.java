package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;

import java.util.List;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class stepDefinition {
	
	@Given("^Validate the browser$")
    public void validate_the_browser() throws Throwable {
		System.out.println("Deciding browser to open");
    }

    @When("^Browser is triggered$")
    public void browser_is_triggered() throws Throwable {
    	System.out.println("Triggering browser");
    }

    @Then("^check if browser is displayed$")
    public void check_if_browser_is_displayed() throws Throwable {
    	System.out.println("Browser is open");
    }
	

    @Given("^User is on banking landing page$")
    public void user_is_on_banking_landing_page() throws Throwable {
        //code to navigate to landing page
    	System.out.println("Navigated to landing page");
    }

    @When("^User login into application with account \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_login_into_application_with_account_something_and_password_something(String strArg1, String strArg2) throws Throwable {
        //code to log in
    	System.out.println("Logged in with " + strArg1 + " and " + strArg2);
    }

    @Then("^Home page is populated$")
    public void home_page_is_populated() throws Throwable {
        //verify the home page
    	System.out.println("Verified home page");
    }
    /*
    @And("^Cards displayed are \"([^\"]*)\"$")
    public void cards_displayed_are_something(String strArg1) throws Throwable {
    	System.out.println("Cards displayed is " + strArg1);
    }
*/
    
    @When("^User signup with the following details$")
    public void user_signup_with_the_following_details(DataTable data) throws Throwable {
    	List<List<String>> obj = data.raw();
    	System.out.println(obj.get(0).get(0));
    	System.out.println(obj.get(0).get(1));
    	System.out.println(obj.get(0).get(2));
    	System.out.println(obj.get(0).get(3));
    	System.out.println(obj.get(0).get(4));
    	System.out.println(obj.get(0).get(5));

    }
    
    @When("^User login to application with account (.+) and password (.+)$")
    public void user_login_into_application_with_account_and_password(String username, String password) throws Throwable {
        System.out.println("Logging in with " + username + " and " + password);
    }
}
