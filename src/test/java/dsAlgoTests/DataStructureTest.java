package dsAlgoTests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;

import dsAlgoHooks.Hooks;
import dsAlgoPages.DataStructureIntroductionPage;
import dsAlgoPages.HomePage;
import dsAlgoPages.RegisterPage;
import dsAlgoPages.SigninPage;
import dsAlgoPages.TryEditorPage;
import dsAlgoUtils.TestDataProvider;

public class DataStructureTest extends Hooks {

	WebDriver driver;
	HomePage Hg;
	SigninPage Sg;
	RegisterPage Rg;
	//Properties prop = ConfigReader.initializeProp();
	DataStructureIntroductionPage Dg = new DataStructureIntroductionPage(driver);
	TryEditorPage TryEditorPage;

	@BeforeMethod
	public void DataStructureIntroductionPage() {
		driver = Hooks.getDriver();
		Hg = new HomePage(driver);
		ChainTestListener.log("Clicking Get Started button on Launch Page");
		Hg.clickLaunchPageGetstartedbutton();
		ChainTestListener.log("Navigating to Sign-in Page");
		Hg.clickSignin();
		Sg = new SigninPage(driver);
		ChainTestListener.log("Entering username and password");
		Sg.sendtextusername();
		Sg.sendtextpassword();
		ChainTestListener.log("Clicking Login button");
		Sg.clickLoginbutton();
		ChainTestListener.log("Navigating to Data Structure Introduction Page");
		Hg.getStartedDataStructureIntroduction();
		Dg = new DataStructureIntroductionPage(driver);
	}

	@Test(priority=1)
	public void navigatetoTimeComplexityModule() {
		ChainTestListener.log("Navigating to Time Complexity Module");
	    Dg.ClickTimeComplexityLink();
	    Assert.assertTrue(Dg.isTextDisplayedInTimeComplexityPage());
	    ChainTestListener.log("Successfully navigated to Time Complexity Module");
	}

	@Test(priority=2)
	public void navigatetoTimeComplexitytryeditor() {
		ChainTestListener.log("Navigating to Time Complexity Try Editor");
	    Dg.ClickTimeComplexityLink();
	    Dg.ClickTryHereButton();
	    Assert.assertTrue(Dg.textconfirmfortryeditor());
	    ChainTestListener.log("Successfully opened Time Complexity Try Editor");
	}

	@Test(priority=3)
	public void navigateToDataStructureIntroductionPagePracticeQuestions() {
		ChainTestListener.log("Navigating to Practice Questions on Data Structure Introduction Page");
	    Dg.ClickTimeComplexityLink();
	    Dg.clickpracticequestions();
	    Assert.assertTrue(Dg.textconfirmpracticequestion());
	    ChainTestListener.log("Successfully navigated to Practice Questions");
	}

	@Test(priority=4)
	public void seeListOfPracticeQuestionsonDataStructureIntroductionPage() {
		ChainTestListener.log("Checking list of practice questions on Data Structure Introduction Page");
	    Dg.ClickTimeComplexityLink();
	    Dg.clickpracticequestions();
	    Assert.fail("No practice questions found on the Practice Questions Page!");
	    ChainTestListener.log("Practice questions check failed");
	}

	@Test(priority=5)
	public void checkErrorMessageWhenExecutingWithoutCodeInDataStructureIntroductionPage() {
		ChainTestListener.log("Checking error message when executing without code");
	    Dg.ClickTimeComplexityLink();
	    Dg.click_tryEditor();
	    Dg.click_run();
	    Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	    ChainTestListener.log("Error message validation failed");
	}

	@Test(dataProvider = "codeExecutionData", dataProviderClass = TestDataProvider.class,priority=6)
	public void verifyCodeExecutionforDataStructureIntroductionPage(String code, String expectedResult) {
		ChainTestListener.log("Verifying code execution for Data Structure Introduction Page");
	    Dg.ClickTimeComplexityLink();
	    Dg.click_tryEditor();
	    ChainTestListener.log("Executing code: " + code);
	    TryEditorPage = new TryEditorPage(driver);
	    TryEditorPage.enteringCode(code);
	    TryEditorPage.runButton();
	    String actualResult = TryEditorPage.output();
	    ChainTestListener.log("Execution result: " + actualResult);
	    Assert.assertEquals(actualResult, expectedResult, "Output does not match for code: " + code);
	    ChainTestListener.log("Code execution verified successfully");
	}
}