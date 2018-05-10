package stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	@Before("@MobileTest")
	public void setupmobilebrowser() {
		System.out.println("opening mobile browser");
	}
	
	@Before("@WebTest")
	public void setupwebbrowser() {
		System.out.println("opening web browser");
	}
	
	@After("@MobileTest")
	public void teardownmobilebrowser() {
		System.out.println("closing mobile browser");
	}
	
	@After("@WebTest")
	public void teardownwebbrowser() {
		System.out.println("closing web browser");
	}
}
