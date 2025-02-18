package dsAlgoTests;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.chaintest.plugins.ChainTestListener;

import dsAlgoBase.Base;
import dsAlgoPages.HomePage;
import dsAlgoPages.LinkedListPage;
import dsAlgoPages.RegisterPage;
import dsAlgoPages.SigninPage;
import dsAlgoPages.TryEditorPage;
import dsAlgoUtils.ConfigReader;
import dsAlgoUtils.TestDataProvider;

public class LinkedListTest extends Base {
	WebDriver driver;
	HomePage homePage;
	SigninPage signinPage;
	RegisterPage registerPage;
	Properties prop = ConfigReader.initializeprop();
	LinkedListPage linkedListPage;
	TryEditorPage tryEditorPage;

	@BeforeMethod
	public void navigateToLinkedListPage() {
		driver = Base.getDriver();
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
		ChainTestListener.log("Navigating to LinkedList Page");
		homePage.getStartedLinkedlist();
		linkedListPage = new LinkedListPage(driver);
	}

	@Test(priority = 1)
	public void navigateToIntroduction() {
		ChainTestListener.log("Navigating to Introduction page");
		linkedListPage.clickOnIntroduction();
		Assert.assertTrue(linkedListPage.introductionIsDisplayed());
	}

	@Test(priority = 2)
	public void navigateToCreateALinkedList() {
		ChainTestListener.log("Navigating to Create a Linked List page");
		linkedListPage.clickOnCreatingALinkedList();
		Assert.assertTrue(linkedListPage.creatingALinkedListIsDisplayed());
	}

	@Test(priority = 3)
	public void navigateToTypesOfLinkedList() {
		ChainTestListener.log("Navigating to Types of Linked List page");
		linkedListPage.clickOnTypesOfLinkedList();
		Assert.assertTrue(linkedListPage.typesOfLinkedListIsDisplayed());
	}

	@Test(priority = 4)
	public void navigateToImplementLinkedListInPython() {
		ChainTestListener.log("Navigating to Implement Linked List in Python page");
		linkedListPage.clickOnImplementLinkedList();
		Assert.assertTrue(linkedListPage.implementLinkedListIsDisplayed());
	}

	@Test(priority = 5)
	public void navigateToTraversal() {
		ChainTestListener.log("Navigating to Traversal page");
		linkedListPage.clickOnTraversal();
		Assert.assertTrue(linkedListPage.traversalIsDisplayed());
	}

	@Test(priority = 6)
	public void navigateToInsertion() {
		ChainTestListener.log("Navigating to Insertion page");
		linkedListPage.clickOnInsertion();
		Assert.assertTrue(linkedListPage.insertionIsDisplayed());
	}

	@Test(priority = 7)
	public void navigateDeletion() {
		ChainTestListener.log("Navigating to Deletion page");
		linkedListPage.clickOnDeletion();
		Assert.assertTrue(linkedListPage.deletionIsDisplayed());
	}

	@Test(priority = 8)
	public void navigatenavigateToIntroductionTryEditor() {
		ChainTestListener.log("Navigating to Introduction Try Editor");
		linkedListPage.clickOnIntroduction();
		linkedListPage.tryHere();
		Assert.assertTrue(linkedListPage.runButtonIsDisplayed());
	}

	@Test(priority = 9)
	public void navigateToCreateALinkedListTryEditor() {
		ChainTestListener.log("Navigating to Create a Linked List Try Editor");
		linkedListPage.clickOnCreatingALinkedList();
		linkedListPage.tryHere();
		Assert.assertTrue(linkedListPage.runButtonIsDisplayed());
	}

	@Test(priority = 10)
	public void navigateToTypesOfLinkedListTryEditor() {
		ChainTestListener.log("Navigating to Types of Linked List Try Editor");
		linkedListPage.clickOnTypesOfLinkedList();
		linkedListPage.tryHere();
		Assert.assertTrue(linkedListPage.runButtonIsDisplayed());
	}

	@Test(priority = 11)
	public void navigateToImplementLinkedListInPythonTryEditor() {
		ChainTestListener.log("Navigating to Implement Linked List in Python Try Editor");
		linkedListPage.clickOnImplementLinkedList();
		linkedListPage.tryHere();
		Assert.assertTrue(linkedListPage.runButtonIsDisplayed());
	}

