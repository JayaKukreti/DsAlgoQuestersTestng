package dsAlgoTests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dsAlgoHooks.Hooks;
import dsAlgoPages.DataStructureIntroductionPage;
import dsAlgoPages.GraphPage;
import dsAlgoPages.HomePage;
import dsAlgoPages.RegisterPage;
import dsAlgoPages.SigninPage;
import dsAlgoPages.TryEditorPage;
import dsAlgoUtils.ConfigReader;
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
		Hg.clickLaunchPageGetstartedbutton();
		Hg.clickSignin();
		Sg = new SigninPage(driver);
		Sg.sendtextusername();
		Sg.sendtextpassword();
		Sg.clickLoginbutton();
		Hg.getStartedDataStructureIntroduction();
		Dg = new DataStructureIntroductionPage(driver);
	}

	@Test()
	public void navigatetoTimeComplexityModule() {
	    System.out.println("Navigating to Time Complexity Module");
	    Dg.ClickTimeComplexityLink();
	    Assert.assertTrue(Dg.isTextDisplayedInTimeComplexityPage());
	    System.out.println("Successfully navigated to Time Complexity Module");
	}

	@Test()
	public void navigatetoTimeComplexitytryeditor() {
	    System.out.println("Navigating to Time Complexity Try Editor");
	    Dg.ClickTimeComplexityLink();
	    Dg.ClickTryHereButton();
	    Assert.assertTrue(Dg.textconfirmfortryeditor());
	    System.out.println("Successfully opened Time Complexity Try Editor");
	}

	@Test
	public void navigateToDataStructureIntroductionPagePracticeQuestions() {
	    System.out.println("Navigating to Data Structure Introduction Page Practice Questions");
	    Dg.ClickTimeComplexityLink();
	    Dg.clickpracticequestions();
	    Assert.assertTrue(Dg.textconfirmpracticequestion());
	    System.out.println("Successfully navigated to Practice Questions");
	}

	@Test
	public void seeListOfPracticeQuestionsonDataStructureIntroductionPage() {
	    System.out.println("Checking list of practice questions on Data Structure Introduction Page");
	    Dg.ClickTimeComplexityLink();
	    Dg.clickpracticequestions();
	    Assert.fail("No practice questions found on the Practice Questions Page!");
	    System.out.println("Practice questions check failed");
	}

	@Test
	public void checkErrorMessageWhenExecutingWithoutCodeInDataStructureIntroductionPage() {
	    System.out.println("Checking error message when executing without code");
	    Dg.ClickTimeComplexityLink();
	    Dg.click_tryEditor();
	    Dg.click_run();
	    Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	    System.out.println("Error message validation failed");
	}

	@Test(dataProvider = "codeExecutionData", dataProviderClass = TestDataProvider.class)
	public void verifyCodeExecutionforDataStructureIntroductionPage(String code, String expectedResult) {
	    System.out.println("Verifying code execution for Data Structure Introduction Page");
	    Dg.ClickTimeComplexityLink();
	    Dg.click_tryEditor();
	    System.out.println("Executing code: " + code);
	    TryEditorPage = new TryEditorPage(driver);
	    TryEditorPage.enteringCode(code);
	    TryEditorPage.runButton();
	    String actualResult = TryEditorPage.output();
	    System.out.println("Execution result: " + actualResult);
	    Assert.assertEquals(actualResult, expectedResult, "Output does not match for code: " + code);
	    System.out.println("Code execution verified successfully");
	}
}