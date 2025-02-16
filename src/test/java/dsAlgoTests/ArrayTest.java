package dsAlgoTests;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.chaintest.plugins.ChainTestListener;
import dsAlgoHooks.Hooks;
import dsAlgoPages.ArrayPage;
import dsAlgoPages.HomePage;
import dsAlgoPages.RegisterPage;
import dsAlgoPages.SigninPage;
import dsAlgoPages.TryEditorForArraysPracticeQuestions;
import dsAlgoPages.TryEditorPage;
import dsAlgoUtils.ConfigReader;
import dsAlgoUtils.TestDataProvider;

public class ArrayTest extends Hooks {
	WebDriver driver;
	HomePage homePage;
	SigninPage signinPage;
	RegisterPage registerPage;
	Properties prop = ConfigReader.initializeprop();
	ArrayPage arrayPage;
	TryEditorPage tryEditorPage;
	TryEditorForArraysPracticeQuestions tap;

	@BeforeMethod
	public void navigateToArrayPage() {
		driver = Hooks.getDriver();
		homePage = new HomePage(driver);
		ChainTestListener.log("Clicking Get Started button on Launch Page");
		homePage.clickLaunchPageGetstartedbutton();
		ChainTestListener.log("Clicking Sign In");
		homePage.clickSignin();
		signinPage = new SigninPage(driver);
		ChainTestListener.log("Entering username and password");
		signinPage.sendtextusername();
		signinPage.sendtextpassword();
		ChainTestListener.log("Clicking Login button");
		signinPage.clickLoginbutton();
		ChainTestListener.log("Navigating to Array page");
		homePage.getStartedArray();
		arrayPage = new ArrayPage(driver);
		// Validation is missing
	}

	@Test(priority = 1)
	public void navigateToArrayInPython() {
		ChainTestListener.log("Navigating to Array in Python");
		arrayPage.clickArrayInPython();
		Assert.assertTrue(arrayPage.arraysInPythonIsDisplayed(), "Array in Python page is not displayed");
	}

	@Test(priority = 2)
	public void navigateToArrayUsingList() {
		ChainTestListener.log("Navigating to Arrays Using List");
		arrayPage.clickArraysUsingList();
		Assert.assertTrue(arrayPage.arraysUsingListIsDisplayed(), "Arrays Using List page is not displayed");
	}

	@Test(priority = 3)
	public void navigateToBasicOperationInList() {
		ChainTestListener.log("Navigating to Basic Operations in List");
		arrayPage.clickBasicOperationsInLists();
		Assert.assertTrue(arrayPage.basicOperationsInListsIsDisplayed(),
				"Basic Operations in List page is not displayed");
	}

	@Test(priority = 4)
	public void navigateToApplicationOfArray() {
		ChainTestListener.log("Navigating to Applications of Array");
		arrayPage = new ArrayPage(driver);
		arrayPage.clickApplicationsOfArray();
		Assert.assertTrue(arrayPage.applicationsOfArrayIsDisplayed(), "Applications of Array page is not displayed");
	}

	@Test(priority = 5)
	public void navigateToArrayInPythonTryEditor() {
		ChainTestListener.log("Navigating to Array in Python Try Editor");
		arrayPage = new ArrayPage(driver);
		arrayPage.clickArrayInPython();
		arrayPage.tryHere();
		Assert.assertTrue(arrayPage.runButtonIsDisplayed(), "Run button is not displayed");
	}

	@Test(priority = 6)
	public void navigateToArrayUsingListTryEditor() {
		ChainTestListener.log("Navigating to Arrays Using List Try Editor");
		arrayPage = new ArrayPage(driver);
		arrayPage.clickArraysUsingList();
		arrayPage.tryHere();
		Assert.assertTrue(arrayPage.runButtonIsDisplayed(), "Run button is not displayed");
	}

	@Test(priority = 7)
	public void navigateToBasicOperationInListTryEditor() {
		ChainTestListener.log("Navigating to Basic Operations in List Try Editor");
		arrayPage = new ArrayPage(driver);
		arrayPage.clickBasicOperationsInLists();
		arrayPage.tryHere();
		Assert.assertTrue(arrayPage.runButtonIsDisplayed(), "Run button is not displayed");
	}

