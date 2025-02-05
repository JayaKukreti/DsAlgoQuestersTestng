package dsAlgoTests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dsAlgoHooks.Hooks;
import dsAlgoPages.ArrayPage;
import dsAlgoPages.HomePage;
import dsAlgoPages.LinkedListPage;
import dsAlgoPages.RegisterPage;
import dsAlgoPages.SigninPage;
import dsAlgoPages.TryEditorPage;
import dsAlgoUtils.ConfigReader;
import dsAlgoUtils.TestDataProvider;

public class LinkedListTest extends Hooks{
	WebDriver driver;
	HomePage homePage;
	SigninPage signinPage;
	RegisterPage registerPage;
	Properties prop = ConfigReader.initializeprop();
	LinkedListPage  linkedListPage;
	TryEditorPage tryEditorPage;


	@BeforeMethod
	public void navigateToLinkedListPage() {	
		driver=Hooks.getDriver();
		homePage=new HomePage(driver);
		homePage.clickLaunchPageGetstartedbutton();
		homePage.clickSignin();
		signinPage = new SigninPage(driver);
		signinPage.sendtextusername();
		signinPage.sendtextpassword();
		signinPage.clickLoginbutton();
		homePage.getStartedLinkedlist();
		linkedListPage = new LinkedListPage(driver);   
	}
	@Test
	public void navigateToIntroduction() {
		linkedListPage.clickOnIntroduction();
		Assert.assertTrue(linkedListPage.introductionIsDisplayed());	
	}
	@Test
	public void navigateToCreateALinkedList() {
		linkedListPage.clickOnCreatingALinkedList();
		Assert.assertTrue(linkedListPage.creatingALinkedListIsDisplayed());	
	}
	@Test
	public void navigateToTypesOfLinkedList() {
		linkedListPage.clickOnTypesOfLinkedList();
		Assert.assertTrue(linkedListPage.typesOfLinkedListIsDisplayed());	
	}
	@Test
	public void navigateToImplementLinkedListInPython() {
		linkedListPage.clickOnImplementLinkedList();
		Assert.assertTrue(linkedListPage.implementLinkedListIsDisplayed());	
	}
	@Test
	public void navigateToTraversal() {
		linkedListPage.clickOnTraversal();
		Assert.assertTrue(linkedListPage.traversalIsDisplayed());	
	}
	@Test
	public void navigateToInsertion() {
		linkedListPage.clickOnInsertion();
		Assert.assertTrue(linkedListPage.insertionIsDisplayed());	
	}
	@Test
	public void navigateDeletion() {
		linkedListPage.clickOnDeletion();
		Assert.assertTrue(linkedListPage.deletionIsDisplayed());	
	}
	@Test
	public void navigatenavigateToIntroductionTryEditor() {
		linkedListPage.clickOnIntroduction();
		linkedListPage.tryHere();
		Assert.assertTrue(linkedListPage.runButtonIsDisplayed());
	}
	@Test
	public void navigateToCreateALinkedListTryEditor() {
	linkedListPage.clickOnCreatingALinkedList();
	linkedListPage.tryHere();
	Assert.assertTrue(linkedListPage.runButtonIsDisplayed());
	}
	@Test
	public void navigateToTypesOfLinkedListTryEditor() {
		linkedListPage.clickOnTypesOfLinkedList();
		linkedListPage.tryHere();
		Assert.assertTrue(linkedListPage.runButtonIsDisplayed());	
	}
	@Test
	public void navigateToImplementLinkedListInPythonTryEditor() {
		linkedListPage.clickOnImplementLinkedList();
		linkedListPage.tryHere();
		Assert.assertTrue(linkedListPage.runButtonIsDisplayed());	
	}
	@Test
	public void navigateToTraversalTryEditor() {
		linkedListPage.clickOnTraversal();
		linkedListPage.tryHere();
		Assert.assertTrue(linkedListPage.runButtonIsDisplayed());	
	}
	@Test
	public void navigateToInsertionTryEditor() {
		linkedListPage.clickOnInsertion();
		linkedListPage.tryHere();
		Assert.assertTrue(linkedListPage.runButtonIsDisplayed());
	}
	@Test
	public void navigateToDeletionTryEditor() {
		linkedListPage.clickOnDeletion();
		linkedListPage.tryHere();
		Assert.assertTrue(linkedListPage.runButtonIsDisplayed());
	}
   @Test
	public void checkErrorMessageWhenExecutingWithoutCodeToIntroductionTryEditor() { 
		linkedListPage.clickOnIntroduction();
		linkedListPage.tryHere();
		linkedListPage.run();
		Assert.fail(
				"Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");	
	}
   @Test
	public void checkErrorMessageWhenExecutingWithoutCodeToCreateALinkedListTryEditor() {
		linkedListPage.clickOnCreatingALinkedList();
		linkedListPage.tryHere();
		linkedListPage.run();
		Assert.fail(
				"Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
		}
   @Test
	public void checkErrorMessageWhenExecutingWithoutCodeToTypesOfLinkedListTryEditor() {
		linkedListPage.clickOnTypesOfLinkedList();
		linkedListPage.tryHere();
		linkedListPage.run();
		Assert.fail(
				"Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
		}
   @Test
	public void checkErrorMessageWhenExecutingWithoutCodeToImplementLinkedListInPythonTryEditor() {
		linkedListPage.clickOnImplementLinkedList();
		linkedListPage.tryHere();
		linkedListPage.run();
		Assert.fail(
				"Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
		
	}
	@Test
	public void checkErrorMessageWhenExecutingWithoutCodeToTraversalTryEditor() {
		linkedListPage.clickOnTraversal();
		linkedListPage.tryHere();
		linkedListPage.run();
		Assert.fail(
				"Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	}
	@Test
	public void checkErrorMessageWhenExecutingWithoutCodeToInsertionTryEditor() {
		linkedListPage.clickOnInsertion();
		linkedListPage.tryHere();
		linkedListPage.run();
		Assert.fail(
				"Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	}
	@Test
	public void checkErrorMessageWhenExecutingWithoutCodeToDeletionTryEditor() {
		linkedListPage.clickOnDeletion();
		linkedListPage.tryHere();
		linkedListPage.run();
		Assert.fail(
				"Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	}
	@Test(dataProvider = "TryEditorDataLinkedList", dataProviderClass = TestDataProvider.class)
	public void verifyCodeExecutionForLinkedList(String Options, String Code, String ExpectedResult) {
		tryEditorPage = new TryEditorPage(driver);
		linkedListPage.Option(Options);
		// Enter the code and execute it
		linkedListPage.tryHere();// Ensure this clicks the "Try Here" button
		tryEditorPage.enteringCode(Code);  // Enter the code into the editor
		tryEditorPage.runButton();  // Run the code
		String actualResult = tryEditorPage.output();  // Get the output from the editor

   	// Compare the actual output with the expected output
	Assert.assertEquals(actualResult, ExpectedResult, "Output mismatch for section: " + Options);
	}
	@Test
	public void checkforPracticeQuestion() {
		linkedListPage.clickOnIntroduction();
		linkedListPage.practiceQuestions();
		
		Assert.fail(
				"Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");
	}
	}

