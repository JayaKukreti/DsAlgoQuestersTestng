package dsAlgoTests;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import dsAlgoHooks.Hooks;
import dsAlgoPages.ArrayPage;
import dsAlgoPages.HomePage;
import dsAlgoPages.RegisterPage;
import dsAlgoPages.SigninPage;
import dsAlgoPages.TryEditorForArraysPracticeQuestions;
import dsAlgoPages.TryEditorPage;
import dsAlgoUtils.ConfigReader;
import dsAlgoUtils.TestDataProvider;

public class ArrayTest extends Hooks{
	private  Logger logger = LogManager.getLogger(ArrayTest.class);
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
        logger.info("Initializing WebDriver and navigating to Array Page");
        driver = Hooks.getDriver();
        homePage = new HomePage(driver);
        logger.info("Clicking launch page Get Started button");
        homePage.clickLaunchPageGetstartedbutton();
        logger.info("Clicking Sign In");
        homePage.clickSignin();
        signinPage = new SigninPage(driver);
        logger.info("Entering username and password");
        signinPage.sendtextusername();
        signinPage.sendtextpassword();
        logger.info("Clicking Login button");
        signinPage.clickLoginbutton();
        logger.info("Navigating to Array page");
        homePage.getStartedArray();
        arrayPage = new ArrayPage(driver);
		//Validation is missing	
	}
	 @Test
	    public void navigateToArrayInPython() {
	        logger.info("Navigating to Array in Python");
	        arrayPage.clickArrayInPython();
	        Assert.assertTrue(arrayPage.arraysInPythonIsDisplayed(), "Array in Python page is not displayed");
	    }
	
	 @Test
	    public void navigateToArrayUsingList() {
	        logger.info("Navigating to Arrays Using List");
	        arrayPage.clickArraysUsingList();
	        Assert.assertTrue(arrayPage.arraysUsingListIsDisplayed(), "Arrays Using List page is not displayed");
	    }
	
	 @Test
	    public void navigateToBasicOperationInList() {
	        logger.info("Navigating to Basic Operations in List");
	        arrayPage.clickBasicOperationsInLists();
	        Assert.assertTrue(arrayPage.basicOperationsInListsIsDisplayed(), "Basic Operations in List page is not displayed");
	    }
	 @Test
	    public void navigateToApplicationOfArray() {
	        logger.info("Navigating to Applications of Array");
	        arrayPage= new ArrayPage(driver);
	        arrayPage.clickApplicationsOfArray();
	        Assert.assertTrue(arrayPage.applicationsOfArrayIsDisplayed(), "Applications of Array page is not displayed");
	    }
	 @Test
	    public void navigateToArrayInPythonTryEditor() {
	        logger.info("Navigating to Array in Python Try Editor");
	        arrayPage= new ArrayPage(driver);
	        arrayPage.clickArrayInPython();
	        arrayPage.tryHere();
	        Assert.assertTrue(arrayPage.runButtonIsDisplayed(), "Run button is not displayed");
	    }
	 @Test
	    public void navigateToArrayUsingListTryEditor() {
	        logger.info("Navigating to Arrays Using List Try Editor");
	        arrayPage= new ArrayPage(driver);
	        arrayPage.clickArraysUsingList();
	        arrayPage.tryHere();
	        Assert.assertTrue(arrayPage.runButtonIsDisplayed(), "Run button is not displayed");
	    }
	
	 @Test
	    public void navigateToBasicOperationInListTryEditor() {
	        logger.info("Navigating to Basic Operations in List Try Editor");
	        arrayPage= new ArrayPage(driver);
	        arrayPage.clickBasicOperationsInLists();
	        arrayPage.tryHere();
	        Assert.assertTrue(arrayPage.runButtonIsDisplayed(), "Run button is not displayed");
	    }

	    @Test
	    public void navigateToApplicationOfArrayTryEditor() {
	        logger.info("Navigating to Applications of Array Try Editor");
	        arrayPage= new ArrayPage(driver);
	        arrayPage.clickApplicationsOfArray();
	        arrayPage.tryHere();
	        Assert.assertTrue(arrayPage.runButtonIsDisplayed(), "Run button is not displayed");
	    }
	

	    @Test
	    public void checkErrorMessageWhenExecutingWithoutCodeInArrayInPythonForTryEditor() {
	        logger.info("Checking error message when executing without code in Array in Python Try Editor");
	        arrayPage= new ArrayPage(driver);
	        arrayPage.clickArrayInPython();
	        arrayPage.tryHere();
	        arrayPage.run();
	        Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	    }

	    @Test
	    public void checkErrorMessageWhenExecutingWithoutCodeArrayUsingListForTryEditor() {
	        logger.info("Checking error message when executing without code in Arrays Using List Try Editor");
	        arrayPage= new ArrayPage(driver);
	        arrayPage.clickArraysUsingList();
	        arrayPage.tryHere();
	        arrayPage.run();
	        Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	    }

	    @Test
	    public void checkErrorMessageWhenExecutingWithoutCodeBasicOperationInListsForTryEditor() {
	        logger.info("Checking error message when executing without code in Basic Operations in Lists Try Editor");
	        arrayPage= new ArrayPage(driver);
	        arrayPage.clickBasicOperationsInLists();
	        arrayPage.tryHere();
	        arrayPage.run();
	        Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	    }

	    @Test
	    public void checkErrorMessageWhenExecutingWithoutCodeApplicationofArrayForTryEditor() {
	        logger.info("Checking error message when executing without code in Applications of Array Try Editor");
	        arrayPage= new ArrayPage(driver);
	        arrayPage.clickApplicationsOfArray();
	        arrayPage.tryHere();
	        arrayPage.run();
	        Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	    }

	    @Test(dataProvider = "TryEditorDataArray", dataProviderClass = TestDataProvider.class)
	    public void verifyCodeExecutionForArraySections(String Options, String Code, String ExpectedResult) {
	        logger.info("Verifying code execution for Array sections: " + Options);
	        arrayPage = new ArrayPage(driver);
	        tryEditorPage = new TryEditorPage(driver);
	        arrayPage.Option(Options);
	        arrayPage.tryHere();
	        tryEditorPage.enteringCode(Code);
	        tryEditorPage.runButton();
	        String actualResult = tryEditorPage.output();
	        Assert.assertEquals(actualResult, ExpectedResult, "Output mismatch for section: " + Options);
	    }

	    @Test(dataProvider = "PracticeQuestionForArrayRun", dataProviderClass = TestDataProvider.class)
	    public void PracticeQuestionVaildAndInvalidDataWithRunButton(String Options, String Questions, String pcode, String expectedResult) {
	        logger.info("Executing practice question for Array with Run button: " + Options);
	        arrayPage = new ArrayPage(driver);
	        tap = new TryEditorForArraysPracticeQuestions(driver);
	        arrayPage.PracticeQuestion(Options, Questions);
	        tap.enteringCodeForArray(pcode);
	        tap.clickRunButton();
	        String actualResult = tap.getOutput();
	        Assert.assertEquals(actualResult, expectedResult, "Output mismatch for section: " + Options);
	    }

	    @Test(dataProvider = "PracticeQuestionForArraySubmit", dataProviderClass = TestDataProvider.class)
	    public void PracticeQuestionVaildAndInvalidDataWithSubmitButton(String Options, String Question, String pcode, String expectedResult) {
	        logger.info("Executing practice question for Array with Submit button: " + Options);
	        tap = new TryEditorForArraysPracticeQuestions(driver);
	        arrayPage.PracticeQuestion(Options, Question);
	        tap.enteringCodeForArray(pcode);
	        arrayPage.submit();
	        String actualResult = tap.getOutput();
	        Assert.assertEquals(actualResult, expectedResult, "Output mismatch for section: " + Options);
	    }
}