package dsAlgoTests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.chaintest.plugins.ChainTestListener;

import dsAlgoBase.Base;
import dsAlgoPages.HomePage;
import dsAlgoPages.QueuePage;
import dsAlgoPages.SigninPage;
import dsAlgoPages.TryEditorPage;
import dsAlgoUtils.ConfigReader;
import dsAlgoUtils.TestDataProvider;

public class QueueTest extends Base {

	WebDriver driver;

	HomePage homepage;

	SigninPage signinpage;

	// RegisterPage registerpage;

	TryEditorPage tryeditorpage;

	Properties prop = ConfigReader.initializeprop();

	QueuePage queuepage;

	@BeforeMethod

	public void navigatetoQueuepage() {

		driver = Base.getDriver();// to call driver

		homepage = new HomePage(driver);// calling the page with driver

		homepage.clickLaunchPageGetstartedbutton();

		homepage.clickSignin();

		signinpage = new SigninPage(driver);

		signinpage.sendtextusername();

		signinpage.sendtextpassword();

		signinpage.clickLoginbutton();

		homepage.getStartedQueue();

		queuepage = new QueuePage(driver);

	}

	@Test(priority = 1)

	public void navigatetoImplementationOfQueueInPython() {

		ChainTestListener.log("Navigating to Implementation of Queue in Python...");

		queuepage.implementationOfQueueInPythonBtn();

		Assert.assertTrue(queuepage.textconfirmImplementationofQueue());

		ChainTestListener.log("Successfully navigated to Implementation of Queue in Python.");

	}

	@Test(priority = 2)

	public void navigatetoImplementationOfQueueInPythonTryEditor() {

		ChainTestListener.log("Navigating to Implementation of Queue in Python Try Editor...");

		queuepage.implementationOfQueueInPythonBtn();

		queuepage.TryHereBtn();

		Assert.assertTrue(queuepage.textconfirmTextEditor());

		ChainTestListener.log("Successfully navigated to Implementation of Queue in Python Try Editor.");

	}

	@Test(priority = 3)

	public void navigatetoImplementationUsingCollectionsDeque() {

		ChainTestListener.log("Navigating to Implementation Using Collections Deque...");

		queuepage.implementationUsingCollectionsDequeBtn();

		Assert.assertTrue(queuepage.textconfirmImplementationUsingCollectionsDeque());

		ChainTestListener.log("Successfully navigated to Implementation Using Collections Deque.");

	}

	@Test(priority = 4)

	public void navigatetoImplementationUsingCollectionsDequeTryEditor() {

		ChainTestListener.log("Navigating to Implementation Using Collections Deque Try Editor...");

		queuepage.implementationUsingCollectionsDequeBtn();

		queuepage.TryHereBtn();

		Assert.assertTrue(queuepage.textconfirmTextEditor());

		ChainTestListener.log("Successfully navigated to Implementation Using Collections Deque Try Editor.");

	}

	@Test(priority = 5)

	public void navigateToImplementationUsingArray() {

		ChainTestListener.log("Navigating to Implementation Using Array...");

		queuepage.ImplementationUsingArrayBtn();

		Assert.assertTrue(queuepage.textconfirmImplementationUsingArray());

		ChainTestListener.log("Successfully navigated to Implementation Using Array.");

	}

	@Test(priority = 6)

	public void navigateToImplementationUsingArrayTryEditor() {

		ChainTestListener.log("Navigating to Implementation Using Array Try Editor...");

		queuepage.ImplementationUsingArrayBtn();

		queuepage.TryHereBtn();

		Assert.assertTrue(queuepage.textconfirmTextEditor());

		ChainTestListener.log("Successfully navigated to Implementation Using Array Try Editor.");

	}

	@Test(priority = 7)

	public void navigateToQueueOperations() {

		ChainTestListener.log("Navigating to Queue Operations...");

		queuepage.QueueOperationsBtn();

		Assert.assertTrue(queuepage.textconfirmQueueOperations());

		ChainTestListener.log("Successfully navigated to Queue Operations.");

	}

	@Test(priority = 8)

	public void navigateToQueueOperationsTryEditor() {

		ChainTestListener.log("Navigating to Queue Operations Try Editor...");

		queuepage.QueueOperationsBtn();

		queuepage.TryHereBtn();

		Assert.assertTrue(queuepage.textconfirmTextEditor());

		ChainTestListener.log("Successfully navigated to Queue Operations Try Editor.");

	}

	@Test(priority = 9)

