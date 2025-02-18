package dsAlgoTests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;

import dsAlgoBase.Base;
import dsAlgoPages.HomePage;
import dsAlgoPages.RegisterPage;
import dsAlgoPages.SigninPage;

public class HomeTest extends Base {
	WebDriver driver;
	HomePage homePage;
	SigninPage SigninPage;
	RegisterPage RegisterPage;

	@BeforeMethod
	public void navigateToDsAlgoApplication() {
		driver = Base.getDriver();
		homePage = new HomePage(driver);
		ChainTestListener.log("Clicking Get Started button on Launch Page");
		homePage.clickLaunchPageGetstartedbutton();
	}

	@Test(priority=1)
	public void navigateToRegister() {
		ChainTestListener.log("Navigating to Register Page");
		RegisterPage = new RegisterPage(driver);
		homePage.clickRegister();
		Assert.assertTrue(RegisterPage.textConfirmforRegister());
		ChainTestListener.log("Successfully navigated to Register Page");
	}

	@Test(priority=2)
	public void navigateToLogin() {
		ChainTestListener.log("Navigating to Sign-in Page");
		SigninPage = new SigninPage(driver);
		homePage.clickSignin();
		Assert.assertTrue(SigninPage.confirmtextsignin());
		ChainTestListener.log("Successfully navigated to Sign-in Page");

	}
	
	@Test(priority=3)
	public void errorMessageWhenClickedOnDataStructureBeforeSignin() {
		ChainTestListener.log("Checking error message for Data Structure Introduction Page before sign-in");
		homePage.getStartedDataStructureIntroduction();
		String actualMessage = homePage.errorMessageGetStarted();
		System.out.println("actualMessage is :" + actualMessage);
		String expectedMessage = homePage.expectedmessage();
		System.out.println("expectedMessage is :" + expectedMessage);

		Assert.assertEquals(actualMessage, expectedMessage, "Message not matched");
		ChainTestListener.log("Error message validation completed");
	}

	@Test(priority=4)
	public void GetstartedArrayerrorBeforeSignin() {
		ChainTestListener.log("Checking error message for Array before sign-in");
		homePage.getStartedArray();
		String actualMessage = homePage.errorMessageGetStarted();
		System.out.println("actualMessage is :" + actualMessage);
		String expectedMessage = homePage.expectedmessage();
		System.out.println("expectedMessage is :" + expectedMessage);

		Assert.assertEquals(actualMessage, expectedMessage, "Message not matched");
		ChainTestListener.log("Error message validation completed");
	}

	@Test(priority=5)
	public void GetstartedStackerrorBeforeSignin() {
		ChainTestListener.log("Checking error message for Stack before sign-in");
		homePage.getStartedStack();
		String actualMessage = homePage.errorMessageGetStarted();
		System.out.println("actualMessage is :" + actualMessage);
		String expectedMessage = homePage.expectedmessage();
		System.out.println("expectedMessage is :" + expectedMessage);

		Assert.assertEquals(actualMessage, expectedMessage, "Message not matched");
		ChainTestListener.log("Error message validation completed");
	}

	@Test(priority=6)
	public void GetstartedQueueerrorBeforeSignin() {
		ChainTestListener.log("Checking error message for Queue before sign-in");
		homePage.getStartedQueue();
		String actualMessage = homePage.errorMessageGetStarted();
		System.out.println("actualMessage is :" + actualMessage);
		String expectedMessage = homePage.expectedmessage();
		System.out.println("expectedMessage is :" + expectedMessage);

		Assert.assertEquals(actualMessage, expectedMessage, "Message not matched");
		ChainTestListener.log("Error message validation completed");
	}

	@Test(priority=7)
	public void GetstartedLinkedListerrorBeforeSignin() {
		ChainTestListener.log("Checking error message for Linked List before sign-in");
		homePage.getStartedLinkedlist();
		String actualMessage = homePage.errorMessageGetStarted();
		System.out.println("actualMessage is :" + actualMessage);
		String expectedMessage = homePage.expectedmessage();
		System.out.println("expectedMessage is :" + expectedMessage);

		Assert.assertEquals(actualMessage, expectedMessage, "Message not matched");
		ChainTestListener.log("Error message validation completed");
	}

	@Test(priority=8)
	public void GetstartedTreeerrorBeforeSignin() {
		ChainTestListener.log("Checking error message for Tree before sign-in");
		homePage.getStartedTree();
		String actualMessage = homePage.errorMessageGetStarted();
		System.out.println("actualMessage is :" + actualMessage);
		String expectedMessage = homePage.expectedmessage();
		System.out.println("expectedMessage is :" + expectedMessage);

		Assert.assertEquals(actualMessage, expectedMessage, "Message not matched");
		ChainTestListener.log("Error message validation completed");
	}

