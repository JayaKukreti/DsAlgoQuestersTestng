package dsAlgoTests;

import java.util.concurrent.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.chaintest.plugins.ChainTestListener;
import dsAlgoHooks.Hooks;
import dsAlgoPages.HomePage;
import dsAlgoPages.RegisterPage;
import dsAlgoPages.SigninPage;
import dsAlgoUtils.TestDataProvider;

public class RegisterTest extends Hooks {
	WebDriver driver;
	HomePage homePage;
	SigninPage SigninPage;
	RegisterPage RegisterPage;

	@BeforeMethod
	public void navigateToDsAlgoApplication() {
		driver = Hooks.getDriver();
		homePage = new HomePage(driver);
		homePage.clickLaunchPageGetstartedbutton();
	}

	@Test(dataProvider = "RegisterPageData", dataProviderClass = TestDataProvider.class)
	public void enterCredentials(String username, String password, String passwordconfirmation, String expectedResult)
	        throws TimeoutException {
	    ChainTestListener.log("Starting Register Page test with username: " + username);
	    homePage.clickRegister();
	    RegisterPage registerPage = new RegisterPage(driver);
	    ChainTestListener.log("Entering credentials: Username: " + username + ", Password: " + password);
	    registerPage.enteringcode(username, password, passwordconfirmation);
	    registerPage.Clickregisteronregisterpage();
	    String actualMessage = registerPage.credentialsResult(username, password, passwordconfirmation, expectedResult);
	    ChainTestListener.log("Actual Message: " + actualMessage);
	    ChainTestListener.log("Expected Message: " + expectedResult);
	    Assert.assertEquals(actualMessage, expectedResult, "Register message does not match expected result!"); 
	    if(actualMessage.equals(expectedResult)) {
	        ChainTestListener.log("Registration successful with expected result.");
	    } else {
	        ChainTestListener.log("Registration failed. Unexpected result.");
	    }
	}
}
