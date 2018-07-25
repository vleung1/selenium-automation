package pageObjects;

import java.io.IOException;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import cucumber.api.DataTable;

public class ContactUsPage extends BasePage{
	public @FindBy(xpath = "//input[@name='first_name']") WebElement textfield_FirstName;
	public @FindBy(xpath = "//input[@name='last_name']") WebElement textfield_LastName;
	public @FindBy(xpath = "//input[@name='email']") WebElement textfield_EmailAddress;
	public @FindBy(xpath = "//textarea[@name='message']") WebElement textfield_Message;
	public @FindBy(xpath = "//input[@value='SUBMIT']") WebElement button_Submit;
	
	public ContactUsPage() throws IOException {
		super();
	}
	
	public ContactUsPage getContactUsPage() throws IOException {
		getDriver().get("http://www.webdriveruniversity.com/Contact-Us/contactus.html");
		return new ContactUsPage();
	}
	
	public ContactUsPage enterFirstName(String firstName) throws Exception {
		sendKeysToWebElement(textfield_FirstName, firstName);
		return new ContactUsPage();
	}
	
	public ContactUsPage enterLasttName(DataTable dataTable, int row, int column) throws Exception {
		List<List<String>> data = dataTable.raw();
		sendKeysToWebElement(textfield_LastName, data.get(row).get(column));
		return new ContactUsPage();
	}
	
	public ContactUsPage enterEmailAddress(String emailAddress) throws Exception {
		sendKeysToWebElement(textfield_EmailAddress, emailAddress);
		return new ContactUsPage();
	}
	
	public ContactUsPage enterComments(DataTable dataTable, int row, int column) throws Exception {
		List<List<String>> data = dataTable.raw();
		sendKeysToWebElement(textfield_Message, data.get(row).get(column));
		return new ContactUsPage();
	}
	
	public ContactUsPage clickOnSubmiButton() throws Exception {
		waitAndClickElement(button_Submit);
		return new ContactUsPage();
	}
	
	public ContactUsPage confirmContactUsFormSubmissionWasSuccessful() throws Exception {
		WebElement thanksContactUsPage = getDriver().findElement(By.xpath(".//*[@id='contact_reply']/h1"));
		WaitUntilWebElementIsVisible(thanksContactUsPage);
		Assert.assertEquals("thankyouforyourmessage!", thanksContactUsPage.getText().toLowerCase().replaceAll("[ ()0-9]", ""));
		return new ContactUsPage();
	}

}
