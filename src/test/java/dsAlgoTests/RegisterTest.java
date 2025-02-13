package dsAlgoTests;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
	public void enterCredentials(String username, String password, String passwordconfirmation,String expectedResult )
			throws TimeoutException {
		homePage.clickRegister();
		RegisterPage = new RegisterPage(driver);
		RegisterPage.enteringcode(username, password, passwordconfirmation);
		RegisterPage.Clickregisteronregisterpage();
String actualMessage = RegisterPage.credentialsResult(username, password, passwordconfirmation, expectedResult);
System.out.println("Actual Message: " + actualMessage);
System.out.println("Expected Message: " + expectedResult);
	Assert.assertEquals(actualMessage, expectedResult, "Register message does not match expected result!");
	

	}

	
	
	

}
