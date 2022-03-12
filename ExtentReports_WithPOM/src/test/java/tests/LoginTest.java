package tests;
 
import static extentreports.ExtentTestManager.startTest;
 
import java.lang.reflect.Method;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test(priority = 3, description = "Valid Login Scenario with wrong username and password.")
    public void validLoginTest_ValidUserNameValidPassword(Method method) {
        //ExtentReports Description
        startTest(method.getName(), "Valid Login Scenario with valid username and password.");
 
        loginPage
            .goToURL()
            .loginToURL("admin@yourstore.com", "admin")
            .goToLoginPage_HomePage()
            .verifyLogError();
    }
 
    @Test(priority = 0, description = "Invalid Login Scenario with empty username.")
    public void invalidLoginTest_EmptyUser(Method method) {
        //ExtentReports Description
        startTest(method.getName(), "Invalid Login Scenario with empty username.");
    
        loginPage
            .goToURL()
            .loginToURL("", "")
            .verifyLoginUserName("Please enter your email");
    }
    
    @Test(priority = 1, description = "Invalid Login Scenario with valid username and invalid password.")
    public void invalidLoginTest_ValidUserInValidPassword(Method method) {
        //ExtentReports Description
        startTest(method.getName(), "Invalid Login Scenario with empty username and password.");
    
        loginPage
            .goToURL()
            .loginToURL("admin@yourstore.com", "a1")
            .verifyLoginPassword("The credentials provided are incorrect");
    }
    
    @Test(priority = 2, description = "Invalid Login Scenario with invalid username and empty password.")
    public void invalidLoginTest_InvalidUserEmptyPassword(Method method) {
        //ExtentReports Description
        startTest(method.getName(), "Invalid Login Scenario with empty username and password.");
    
        loginPage
            .goToURL()
            .loginToURL("admin", "")
            .verifyLoginUserName("Wrong email");
    }
}