	@Test(priority = 8)
	public void navigateToApplicationOfArrayTryEditor() {
		ChainTestListener.log("Navigating to Applications of Array Try Editor");
		arrayPage = new ArrayPage(driver);
		arrayPage.clickApplicationsOfArray();
		arrayPage.tryHere();
		Assert.assertTrue(arrayPage.runButtonIsDisplayed(), "Run button is not displayed");
	}

	@Test(priority = 9)
	public void checkErrorMessageWhenExecutingWithoutCodeInArrayInPythonForTryEditor() {
		ChainTestListener.log("Checking error message when executing without code in Array in Python Try Editor");
		arrayPage = new ArrayPage(driver);
		arrayPage.clickArrayInPython();
		arrayPage.tryHere();
		arrayPage.run();
		Assert.fail(
				"Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	}

	@Test(priority = 10)
	public void checkErrorMessageWhenExecutingWithoutCodeArrayUsingListForTryEditor() {
		ChainTestListener.log("Checking error message when executing without code in Arrays Using List Try Editor");
		arrayPage = new ArrayPage(driver);
		arrayPage.clickArraysUsingList();
		arrayPage.tryHere();
		arrayPage.run();
		Assert.fail(
				"Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	}

	@Test(priority = 11)
	public void checkErrorMessageWhenExecutingWithoutCodeBasicOperationInListsForTryEditor() {
		ChainTestListener
				.log("Checking error message when executing without code in Basic Operations in Lists Try Editor");
		arrayPage = new ArrayPage(driver);
		arrayPage.clickBasicOperationsInLists();
		arrayPage.tryHere();
		arrayPage.run();
		Assert.fail(
				"Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	}

	@Test(priority = 12)
	public void checkErrorMessageWhenExecutingWithoutCodeApplicationofArrayForTryEditor() {
		ChainTestListener.log("Checking error message when executing without code in Applications of Array Try Editor");
		arrayPage = new ArrayPage(driver);
		arrayPage.clickApplicationsOfArray();
		arrayPage.tryHere();
		arrayPage.run();
		Assert.fail(
				"Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	}

	@Test(dataProvider = "TryEditorDataArray", dataProviderClass = TestDataProvider.class, priority = 13)
	public void verifyCodeExecutionForArraySections(String Options, String Code, String ExpectedResult) {
		ChainTestListener.log("Verifying code execution for Array sections: " + Options);
		arrayPage = new ArrayPage(driver);
		tryEditorPage = new TryEditorPage(driver);
		arrayPage.Option(Options);
		arrayPage.tryHere();
		tryEditorPage.enteringCode(Code);
		tryEditorPage.runButton();
		String actualResult = tryEditorPage.output();
		Assert.assertEquals(actualResult, ExpectedResult, "Output mismatch for section: " + Options);
	}

	@Test(dataProvider = "PracticeQuestionForArrayRun", dataProviderClass = TestDataProvider.class, priority = 14)
	public void PracticeQuestionVaildAndInvalidDataWithRunButton(String Options, String Questions, String pcode,
			String expectedResult) {
		ChainTestListener.log("Executing practice question for Array with Run button: " + Options);
		arrayPage = new ArrayPage(driver);
		tap = new TryEditorForArraysPracticeQuestions(driver);
		arrayPage.PracticeQuestion(Options, Questions);
		tap.enteringCodeForArray(pcode);
		tap.clickRunButton();
		String actualResult = tap.getOutput();
		Assert.assertEquals(actualResult, expectedResult, "Output mismatch for section: " + Options);
	}

	@Test(dataProvider = "PracticeQuestionForArraySubmit", dataProviderClass = TestDataProvider.class, priority = 15)
	public void PracticeQuestionVaildAndInvalidDataWithSubmitButton(String Options, String Question, String pcode,
			String expectedResult) {
		ChainTestListener.log("Executing practice question for Array with Submit button: " + Options);
		tap = new TryEditorForArraysPracticeQuestions(driver);
		arrayPage.PracticeQuestion(Options, Question);
		tap.enteringCodeForArray(pcode);
		arrayPage.submit();
		String actualResult = tap.getOutput();
		Assert.assertEquals(actualResult, expectedResult, "Output mismatch for section: " + Options);
	}
}
