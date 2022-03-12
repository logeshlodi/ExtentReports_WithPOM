package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pageObjects.LoginPageObjects;

public class LoginTestCase {

	@Test
	public void login() throws InterruptedException {

		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.phptravels.net/login");
		Thread.sleep(3000);

		// PageFactory.initElements(driver, LoginPageObjects.class);

		/*
		 * LoginPageObjects.username.sendKeys("user@phptravels.com");
		 * LoginPageObjects.password.sendKeys("demouser");
		 * LoginPageObjects.submit.click();
		 */

		PageFactory.initElements(driver, LoginPageObjects.class);

		LoginPageObjects.email.sendKeys("user@phptravels.com");
		LoginPageObjects.password.sendKeys("demouser");
		LoginPageObjects.submitButton.click();

		driver.quit();

	}

}
