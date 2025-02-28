package dsAlgoTests;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
	public void navigateGraphPage() {
		driver = Base.getDriver();
		homePage = new HomePage(driver);
		homePage.clickLaunchPageGetstartedbutton();
		homePage.clickSignin();
		SigninPage = new SigninPage(driver);
		SigninPage.sendtextusername();
		SigninPage.sendtextpassword();
		SigninPage.clickLoginbutton();
		homePage.getStartedStack();
		StackPage = new StackPage(driver);

	}

	@Test()
	public void navigateToOperationsInStack() {
		StackPage.operationsinstack();
		Assert.assertTrue(StackPage.textConfirmForOperationsInStack());

	}
	@Test()
	public void navigateToImplementation() {
		StackPage.implementation();
		Assert.assertTrue(StackPage.textConfirmOfImplementation());

	}
	@Test()
	public void navigateToApplications() {
		StackPage.applications();
		Assert.assertTrue(StackPage.textConfirmForApplications());

	}
	@Test()
	public void navigatetoOperationsInStacktryeditor() {

		StackPage.operationsinstack();
		StackPage.tryHere();
		Assert.assertTrue(StackPage.textconfirmfortryeditor());

	}

	@Test()
	public void navigatetoImplementationtryeditor() {

		StackPage.implementation();
		StackPage.tryHere();
		Assert.assertTrue(StackPage.textconfirmfortryeditor());

	}

	@Test()
	public void navigatetoApplicationstryeditor() {

		StackPage.applications();
		StackPage.tryHere();
		Assert.assertTrue(StackPage.textconfirmfortryeditor());

	}
	@Test(dataProvider = "codeExecutionData", dataProviderClass = TestDataProvider.class)
	public void verifyCodeOperationsInStackPage(String code, String expectedResult) {
		StackPage.operationsinstack();
		StackPage.tryHere();
		System.out.println("Executing code: " + code);
		TryEditorPage = new TryEditorPage(driver);
		TryEditorPage.enteringCode(code);
		TryEditorPage.runButton();
		String actualResult = TryEditorPage.output();
		Assert.assertEquals(actualResult, expectedResult, "Output does not match for code: " + code);

	}
	@Test(dataProvider = "codeExecutionData", dataProviderClass = TestDataProvider.class)
	public void verifyCodeImplementationPage(String code, String expectedResult) {
		StackPage.implementation();
		StackPage.tryHere();
		System.out.println("Executing code: " + code);
		TryEditorPage = new TryEditorPage(driver);
		TryEditorPage.enteringCode(code);
		TryEditorPage.runButton();
		String actualResult = TryEditorPage.output();
		Assert.assertEquals(actualResult, expectedResult, "Output does not match for code: " + code);

	}
	@Test(dataProvider = "codeExecutionData", dataProviderClass = TestDataProvider.class)
	public void verifyCodeApplicationsPage(String code, String expectedResult) {

    	StackPage.applications();
		StackPage.tryHere();
		System.out.println("Executing code: " + code);
		TryEditorPage = new TryEditorPage(driver);
		TryEditorPage.enteringCode(code);
		TryEditorPage.runButton();
		String actualResult = TryEditorPage.output();
		Assert.assertEquals(actualResult, expectedResult, "Output does not match for code: " + code);

	}
	@Test
	public void checkErrorMessageWhenExecutingWithoutCodeInOperationsInStackPage() {
		StackPage.operationsinstack();
		StackPage.tryHere();
		StackPage.runButton();
		Assert.fail(
				"Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");

	}
	@Test
	public void checkErrorMessageWhenExecutingWithoutCodeInImplementationPage() {
		StackPage.implementation();
		StackPage.tryHere();
		StackPage.runButton();
		Assert.fail(
				"Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");

	}
	@Test
	public void checkErrorMessageWhenExecutingWithoutCodeInApplicationsInStackPage() {
		StackPage.applications();
		StackPage.tryHere();
		StackPage.runButton();
		Assert.fail(
				"Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");

	}
	@Test
	public void seeListOfPracticeQuestionsonOperationsInStackPage() {
		StackPage.operationsinstack();
		StackPage.clickpracticequestions();
		Assert.fail("No practice questions found on the Practice Questions Page!");

	}
	@Test
	public void seeListOfPracticeQuestionsonImplementationPage() {
		StackPage.implementation();
		StackPage.clickpracticequestions();
		Assert.fail("No practice questions found on the Practice Questions Page!");

	}
	@Test
	public void seeListOfPracticeQuestionsonApplicationsPage() {
		StackPage.applications();
		StackPage.clickpracticequestions();
		Assert.fail("No practice questions found on the Practice Questions Page!");

	}
	@Test
	public void navigateToOperationsInStackPracticeQuestions() {
		StackPage.operationsinstack();
		StackPage.clickpracticequestions();
		Assert.assertTrue(StackPage.textconfirmpracticequestion());
	}
	@Test
	public void navigateToImplementationPracticeQuestions() {
		StackPage.implementation();
		StackPage.clickpracticequestions();
		Assert.assertTrue(StackPage.textconfirmpracticequestion());
	}
	@Test
	public void navigateToApplicationsPracticeQuestions() {
		StackPage.applications();
		StackPage.clickpracticequestions();
		Assert.assertTrue(StackPage.textconfirmpracticequestion());
	}
	

}