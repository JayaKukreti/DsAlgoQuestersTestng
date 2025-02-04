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
	Properties prop = ConfigReader.initializeProp();
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
        Dg.ClickTimeComplexityLink();
        Assert.assertTrue(Dg.isTextDisplayedInTimeComplexityPage());
	}

	@Test()
	public void navigatetoTimeComplexitytryeditor() {
       Dg.ClickTimeComplexityLink();
		Dg.ClickTryHereButton();
		String actualurl = driver.getCurrentUrl();
		String expectedurl = prop.getProperty("tryeditorurl");
		Assert.assertEquals(actualurl, expectedurl, "URL not matched");

	}

	@Test
	public void navigateToDataStructureIntroductionPagePracticeQuestions() {
		Dg.ClickTimeComplexityLink();
		Dg.clickpracticequestions();
		String actualurl = driver.getCurrentUrl();
		String expectedurl = prop.getProperty("practicequestionspageurl");
		Assert.assertEquals(actualurl, expectedurl, "URL not matched");

	}

	@Test
	public void seeListOfPracticeQuestionsonDataStructureIntroductionPage() {
		Dg.ClickTimeComplexityLink();
		Dg.clickpracticequestions();
		Assert.fail("No practice questions found on the Practice Questions Page!");

	}

	@Test
	public void checkErrorMessageWhenExecutingWithoutCodeInDataStructureIntroductionPage() {
		Dg.ClickTimeComplexityLink();
		Dg.click_tryEditor();
		Dg.click_run();
		Assert.fail(
				"Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");

	}

	@Test(dataProvider = "codeExecutionData", dataProviderClass = TestDataProvider.class)
	public void verifyCodeExecutionforDataStructureIntroductionPage(String code, String expectedResult) {
		Dg.ClickTimeComplexityLink();
		Dg.click_tryEditor();
		System.out.println("Executing code: " + code);
		TryEditorPage = new TryEditorPage(driver);
		TryEditorPage.enteringCode(code);
		TryEditorPage.runButton();
		String actualResult = TryEditorPage.output();
		Assert.assertEquals(actualResult, expectedResult, "Output does not match for code: " + code);

	}

}