	@Test(priority=9)
	public void GetstartedGrapherrorBeforeSignin() {
		ChainTestListener.log("Checking error message for Graph before sign-in");
		homePage.getStartedofGraph();
		String actualMessage = homePage.errorMessageGetStarted();
		System.out.println("actualMessage is :" + actualMessage);
		String expectedMessage = homePage.expectedmessage();
		System.out.println("expectedMessage is :" + expectedMessage);

		Assert.assertEquals(actualMessage, expectedMessage, "Message not matched");
		ChainTestListener.log("Error message validation completed");
	}

	@Test(priority=10)
	public void dropdownoptionGrapherrorBeforeSignin() {
		ChainTestListener.log("Checking error message for Graph dropdown before sign-in");
		homePage.clickDataStructuresDropDown();
		homePage.graph();
		String actualMessage = homePage.errorMessageGetStarted();
		System.out.println("actualMessage is :" + actualMessage);
		String expectedMessage = homePage.expectedmessage();
		System.out.println("expectedMessage is :" + expectedMessage);

		Assert.assertEquals(actualMessage, expectedMessage, "Message not matched");
		ChainTestListener.log("Error message validation completed");
	}

	@Test(priority=11)
	public void dropdownoptionTreeerrorBeforeSignin() {
		ChainTestListener.log("Checking error message for Tree dropdown before sign-in");
		homePage.clickDataStructuresDropDown();
		homePage.tree();
		String actualMessage = homePage.errorMessageGetStarted();
		System.out.println("actualMessage is :" + actualMessage);
		String expectedMessage = homePage.expectedmessage();
		System.out.println("expectedMessage is :" + expectedMessage);

		Assert.assertEquals(actualMessage, expectedMessage, "Message not matched");
		ChainTestListener.log("Error message validation completed");
	}

	@Test(priority=12)
	public void dropdownoptionQueueerrorBeforeSignin() {
		ChainTestListener.log("Checking error message for Queue dropdown before sign-in");
		homePage.clickDataStructuresDropDown();
		homePage.queue();
		String actualMessage = homePage.errorMessageGetStarted();
		System.out.println("actualMessage is :" + actualMessage);
		String expectedMessage = homePage.expectedmessage();
		System.out.println("expectedMessage is :" + expectedMessage);

		Assert.assertEquals(actualMessage, expectedMessage, "Message not matched");
		ChainTestListener.log("Error message validation completed");
	}

	@Test(priority=13)
	public void dropdownoptionStackerrorBeforeSignin() {
		ChainTestListener.log("Checking error message for Stack dropdown before sign-in");
		homePage.clickDataStructuresDropDown();
		homePage.stack();
		String actualMessage = homePage.errorMessageGetStarted();
		System.out.println("actualMessage is :" + actualMessage);
		String expectedMessage = homePage.expectedmessage();
		System.out.println("expectedMessage is :" + expectedMessage);

		Assert.assertEquals(actualMessage, expectedMessage, "Message not matched");
		ChainTestListener.log("Error message validation completed");
	}

	@Test(priority=14)
	public void dropdownoptionLinkedListerrorBeforeSignin() {
		ChainTestListener.log("Checking error message for LinkedList dropdown before sign-in");
		homePage.clickDataStructuresDropDown();
		homePage.linkedList();
		String actualMessage = homePage.errorMessageGetStarted();
		System.out.println("actualMessage is :" + actualMessage);
		String expectedMessage = homePage.expectedmessage();
		System.out.println("expectedMessage is :" + expectedMessage);

		Assert.assertEquals(actualMessage, expectedMessage, "Message not matched");
		ChainTestListener.log("Error message validation completed");
	}

	@Test(priority=15)
	public void dropdownoptionArrayserrorBeforeSignin() {
		ChainTestListener.log("Checking error message for Array dropdown before sign-in");
		homePage.clickDataStructuresDropDown();
		homePage.arrays();
		String actualMessage = homePage.errorMessageGetStarted();
		System.out.println("actualMessage is :" + actualMessage);
		String expectedMessage = homePage.expectedmessage();
		System.out.println("expectedMessage is :" + expectedMessage);

		Assert.assertEquals(actualMessage, expectedMessage, "Message not matched");
		ChainTestListener.log("Error message validation completed");
	}

}