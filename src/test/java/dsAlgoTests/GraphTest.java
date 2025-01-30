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
	Properties prop = ConfigReader.initializeProp();
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

	@Test(dataProvider = "testdata", dataProviderClass = TestDataProvider.class)
	public void navigateToGraphOption(String expectedurl) {
		System.out.println("Navigating to Graph Option with URL: " + expectedurl);
		GraphPage = new GraphPage(driver);
		GraphPage.clickgraphpagegraphoption();
		String actualurl = driver.getCurrentUrl();
		Assert.assertEquals(actualurl, expectedurl, "URL not matched");
	}

	@Test(dataProvider = "testdata", dataProviderClass = TestDataProvider.class)
	public void navigatetoGraphRepresentation(String expectedurl) {
		GraphPage = new GraphPage(driver);
		GraphPage.Graphrepresentation();
		String actualurl = driver.getCurrentUrl();
		Assert.assertEquals(actualurl, expectedurl, "URL not matched");

	}

	@Test(dataProvider = "testdata", dataProviderClass = TestDataProvider.class)
	public void navigateToGraphModuleTryEditor(String expectedurl) {
		GraphPage = new GraphPage(driver);
		GraphPage.clickgraphpagegraphoption();
		GraphPage.tryherebutton();
		String actualurl = driver.getCurrentUrl();

		Assert.assertEquals(actualurl, expectedurl, "URL not matched");

	}

	@Test(dataProvider = "testdata", dataProviderClass = TestDataProvider.class)
	public void navigateToGraphRepresentationTryEditor(String expectedurl) {
		GraphPage = new GraphPage(driver);
		GraphPage.Graphrepresentation();
		GraphPage.tryherebutton();
		String actualurl = driver.getCurrentUrl();
		Assert.assertEquals(actualurl, expectedurl, "URL not matched");

	}

	@Test(dataProvider = "testdata", dataProviderClass = TestDataProvider.class)
	public void navigateToGraphPracticeQuestions(String expectedurl) {
		GraphPage.clickgraphpagegraphoption();
		GraphPage.clickpracticequestions();
		String actualurl = driver.getCurrentUrl();
		Assert.assertEquals(actualurl, expectedurl, "URL not matched");

	}

	@Test(dataProvider = "testdata", dataProviderClass = TestDataProvider.class)
	public void navigateToGraphRepresentationPracticeQuestions(String expectedurl) {
		GraphPage.Graphrepresentation();
		GraphPage.clickpracticequestions();
		String actualurl = driver.getCurrentUrl();
		Assert.assertEquals(actualurl, expectedurl, "URL not matched");

	}

	@Test
	public void seeListOfPracticeQuestionsonGraphPage() {
		GraphPage.clickgraphpagegraphoption();
		GraphPage.clickpracticequestions();
		Assert.fail("No practice questions found on the Practice Questions Page!");

	}

	@Test
	public void seeListOfPracticeQuestionsonGraphReprePage() {
		GraphPage.Graphrepresentation();
		GraphPage.clickpracticequestions();
		Assert.fail("No practice questions found on the Practice Questions Page!");

	}

	@Test
	public void checkErrorMessageWhenExecutingWithoutCodeInGraphPage() {
		GraphPage.clickgraphpagegraphoption();
		GraphPage.tryherebutton();
		GraphPage.run();
		Assert.fail(
				"Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");

	}

	@Test
	public void checkErrorMessageWhenExecutingWithoutCodeInGraphReprePage() {
		GraphPage.Graphrepresentation();
		GraphPage.tryherebutton();
		GraphPage.run();
		Assert.fail(
				"Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");

	}

	@Test(dataProvider = "tryeditordata", dataProviderClass = TestDataProvider.class)
	public void verifyValidCodeExecutionforGraphPage(String code, String expectedResult) {
		GraphPage.clickgraphpagegraphoption();
		GraphPage.tryherebutton();
		System.out.println("Executing code: " + code);
		TryEditorPage = new TryEditorPage(driver);
		TryEditorPage.enteringCode(code);
		TryEditorPage.runButton();
		String actualResult = TryEditorPage.output();
		Assert.assertEquals(actualResult, expectedResult, "Output does not match for code: " + code);

	}

	@Test(dataProvider = "tryeditordata", dataProviderClass = TestDataProvider.class)
	public void verifyInValidCodeExecutionforGraphPage(String code, String expectedResult) {

		GraphPage.clickgraphpagegraphoption();
		GraphPage.tryherebutton();
		System.out.println("Executing code: " + code);
		TryEditorPage = new TryEditorPage(driver);
		TryEditorPage.enteringCode(code);
		TryEditorPage.runButton();
		String actualResult = TryEditorPage.output();
		Assert.assertEquals(actualResult, expectedResult, "Output does not match for code: " + code);

	}

	@Test(dataProvider = "tryeditordata", dataProviderClass = TestDataProvider.class)
	public void verifyValidCodeExecutionforGraphRepresentationPage(String code, String expectedResult) {
		GraphPage.Graphrepresentation();
		GraphPage.tryherebutton();
		System.out.println("Executing code: " + code);
		TryEditorPage = new TryEditorPage(driver);
		TryEditorPage.enteringCode(code);
		TryEditorPage.runButton();
		String actualResult = TryEditorPage.output();
		Assert.assertEquals(actualResult, expectedResult, "Output does not match for code: " + code);

	}

	@Test(dataProvider = "tryeditordata", dataProviderClass = TestDataProvider.class)
	public void verifyInValidCodeExecutionforGraphRepresentationPage(String code, String expectedResult) {
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
