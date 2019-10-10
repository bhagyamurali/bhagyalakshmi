package Cucumber.Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class LoginTest {
	
	WebDriver driver;
	@Given("^Lanuch the AUT in the browser$")
	public void lanuch_the_AUT_in_the_browser() throws Throwable {
		driver = UtilityClass.openBrowser("chrome");
		driver.get("http://newtours.demoaut.com/");
	}

	@When("^enter the credentials and perform login$")
	public void enter_the_credentials_and_perform_login() throws Throwable {
		Pages page= new Pages(driver);
		page.do_login("tutorial", "tutorial");
	}

	@Then("^Test if login works corectly$")
	public void test_if_login_works_corectly() throws Throwable {
		WebDriverWait wait= new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("tripType")));
		Assert.assertEquals(driver.getTitle(), "Find a Flight: Mercury Tours:");
		System.out.println("Logged in Successfully !!");
		driver.close();
	}

}
