package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pageObjects.LoginPageObjects;
import pageObjects.UpdateProfileObjects;

public class UpdateProfile {


	@Test
	public void updateProfile() throws InterruptedException{

		WebDriver driver= new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.phptravels.net/login");
		Thread.sleep(3000);

		PageFactory.initElements(driver, LoginPageObjects.class);
		LoginPageObjects.email.sendKeys("user@phptravels.com");
		LoginPageObjects.password.sendKeys("demouser");
		LoginPageObjects.submitButton.click();
		Thread.sleep(5000);
		PageFactory.initElements(driver, UpdateProfileObjects.class);
		UpdateProfileObjects.myprofile.click();

		UpdateProfileObjects.phoneNumber.sendKeys("1234567890");
		UpdateProfileObjects.city.sendKeys("Kings Landing");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(ExpectedConditions.elementToBeClickable(UpdateProfileObjects.submitButton));
		UpdateProfileObjects.submitButton.submit();

		driver.quit();



	}

}
