package dsAlgoTests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
		homePage.clickLaunchPageGetstartedbutton();
	}

	@Test
	public void navigateToRegister() {
		RegisterPage = new RegisterPage(driver);
		homePage.clickRegister();
		Assert.assertTrue(RegisterPage.textConfirmforRegister());
	}

	@Test
	public void navigateToLogin() {
		SigninPage = new SigninPage(driver);
		homePage.clickSignin();
		Assert.assertTrue(SigninPage.confirmtextsignin());

	}
	
	@Test()
	public void errorMessageWhenClickedOnDataStructureBeforeSignin() {

		homePage.getStartedDataStructureIntroduction();
		String actualMessage = homePage.errorMessageGetStarted();
		System.out.println("actualMessage is :" + actualMessage);
		String expectedMessage = homePage.expectedmessage();
		System.out.println("expectedMessage is :" + expectedMessage);

		Assert.assertEquals(actualMessage, expectedMessage, "Message not matched");
	}

	@Test
	public void GetstartedArrayerrorBeforeSignin() {

		homePage.getStartedArray();
		String actualMessage = homePage.errorMessageGetStarted();
		System.out.println("actualMessage is :" + actualMessage);
		String expectedMessage = homePage.expectedmessage();
		System.out.println("expectedMessage is :" + expectedMessage);

		Assert.assertEquals(actualMessage, expectedMessage, "Message not matched");
	}

	@Test()
	public void GetstartedStackerrorBeforeSignin() {

		homePage.getStartedStack();
		String actualMessage = homePage.errorMessageGetStarted();
		System.out.println("actualMessage is :" + actualMessage);
		String expectedMessage = homePage.expectedmessage();
		System.out.println("expectedMessage is :" + expectedMessage);

		Assert.assertEquals(actualMessage, expectedMessage, "Message not matched");
	}

	@Test()
	public void GetstartedQueueerrorBeforeSignin() {

		homePage.getStartedQueue();
		String actualMessage = homePage.errorMessageGetStarted();
		System.out.println("actualMessage is :" + actualMessage);
		String expectedMessage = homePage.expectedmessage();
		System.out.println("expectedMessage is :" + expectedMessage);

		Assert.assertEquals(actualMessage, expectedMessage, "Message not matched");
	}

	@Test()
	public void GetstartedLinkedListerrorBeforeSignin() {

		homePage.getStartedLinkedlist();
		String actualMessage = homePage.errorMessageGetStarted();
		System.out.println("actualMessage is :" + actualMessage);
		String expectedMessage = homePage.expectedmessage();
		System.out.println("expectedMessage is :" + expectedMessage);

		Assert.assertEquals(actualMessage, expectedMessage, "Message not matched");
	}

	@Test()
	public void GetstartedTreeerrorBeforeSignin() {

		homePage.getStartedTree();
		String actualMessage = homePage.errorMessageGetStarted();
		System.out.println("actualMessage is :" + actualMessage);
		String expectedMessage = homePage.expectedmessage();
		System.out.println("expectedMessage is :" + expectedMessage);

		Assert.assertEquals(actualMessage, expectedMessage, "Message not matched");
	}

	@Test()
	public void GetstartedGrapherrorBeforeSignin() {

		homePage.getStartedofGraph();
		String actualMessage = homePage.errorMessageGetStarted();
		System.out.println("actualMessage is :" + actualMessage);
		String expectedMessage = homePage.expectedmessage();
		System.out.println("expectedMessage is :" + expectedMessage);

		Assert.assertEquals(actualMessage, expectedMessage, "Message not matched");
	}

	@Test()
	public void dropdownoptionGrapherrorBeforeSignin() {

		homePage.clickDataStructuresDropDown();
		homePage.graph();
		String actualMessage = homePage.errorMessageGetStarted();
		System.out.println("actualMessage is :" + actualMessage);
		String expectedMessage = homePage.expectedmessage();
		System.out.println("expectedMessage is :" + expectedMessage);

		Assert.assertEquals(actualMessage, expectedMessage, "Message not matched");
	}

	@Test()
	public void dropdownoptionTreeerrorBeforeSignin() {

		homePage.clickDataStructuresDropDown();
		homePage.tree();
		String actualMessage = homePage.errorMessageGetStarted();
		System.out.println("actualMessage is :" + actualMessage);
		String expectedMessage = homePage.expectedmessage();
		System.out.println("expectedMessage is :" + expectedMessage);

		Assert.assertEquals(actualMessage, expectedMessage, "Message not matched");
	}

	@Test()
	public void dropdownoptionQueueerrorBeforeSignin() {

		homePage.clickDataStructuresDropDown();
		homePage.queue();
		String actualMessage = homePage.errorMessageGetStarted();
		System.out.println("actualMessage is :" + actualMessage);
		String expectedMessage = homePage.expectedmessage();
		System.out.println("expectedMessage is :" + expectedMessage);

		Assert.assertEquals(actualMessage, expectedMessage, "Message not matched");
	}

	@Test()
	public void dropdownoptionStackerrorBeforeSignin() {

		homePage.clickDataStructuresDropDown();
		homePage.stack();
		String actualMessage = homePage.errorMessageGetStarted();
		System.out.println("actualMessage is :" + actualMessage);
		String expectedMessage = homePage.expectedmessage();
		System.out.println("expectedMessage is :" + expectedMessage);

		Assert.assertEquals(actualMessage, expectedMessage, "Message not matched");
	}

	@Test()
	public void dropdownoptionLinkedListerrorBeforeSignin() {

		homePage.clickDataStructuresDropDown();
		homePage.linkedList();
		String actualMessage = homePage.errorMessageGetStarted();
		System.out.println("actualMessage is :" + actualMessage);
		String expectedMessage = homePage.expectedmessage();
		System.out.println("expectedMessage is :" + expectedMessage);

		Assert.assertEquals(actualMessage, expectedMessage, "Message not matched");
	}

	@Test()
	public void dropdownoptionArrayserrorBeforeSignin() {

		homePage.clickDataStructuresDropDown();
		homePage.arrays();
		String actualMessage = homePage.errorMessageGetStarted();
		System.out.println("actualMessage is :" + actualMessage);
		String expectedMessage = homePage.expectedmessage();
		System.out.println("expectedMessage is :" + expectedMessage);

		Assert.assertEquals(actualMessage, expectedMessage, "Message not matched");
	}

}