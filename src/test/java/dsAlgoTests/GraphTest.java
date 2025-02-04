package dsAlgoTests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import dsAlgoHooks.Hooks;
import dsAlgoPages.GraphPage;
import dsAlgoPages.HomePage;
import dsAlgoPages.RegisterPage;
import dsAlgoPages.SigninPage;
import dsAlgoPages.TryEditorPage;
import dsAlgoUtils.ConfigReader;
import dsAlgoUtils.TestDataProvider;

public class GraphTest extends Hooks {

	WebDriver driver;
	HomePage homePage;
	SigninPage SigninPage;
	RegisterPage RegisterPage;
	Properties prop = ConfigReader.initializeprop();
	GraphPage GraphPage;
	TryEditorPage TryEditorPage;

	@BeforeMethod
	public void navigateGraphPage() {
		driver = Hooks.getDriver();
		homePage = new HomePage(driver);
		homePage.clickLaunchPageGetstartedbutton();
		homePage.clickSignin();
		SigninPage = new SigninPage(driver);
		SigninPage.sendtextusername();
		SigninPage.sendtextpassword();
		SigninPage.clickLoginbutton();
		homePage.getStartedofGraph();
		GraphPage = new GraphPage(driver);
	}

	@Test()
	public void navigatetoGraphModule() {
		GraphPage.clickgraphpagegraphoption();
		Assert.assertTrue(GraphPage.textconfirmforgraphmodule());
	}

	@Test()
	public void navigatetoGraphRepresentation() {
		GraphPage.Graphrepresentation();
		Assert.assertTrue(GraphPage.isGraphRepresentationTextDisplayed());
	}

	@Test(dependsOnMethods = { "navigatetoGraphModule" })
	public void navigatetoGraphModuletryeditor() {
		GraphPage.clickgraphpagegraphoption();
		GraphPage.tryherebutton();
		Assert.assertTrue(GraphPage.textconfirmfortryeditor());
	}

	@Test(dependsOnMethods = { "navigatetoGraphRepresentation" })
	public void navigatetoGraphRepresentationtryeditor() {
		GraphPage.Graphrepresentation();
		GraphPage.tryherebutton();
		Assert.assertTrue(GraphPage.textconfirmfortryeditor());
	}

	@Test()
	public void navigateToGraphPracticeQuestions() {
		GraphPage.clickgraphpagegraphoption();
		GraphPage.clickpracticequestions();
		Assert.assertTrue(GraphPage.textconfirmpracticequestion());
	}

	@Test()
	public void navigateToGraphRepresentationPracticeQuestions() {
		GraphPage.Graphrepresentation();
		GraphPage.clickpracticequestions();
		Assert.assertTrue(GraphPage.textconfirmpracticequestion());
	}

	@Test()
	public void seeListOfPracticeQuestionsonGraphPage() {
		GraphPage.clickgraphpagegraphoption();
		GraphPage.clickpracticequestions();
		Assert.fail("No practice questions found on the Practice Questions Page!");
	}

	@Test(dependsOnMethods = { "navigateToGraphRepresentationPracticeQuestions" })
	public void seeListOfPracticeQuestionsonGraphReprePage() {
		GraphPage.Graphrepresentation();
		GraphPage.clickpracticequestions();
		Assert.fail("No practice questions found on the Practice Questions Page!");
	}

	@Test()
	public void checkErrorMessageWhenExecutingWithoutCodeInGraphPage() {
		GraphPage.clickgraphpagegraphoption();
		GraphPage.tryherebutton();
		GraphPage.run();
		Assert.fail(
				"Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	}

	@Test()
	public void checkErrorMessageWhenExecutingWithoutCodeInGraphReprePage() {
		GraphPage.Graphrepresentation();
		GraphPage.tryherebutton();
		GraphPage.run();
		Assert.fail(
				"Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	}

	@Test(dataProvider = "codeExecutionData", dataProviderClass = TestDataProvider.class)
	public void verifyCodeExecutionforGraphPage(String code, String expectedResult) {
		GraphPage.clickgraphpagegraphoption();
		GraphPage.tryherebutton();
		System.out.println("Executing code: " + code);
		TryEditorPage = new TryEditorPage(driver);
		TryEditorPage.enteringCode(code);
		TryEditorPage.runButton();
		String actualResult = TryEditorPage.output();
		Assert.assertEquals(actualResult, expectedResult, "Output does not match for code: " + code);
	}

	@Test(dataProvider = "codeExecutionData", dataProviderClass = TestDataProvider.class)
	public void verifyCodeExecutionforGraphRepresentationPage(String code, String expectedResult) {
		GraphPage.Graphrepresentation();
		GraphPage.tryherebutton();
		System.out.println("Executing code: " + code);
		TryEditorPage = new TryEditorPage(driver);
		TryEditorPage.enteringCode(code);
		TryEditorPage.runButton();
		String actualResult = TryEditorPage.output();
		Assert.assertEquals(actualResult, expectedResult, "Output does not match for code: " + code);
	}
}
