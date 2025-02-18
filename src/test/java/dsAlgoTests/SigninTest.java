package dsAlgoTests;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.chaintest.plugins.ChainTestListener;

import dsAlgoBase.Base;
import dsAlgoPages.HomePage;
import dsAlgoPages.RegisterPage;
import dsAlgoPages.SigninPage;
import dsAlgoUtils.TestDataProvider;

public class SigninTest extends Base {
	WebDriver driver;
	HomePage homePage;
	SigninPage SigninPage;
	RegisterPage RegisterPage;

	@BeforeMethod
	public void navigateToDsAlgoApplication() {
		driver = Base.getDriver();
		homePage = new HomePage(driver);
		homePage.clickLaunchPageGetstartedbutton();
	}

	@Test(dataProvider = "signinPageData", dataProviderClass = TestDataProvider.class)
	public void enterCredentials(String username, String password, String expectedResult) throws TimeoutException {
		ChainTestListener.log("Starting Sign In test with username: " + username);
		homePage.clickSignin();
		SigninPage signinPage = new SigninPage(driver);
		ChainTestListener.log("Entering credentials: Username: " + username + ", Password: " + password);
		signinPage.enteringcode(username, password);
		signinPage.clickLoginbutton();
		String actualMessage = signinPage.credentialsResult(username, password, expectedResult);
		ChainTestListener.log("Actual Message: " + actualMessage);
		ChainTestListener.log("Expected Message: " + expectedResult);
		Assert.assertEquals(actualMessage, expectedResult, "Login message does not match expected result!");
	}
}
