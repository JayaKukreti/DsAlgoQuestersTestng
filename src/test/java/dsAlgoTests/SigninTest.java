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

public class SigninTest extends Hooks {
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

	@Test(dataProvider = "signinPageData", dataProviderClass = TestDataProvider.class)
	public void enterCredentials(String username, String password, String expectedResult) throws TimeoutException {
		homePage.clickSignin();
		SigninPage = new SigninPage(driver);
		SigninPage.enteringcode(username, password);
		SigninPage.clickLoginbutton();
		String actualMessage = SigninPage.credentialsResult(username, password, expectedResult);
		System.out.println("Actual Message: " + actualMessage);
		System.out.println("Expected Message: " + expectedResult);
		Assert.assertEquals(actualMessage, expectedResult, "Login message does not match expected result!");
	}

}