	public void navigateToPracticeQuestionOfImplementationOfQueueInPython() {

		ChainTestListener.log("Navigating to Practice Question of Implementation of Queue in Python...");

		queuepage.implementationOfQueueInPythonBtn();

		queuepage.PracticeQuestionBtn();

		Assert.assertTrue(queuepage.textconfirmPracticeQuestionPage());

		ChainTestListener.log("Successfully navigated to Practice Question of Implementation of Queue in Python.");

	}

	@Test(priority = 10)

	public void listOfPracticeQuestionOfImplementationOfQueueInPython() {

		ChainTestListener.log("Checking the list of Practice Questions for Implementation of Queue in Python...");

		queuepage.implementationOfQueueInPythonBtn();

		queuepage.PracticeQuestionBtn();

		Assert.fail("No list of practice question found");

		ChainTestListener.log("Test failed: No list of practice questions found.");

	}

	@Test(priority = 11)

	public void navigateToPracticeQuestionImplementationUsingCollectionsDeque() {

		ChainTestListener.log("Navigating to Practice Question of Implementation Using Collections Deque...");

		queuepage.implementationUsingCollectionsDequeBtn();

		queuepage.PracticeQuestionBtn();

		Assert.assertTrue(queuepage.textconfirmPracticeQuestionPage());

		ChainTestListener.log("Successfully navigated to Practice Question of Implementation Using Collections Deque.");

	}

	@Test(priority = 12)

	public void listOfPracticeQuestionImplementationUsingCollectionsDeque() {

		ChainTestListener.log("Checking the list of Practice Questions for Implementation Using Collections Deque...");

		queuepage.implementationUsingCollectionsDequeBtn();

		queuepage.PracticeQuestionBtn();

		Assert.assertTrue(queuepage.textconfirmPracticeQuestionPage());

		ChainTestListener.log("Practice questions listed for Implementation Using Collections Deque.");

	}

	@Test(priority = 13)

	public void checkErrorMeaasgeWhenExecutingWithoutCodeInImplementationOfQueueInPython() {

		ChainTestListener
				.log("Checking error message when executing without code in Implementation of Queue in Python...");

		queuepage.implementationOfQueueInPythonBtn();

		queuepage.TryHereBtn();

		queuepage.RunBtn();

		Assert.fail(
				"Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed");

		ChainTestListener.log("Test failed: Expected error message not displayed.");

	}

	@Test(priority = 14)

	public void checkErrorMessageWhenExecutingWithoutCodeInImplementationUsingCollectionsDeque() {

		ChainTestListener
				.log("Checking error message when executing without code in Implementation Using Collections Deque...");

		queuepage.implementationUsingCollectionsDequeBtn();

		queuepage.TryHereBtn();

		queuepage.RunBtn();

		Assert.fail(
				"Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed");

		ChainTestListener.log("Test failed: Expected error message not displayed.");

	}

	@Test(priority = 15)

	public void checkErrorMeaasgeWhenExecutingWithoutCodeInImplementationUsingArray() {

		ChainTestListener.log("Checking error message when executing without code in Implementation Using Array...");

		queuepage.ImplementationUsingArrayBtn();

		queuepage.TryHereBtn();

		queuepage.RunBtn();

		Assert.fail(
				"Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed");

		ChainTestListener.log("Test failed: Expected error message not displayed.");

	}

	@Test(priority = 16)

	public void checkErrorMeaasgeWhenExecutingWithoutCodeInQueueOperations() {

		ChainTestListener.log("Checking error message when executing without code in Queue Operations...");

		queuepage.QueueOperationsBtn();

		queuepage.TryHereBtn();

		queuepage.RunBtn();

		Assert.fail(
				"Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed");

		ChainTestListener.log("Test failed: Expected error message not displayed.");

	}

	@Test(dataProvider = "QueueTryEditorData", dataProviderClass = TestDataProvider.class, priority = 17)

	public void verifyCodeExecutionForQueueTryEditor(String Options, String code, String expectedResult) {

		ChainTestListener.log("Verifying code execution for Queue Try Editor, section: " + Options);

		queuepage.Option(Options);

		queuepage.TryHereBtn();

		tryeditorpage = new TryEditorPage(driver);

		tryeditorpage.enteringCode(code);

		tryeditorpage.runButton();

		String ActualResult = tryeditorpage.output();

		Assert.assertEquals(ActualResult, expectedResult, "Output mismatch for section: " + Options);

		ChainTestListener.log("Code execution verification completed for Queue Try Editor.");

	}

}