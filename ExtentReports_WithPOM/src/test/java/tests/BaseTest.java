package tests;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import logs.Log;
 
public class BaseTest {
    public WebDriver driver;
    public LoginPage loginPage;
 
    public WebDriver getDriver() {
        return driver;
    }
 
    @BeforeClass
    public void classLevelSetup() {
        Log.info("Tests is starting!");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }
 
    @BeforeMethod
    public void methodLevelSetup() {
    	loginPage = new LoginPage(driver);
    }
 
    @AfterClass
    public void teardown() {
        Log.info("Tests are ending!");
        driver.quit();
    }
}