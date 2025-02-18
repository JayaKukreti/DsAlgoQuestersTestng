package dsAlgoTests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.chaintest.plugins.ChainTestListener;

import dsAlgoBase.Base;
import dsAlgoPages.HomePage;
import dsAlgoPages.RegisterPage;
import dsAlgoPages.SigninPage;
import dsAlgoPages.StackPage;
import dsAlgoPages.TryEditorPage;
import dsAlgoUtils.ConfigReader;
import dsAlgoUtils.TestDataProvider;

public class StackTest extends Base {

	WebDriver driver;
	HomePage homePage;
	SigninPage SigninPage;
	RegisterPage RegisterPage;
	Properties prop = ConfigReader.initializeprop();
	TryEditorPage TryEditorPage;
	StackPage StackPage;

	@BeforeMethod
	public void navigateStackPage() {

		driver = Base.getDriver();
		homePage = new HomePage(driver);
		ChainTestListener.log("Clicking Get Started button on Launch Page");
		homePage.clickLaunchPageGetstartedbutton();
		ChainTestListener.log("Navigating to Sign-in Page");
		homePage.clickSignin();
		SigninPage = new SigninPage(driver);
		ChainTestListener.log("Entering username and password");
		SigninPage.sendtextusername();
		SigninPage.sendtextpassword();
		ChainTestListener.log("Clicking Login button");
		SigninPage.clickLoginbutton();
		ChainTestListener.log("Navigating to Stack Page");
		homePage.getStartedStack();
		StackPage = new StackPage(driver);

	}

	@Test(priority = 1)
	public void navigateToOperationsInStack() {
		ChainTestListener.log("Navigating to Operations in Stack");
		StackPage.operationsinstack();
		Assert.assertTrue(StackPage.textConfirmForOperationsInStack());

	}

	@Test(priority = 2)
	public void navigateToImplementation() {
		ChainTestListener.log("Navigating to Implementation");
		StackPage.implementation();
		Assert.assertTrue(StackPage.textConfirmOfImplementation());

	}

	@Test(priority = 3)
	public void navigateToApplications() {
		ChainTestListener.log("Navigating to Applications");
		StackPage.applications();
		Assert.assertTrue(StackPage.textConfirmForApplications());

	}

	@Test(priority = 4)
	public void navigatetoOperationsInStacktryeditor() {
		ChainTestListener.log("Navigating to Operations in Stack Try Editor");

		StackPage.operationsinstack();
		StackPage.tryHere();
		Assert.assertTrue(StackPage.textconfirmfortryeditor());

	}

	@Test(priority = 5)
	public void navigatetoImplementationtryeditor() {
		ChainTestListener.log("Navigating to Implementation Try Editor");
		StackPage.implementation();
		StackPage.tryHere();
		Assert.assertTrue(StackPage.textconfirmfortryeditor());

	}

	@Test(priority = 6)
	public void navigatetoApplicationstryeditor() {
		ChainTestListener.log("Navigating to Applications Try Editor");
		StackPage.applications();
		StackPage.tryHere();
		Assert.assertTrue(StackPage.textconfirmfortryeditor());

	}

	@Test(dataProvider = "codeExecutionData", dataProviderClass = TestDataProvider.class, priority = 7)
	public void verifyCodeOperationsInStackPage(String code, String expectedResult) {
		ChainTestListener.log("Verifying code execution on Operations in Stack Page");
		StackPage.operationsinstack();
		StackPage.tryHere();
		ChainTestListener.log("Executing code: " + code);
		TryEditorPage = new TryEditorPage(driver);
		TryEditorPage.enteringCode(code);
		TryEditorPage.runButton();
		String actualResult = TryEditorPage.output();
		ChainTestListener.log("Execution result: " + actualResult);
		Assert.assertEquals(actualResult, expectedResult, "Output does not match for code: " + code);
		ChainTestListener.log("Code execution verified successfully");

	}

