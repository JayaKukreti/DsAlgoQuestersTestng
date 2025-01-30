package dsAlgoTests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dsAlgoHooks.Hooks;
import dsAlgoPages.HomePage;
import dsAlgoPages.RegisterPage;
import dsAlgoPages.SigninPage;
import dsAlgoUtils.ConfigReader;
import dsAlgoUtils.TestDataProvider;

public class SigninTest extends Hooks {

	WebDriver driver;
	HomePage Hg;
	SigninPage Sg;
	RegisterPage Rg;
	Properties prop = ConfigReader.initializeProp();

	@BeforeMethod
	public void navigateToDsAlgoApplication() {
		driver = Hooks.getDriver();
		Hg = new HomePage(driver);
		Sg = new SigninPage(driver);
		Hg.clickLaunchPageGetstartedbutton();
	}

	@Test
	public void navigateToLogin() {
		Hg.clickSignin();
		Assert.assertTrue(Sg.confirmtextsignin(), "Sign-in page did not load properly.");

	}
//**TC01- Valid Username and Password**
	@Test(dataProvider = "Credtionals", dataProviderClass = TestDataProvider.class)
	public void verifyLoginWithValidcreditionals(String username, String password) {

		Sg = new SigninPage(driver);
		Hg.clickSignin();
		System.out.println("Entering username: " + username);
		Sg.enterUsernameTxtBox(username);
		 System.out.println("Entering password: " + password);
		Sg.enterPasswordTxtBox(password);
		System.out.println("Clicking login button");
		Sg.clickLoginbutton();
        String actualmessage = Sg.loggedinmessage();
		System.out.println("actualmessage is :" + actualmessage);
		//String expectedmessage = actualmessage.contains("You are logged in") ? "You are logged in" : "Login failed";
		String expectedmessage = Sg.switchToElementAndGetValidationMessage();
		System.out.println("expectedmessage is :" + expectedmessage);
		 if (actualmessage.contains("You are logged in")) {
		        expectedmessage = "You are logged in";  // Expected success message
		    } else {
		        expectedmessage = "No validation message available"; // If there's a validation error
		    }
		Assert.assertEquals(actualmessage, expectedmessage, "Login message does not match!");
	}

	
	//TC02
	@Test(dataProvider = "Credtionals", dataProviderClass = TestDataProvider.class)
	public void verifyLoginWithInValidUsernameValidPassword(String username, String password) {
		Sg = new SigninPage(driver);
		Hg.clickSignin();
		System.out.println("Entering Invalid username: " + username);
		Sg.enterUsernameTxtBox(username);
		 System.out.println("Entering valid password: " + password);
		Sg.enterPasswordTxtBox(password);
		System.out.println("Clicking login button");
		Sg.clickLoginbutton();
        String actualmessage = Sg.errormessage();
		System.out.println("actualmessage is :" + actualmessage);
		String expectedmessage = "Invalid Username and Password"; // Adjust as per actual UI error

	    // Validate error message
	    Assert.assertEquals(actualmessage, expectedmessage, "Login error message does not match!");
	}
		
}
