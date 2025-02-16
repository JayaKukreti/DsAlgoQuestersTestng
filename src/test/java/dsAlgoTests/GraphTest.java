package dsAlgoTests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.chaintest.plugins.ChainTestListener;

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
		ChainTestListener.log("Navigating to Graph Page");
		homePage.getStartedofGraph();
		GraphPage = new GraphPage(driver);
		
	}

	@Test(priority=1)
	public void navigatetoGraphModule() {
		ChainTestListener.log("Navigating to Graph Module...");
		GraphPage.clickgraphpagegraphoption();
		Assert.assertTrue(GraphPage.textconfirmforgraphmodule());
		ChainTestListener.log("Graph Module navigation successful.");
	}

	@Test(priority=2)
	public void navigatetoGraphRepresentation() {
		ChainTestListener.log("Navigating to Graph Representation...");
		GraphPage.Graphrepresentation();
		Assert.assertTrue(GraphPage.isGraphRepresentationTextDisplayed());
		ChainTestListener.log("Graph Representation navigation successful.");
	}

	@Test(dependsOnMethods = { "navigatetoGraphModule" },priority=3)
	public void navigatetoGraphModuletryeditor() {
		ChainTestListener.log("Navigating to Graph Module Try Editor...");
		GraphPage.clickgraphpagegraphoption();
		GraphPage.tryherebutton();
		Assert.assertTrue(GraphPage.textconfirmfortryeditor());
		ChainTestListener.log("Graph Module Try Editor navigation successful.");
	}

	@Test(dependsOnMethods = { "navigatetoGraphRepresentation" },priority=4)
	public void navigatetoGraphRepresentationtryeditor() {
		ChainTestListener.log("Navigating to Graph Representation Try Editor...");
		GraphPage.Graphrepresentation();
		GraphPage.tryherebutton();
		Assert.assertTrue(GraphPage.textconfirmfortryeditor());
		ChainTestListener.log("Graph Representation Try Editor navigation successful.");
	}

	@Test(priority=5)
	public void navigateToGraphPracticeQuestions() {
		ChainTestListener.log("Navigating to Graph Practice Questions...");
		GraphPage.clickgraphpagegraphoption();
		GraphPage.clickpracticequestions();
		Assert.assertTrue(GraphPage.textconfirmpracticequestion());
		ChainTestListener.log("Graph Practice Questions navigation successful.");
	}

	@Test(priority=6)
	public void navigateToGraphRepresentationPracticeQuestions() {
		ChainTestListener.log("Navigating to Graph Representation Practice Questions...");
		GraphPage.Graphrepresentation();
		GraphPage.clickpracticequestions();
		Assert.assertTrue(GraphPage.textconfirmpracticequestion());
		ChainTestListener.log("Graph Representation Practice Questions navigation successful.");
	}

	@Test(priority=7)
	public void seeListOfPracticeQuestionsonGraphPage() {
		ChainTestListener.log("Checking practice questions on Graph Page...");
		GraphPage.clickgraphpagegraphoption();
		GraphPage.clickpracticequestions();
		Assert.fail("No practice questions found on the Practice Questions Page!");
	}

	@Test(dependsOnMethods = { "navigateToGraphRepresentationPracticeQuestions" },priority=8)
	public void seeListOfPracticeQuestionsonGraphReprePage() {
		ChainTestListener.log("Checking practice questions on Graph Representation Page...");
		GraphPage.Graphrepresentation();
		GraphPage.clickpracticequestions();
		Assert.fail("No practice questions found on the Practice Questions Page!");
	}

	@Test(priority=9)
	public void checkErrorMessageWhenExecutingWithoutCodeInGraphPage() {
		ChainTestListener.log("Verifying error message for empty execution in Graph Page...");
		GraphPage.clickgraphpagegraphoption();
		GraphPage.tryherebutton();
		GraphPage.run();
		Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	}

	@Test(priority=10)
	public void checkErrorMessageWhenExecutingWithoutCodeInGraphReprePage() {
		ChainTestListener.log("Verifying error message for empty execution in Graph Representation Page...");
		GraphPage.Graphrepresentation();
		GraphPage.tryherebutton();
		GraphPage.run();
		Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	}

	@Test(dataProvider = "codeExecutionData", dataProviderClass = TestDataProvider.class,priority=11)
	public void verifyCodeExecutionforGraphPage(String code, String expectedResult) {
		ChainTestListener.log("Executing code for Graph Page: " + code);
		GraphPage.clickgraphpagegraphoption();
		GraphPage.tryherebutton();
		TryEditorPage = new TryEditorPage(driver);
		TryEditorPage.enteringCode(code);
		TryEditorPage.runButton();
		String actualResult = TryEditorPage.output();
		Assert.assertEquals(actualResult, expectedResult, "Output does not match for code: " + code);
	}

	@Test(dataProvider = "codeExecutionData", dataProviderClass = TestDataProvider.class,priority=12)
	public void verifyCodeExecutionforGraphRepresentationPage(String code, String expectedResult) {
		ChainTestListener.log("Executing code for Graph Representation Page: " + code);
		GraphPage.Graphrepresentation();
		GraphPage.tryherebutton();
		TryEditorPage = new TryEditorPage(driver);
		TryEditorPage.enteringCode(code);
		TryEditorPage.runButton();
		String actualResult = TryEditorPage.output();
		Assert.assertEquals(actualResult, expectedResult, "Output does not match for code: " + code);
	}
}