	@Test(dataProvider = "codeExecutionData", dataProviderClass = TestDataProvider.class, priority = 8)
	public void verifyCodeImplementationPage(String code, String expectedResult) {
		StackPage.implementation();
		StackPage.tryHere();
		ChainTestListener.log("Executing code: " + code);
		TryEditorPage = new TryEditorPage(driver);
		TryEditorPage.enteringCode(code);
		TryEditorPage.runButton();
		String actualResult = TryEditorPage.output();
		ChainTestListener.log("Execution result: " + actualResult);
		Assert.assertEquals(actualResult, expectedResult, "Output does not match for code: " + code);
		ChainTestListener.log("Code execution verified successfully");

	}

	@Test(dataProvider = "codeExecutionData", dataProviderClass = TestDataProvider.class, priority = 9)
	public void verifyCodeApplicationsPage(String code, String expectedResult) {

		StackPage.applications();
		StackPage.tryHere();
		ChainTestListener.log("Executing code: " + code);
		TryEditorPage = new TryEditorPage(driver);
		TryEditorPage.enteringCode(code);
		TryEditorPage.runButton();
		String actualResult = TryEditorPage.output();
		ChainTestListener.log("Execution result: " + actualResult);
		Assert.assertEquals(actualResult, expectedResult, "Output does not match for code: " + code);
		ChainTestListener.log("Code execution verified successfully");

	}

	@Test(priority = 10)
	public void checkErrorMessageWhenExecutingWithoutCodeInOperationsInStackPage() {
		ChainTestListener.log("Checking error message when executing without code in Operations in Stack Page");
		StackPage.operationsinstack();
		StackPage.tryHere();
		StackPage.runButton();
		Assert.fail(
				"Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");

	}

	@Test(priority = 11)
	public void checkErrorMessageWhenExecutingWithoutCodeInImplementationPage() {
		ChainTestListener.log("Checking error message when executing without code in Implementation in Stack Page");
		StackPage.implementation();
		StackPage.tryHere();
		StackPage.runButton();
		Assert.fail(
				"Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");

	}

	@Test(priority = 12)
	public void checkErrorMessageWhenExecutingWithoutCodeInApplicationsInStackPage() {
		ChainTestListener.log("Checking error message when executing without code in Applications in Stack Page");
		StackPage.applications();
		StackPage.tryHere();
		StackPage.runButton();
		Assert.fail(
				"Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");

	}

	@Test(priority = 13)
	public void seeListOfPracticeQuestionsonOperationsInStackPage() {
		ChainTestListener.log("Checking list of practice questions on Operations in Stack Page");
		StackPage.operationsinstack();
		StackPage.clickpracticequestions();
		Assert.fail("No practice questions found on the Practice Questions Page!");

	}

	@Test(priority = 14)
	public void seeListOfPracticeQuestionsonImplementationPage() {
		ChainTestListener.log("Checking list of practice questions on Implementation in Stack Page");
		StackPage.implementation();
		StackPage.clickpracticequestions();
		Assert.fail("No practice questions found on the Practice Questions Page!");

	}

	@Test(priority = 15)
	public void seeListOfPracticeQuestionsonApplicationsPage() {
		ChainTestListener.log("Checking list of practice questions on Applications in Stack Page");
		StackPage.applications();
		StackPage.clickpracticequestions();
		Assert.fail("No practice questions found on the Practice Questions Page!");

	}

	@Test(priority = 16)
	public void navigateToOperationsInStackPracticeQuestions() {
		ChainTestListener.log("Navigating to Operations in Stack Practice Questions");
		StackPage.operationsinstack();
		StackPage.clickpracticequestions();
		Assert.assertTrue(StackPage.textconfirmpracticequestion());
	}

	@Test(priority = 17)
	public void navigateToImplementationPracticeQuestions() {
		ChainTestListener.log("Navigating to Implementation in Stack Practice Questions");
		StackPage.implementation();
		StackPage.clickpracticequestions();
		Assert.assertTrue(StackPage.textconfirmpracticequestion());
	}

	@Test(priority = 18)
	public void navigateToApplicationsPracticeQuestions() {
		ChainTestListener.log("Navigating to Applications in Stack Practice Questions");
		StackPage.applications();
		StackPage.clickpracticequestions();
		Assert.assertTrue(StackPage.textconfirmpracticequestion());
	}

}