	@Test(priority = 12)
	public void navigateToTraversalTryEditor() {
		ChainTestListener.log("Navigating to Traversal Try Editor");
		linkedListPage.clickOnTraversal();
		linkedListPage.tryHere();
		Assert.assertTrue(linkedListPage.runButtonIsDisplayed());
	}

	@Test(priority = 13)
	public void navigateToInsertionTryEditor() {
		ChainTestListener.log("Navigating to Insertion Try Editor");
		linkedListPage.clickOnInsertion();
		linkedListPage.tryHere();
		Assert.assertTrue(linkedListPage.runButtonIsDisplayed());
	}

	@Test(priority = 14)
	public void navigateToDeletionTryEditor() {
		ChainTestListener.log("Navigating to Deletion Try Editor");
		linkedListPage.clickOnDeletion();
		linkedListPage.tryHere();
		Assert.assertTrue(linkedListPage.runButtonIsDisplayed());
	}

	@Test(priority = 15)
	public void checkErrorMessageWhenExecutingWithoutCodeToIntroductionTryEditor() {
		ChainTestListener.log("Checking error message when executing without code in Introduction Try Editor");
		linkedListPage.clickOnIntroduction();
		linkedListPage.tryHere();
		linkedListPage.run();
		Assert.fail(
				"Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	}

	@Test(priority = 16)
	public void checkErrorMessageWhenExecutingWithoutCodeToCreateALinkedListTryEditor() {
		ChainTestListener.log("Checking error message when executing without code in Create a Linked List Try Editor");
		linkedListPage.clickOnCreatingALinkedList();
		linkedListPage.tryHere();
		linkedListPage.run();
		Assert.fail(
				"Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	}

	@Test(priority = 17)
	public void checkErrorMessageWhenExecutingWithoutCodeToTypesOfLinkedListTryEditor() {
		ChainTestListener.log("Checking error message when executing without code in Types of Linked List Try Editor");
		linkedListPage.clickOnTypesOfLinkedList();
		linkedListPage.tryHere();
		linkedListPage.run();
		Assert.fail(
				"Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	}

	@Test(priority = 18)
	public void checkErrorMessageWhenExecutingWithoutCodeToImplementLinkedListInPythonTryEditor() {
		ChainTestListener.log("Checking error message when executing without code in Implement Linked List Try Editor");
		linkedListPage.clickOnImplementLinkedList();
		linkedListPage.tryHere();
		linkedListPage.run();
		Assert.fail(
				"Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	}

	@Test(priority = 19)
	public void checkErrorMessageWhenExecutingWithoutCodeToTraversalTryEditor() {
		ChainTestListener.log("Checking error message when executing without code in Traversal Try Editor");
		linkedListPage.clickOnTraversal();
		linkedListPage.tryHere();
		linkedListPage.run();
		Assert.fail(
				"Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	}

	@Test(priority = 20)
	public void checkErrorMessageWhenExecutingWithoutCodeToInsertionTryEditor() {
		ChainTestListener.log("Checking error message when executing without code in Insertion Try Editor");
		linkedListPage.clickOnInsertion();
		linkedListPage.tryHere();
		linkedListPage.run();
		Assert.fail(
				"Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	}

	@Test(priority = 21)
	public void checkErrorMessageWhenExecutingWithoutCodeToDeletionTryEditor() {
		ChainTestListener.log("Checking error message when executing without code in Deletion Try Editor");
		linkedListPage.clickOnDeletion();
		linkedListPage.tryHere();
		linkedListPage.run();
		Assert.fail(
				"Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	}

	@Test(dataProvider = "TryEditorDataLinkedList", dataProviderClass = TestDataProvider.class, priority = 22)
	public void verifyCodeExecutionForLinkedList(String Options, String Code, String ExpectedResult) {
		ChainTestListener.log("Verifying code execution for LinkedList");
		tryEditorPage = new TryEditorPage(driver);
		linkedListPage.Option(Options);
		linkedListPage.tryHere();
		tryEditorPage.enteringCode(Code);
		tryEditorPage.runButton();
		String actualResult = tryEditorPage.output();
		Assert.assertEquals(actualResult, ExpectedResult, "Output mismatch for section: " + Options);
	}

	@Test(priority = 23)
	public void checkforPracticeQuestion() {
		ChainTestListener.log("Navigating to Introduction and clicking Practice Question");
		linkedListPage.clickOnIntroduction();
		linkedListPage.practiceQuestions();
		linkedListPage.run();
		Assert.fail(
				"Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	}
}
