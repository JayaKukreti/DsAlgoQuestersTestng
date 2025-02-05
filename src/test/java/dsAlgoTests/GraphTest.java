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
		System.out.println("Navigating to Graph Page...");
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
		System.out.println("Successfully navigated to Graph Page.");
	}

	@Test()
	public void navigatetoGraphModule() {
		System.out.println("Navigating to Graph Module...");
		GraphPage.clickgraphpagegraphoption();
		Assert.assertTrue(GraphPage.textconfirmforgraphmodule());
		System.out.println("Graph Module navigation successful.");
	}

	@Test()
	public void navigatetoGraphRepresentation() {
		System.out.println("Navigating to Graph Representation...");
		GraphPage.Graphrepresentation();
		Assert.assertTrue(GraphPage.isGraphRepresentationTextDisplayed());
		System.out.println("Graph Representation navigation successful.");
	}

	@Test(dependsOnMethods = { "navigatetoGraphModule" })
	public void navigatetoGraphModuletryeditor() {
		System.out.println("Navigating to Graph Module Try Editor...");
		GraphPage.clickgraphpagegraphoption();
		GraphPage.tryherebutton();
		Assert.assertTrue(GraphPage.textconfirmfortryeditor());
		System.out.println("Graph Module Try Editor navigation successful.");
	}

	@Test(dependsOnMethods = { "navigatetoGraphRepresentation" })
	public void navigatetoGraphRepresentationtryeditor() {
		System.out.println("Navigating to Graph Representation Try Editor...");
		GraphPage.Graphrepresentation();
		GraphPage.tryherebutton();
		Assert.assertTrue(GraphPage.textconfirmfortryeditor());
		System.out.println("Graph Representation Try Editor navigation successful.");
	}

	@Test()
	public void navigateToGraphPracticeQuestions() {
		System.out.println("Navigating to Graph Practice Questions...");
		GraphPage.clickgraphpagegraphoption();
		GraphPage.clickpracticequestions();
		Assert.assertTrue(GraphPage.textconfirmpracticequestion());
		System.out.println("Graph Practice Questions navigation successful.");
	}

	@Test()
	public void navigateToGraphRepresentationPracticeQuestions() {
		System.out.println("Navigating to Graph Representation Practice Questions...");
		GraphPage.Graphrepresentation();
		GraphPage.clickpracticequestions();
		Assert.assertTrue(GraphPage.textconfirmpracticequestion());
		System.out.println("Graph Representation Practice Questions navigation successful.");
	}

	@Test()
	public void seeListOfPracticeQuestionsonGraphPage() {
		System.out.println("Checking practice questions on Graph Page...");
		GraphPage.clickgraphpagegraphoption();
		GraphPage.clickpracticequestions();
		Assert.fail("No practice questions found on the Practice Questions Page!");
	}

	@Test(dependsOnMethods = { "navigateToGraphRepresentationPracticeQuestions" })
	public void seeListOfPracticeQuestionsonGraphReprePage() {
		System.out.println("Checking practice questions on Graph Representation Page...");
		GraphPage.Graphrepresentation();
		GraphPage.clickpracticequestions();
		Assert.fail("No practice questions found on the Practice Questions Page!");
	}

	@Test()
	public void checkErrorMessageWhenExecutingWithoutCodeInGraphPage() {
		System.out.println("Verifying error message for empty execution in Graph Page...");
		GraphPage.clickgraphpagegraphoption();
		GraphPage.tryherebutton();
		GraphPage.run();
		Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	}

	@Test()
	public void checkErrorMessageWhenExecutingWithoutCodeInGraphReprePage() {
		System.out.println("Verifying error message for empty execution in Graph Representation Page...");
		GraphPage.Graphrepresentation();
		GraphPage.tryherebutton();
		GraphPage.run();
		Assert.fail("Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	}

	@Test(dataProvider = "codeExecutionData", dataProviderClass = TestDataProvider.class)
	public void verifyCodeExecutionforGraphPage(String code, String expectedResult) {
		System.out.println("Executing code for Graph Page: " + code);
		GraphPage.clickgraphpagegraphoption();
		GraphPage.tryherebutton();
		TryEditorPage = new TryEditorPage(driver);
		TryEditorPage.enteringCode(code);
		TryEditorPage.runButton();
		String actualResult = TryEditorPage.output();
		Assert.assertEquals(actualResult, expectedResult, "Output does not match for code: " + code);
	}

	@Test(dataProvider = "codeExecutionData", dataProviderClass = TestDataProvider.class)
	public void verifyCodeExecutionforGraphRepresentationPage(String code, String expectedResult) {
		System.out.println("Executing code for Graph Representation Page: " + code);
		GraphPage.Graphrepresentation();
		GraphPage.tryherebutton();
		TryEditorPage = new TryEditorPage(driver);
		TryEditorPage.enteringCode(code);
		TryEditorPage.runButton();
		String actualResult = TryEditorPage.output();
		Assert.assertEquals(actualResult, expectedResult, "Output does not match for code: " + code);
	}
}
