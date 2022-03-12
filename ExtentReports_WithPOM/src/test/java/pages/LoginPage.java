package pages;


import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import logs.JSErrorLogs;
import logs.Log;

public class LoginPage extends BasePage {
	/**
	 * Constructor
	 */
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	String baseURL = "https://admin-demo.nopcommerce.com/";

	/**
	 * Web Elements
	 */
	By userNameId                = By.id("Email");
	By passwordId                = By.id("Password");
	By loginButtonId             = By.xpath("//button[@type='submit']");
	By errorMessageUsername      = By.id("Email-error");
	By errorMessagePassword      = By.xpath("//form/div[1]/ul/li");
	By logoutButton = By.xpath("//a[contains(.,'Logout')]");

	/**
	 * Page Methods
	 */
	//Go to Homepage
	public LoginPage goToURL() {
		Log.info("Opening the Website.");
		driver.get(baseURL);
		return this;
	}

	public LoginPage loginToURL(String username, String password) {
		Log.info("Trying to login the URL.");
		userNameId.findElement(driver).clear();
		passwordId.findElement(driver).clear();
		writeText(userNameId, username);
		writeText(passwordId, password);
		click(loginButtonId);
		return this;
	}

	//Go to LoginPage
	public LoginPage goToLoginPage_HomePage() {
		Log.info("Going to Login Page..");
		
		/*
		 * driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		 * wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
		 * click(logoutButton);
		 */		
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(logoutButton)).click().perform();
				
		return this;
	}

	//Verify Username Condition
	public LoginPage verifyLoginUserName(String expectedText) {
		Log.info("Verifying login username.");
		waitVisibility(errorMessageUsername);
		assertEquals(readText(errorMessageUsername), expectedText);
		return this;
	}

	//Verify Password Condition
	public LoginPage verifyLoginPassword(String expectedText) {
		Log.info("Verifying login password.");
		waitVisibility(errorMessagePassword);
		assertEquals(readText(errorMessagePassword), expectedText);
		return this;
	}

	//Verify Password Condition
	public LoginPage verifyLogError() {
		Log.info("Verifying javascript login errors.");
		//assertTrue(JSErrorLogs.isLoginErrorLog(driver));
		return this;
	}
}