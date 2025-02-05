package dsAlgoTests;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dsAlgoHooks.Hooks;
import dsAlgoPages.ArrayPage;
import dsAlgoPages.HomePage;
import dsAlgoPages.RegisterPage;
import dsAlgoPages.SigninPage;
import dsAlgoPages.TryEditorForArraysPracticeQuestions;
import dsAlgoPages.TryEditorPage;
import dsAlgoUtils.ConfigReader;
import dsAlgoUtils.TestDataProvider;

public class ArrayTest extends Hooks{
	WebDriver driver;
	HomePage homePage;
	SigninPage signinPage;
	RegisterPage registerPage;
	Properties prop = ConfigReader.initializeProp();
	ArrayPage arrayPage;
	TryEditorPage tryEditorPage;
	TryEditorForArraysPracticeQuestions tap;
	
	@BeforeMethod
	public void navigateToArrayPage() {	
		driver=Hooks.getDriver();
		homePage=new HomePage(driver);
		homePage.clickLaunchPageGetstartedbutton();
		homePage.clickSignin();
        signinPage = new SigninPage(driver);
		signinPage.sendtextusername();
		signinPage.sendtextpassword();
		signinPage.clickLoginbutton();
		homePage.getStartedArray();
		arrayPage = new ArrayPage(driver);   
		
		//Validation is missing	
	}
	@Test
	public void navigateToArrayInPython() {
		arrayPage = new ArrayPage(driver);
		arrayPage.clickArrayInPython();
		Assert.assertTrue(arrayPage.arraysInPythonIsDisplayed());	
	}
	@Test
	public void navigateToArrayUsingList() {
		arrayPage= new ArrayPage(driver);
		arrayPage.clickArraysUsingList();
		Assert.assertTrue(arrayPage.arraysUsingListIsDisplayed());
	}
	@Test
	public void navigateToBasicOperationInList() {
		arrayPage = new ArrayPage(driver);
		arrayPage.clickBasicOperationsInLists();;
		Assert.assertTrue(arrayPage.basicOperationsInListsIsDisplayed());	
	}
	@Test
	public void navigateToApplicationOfArray() {
		arrayPage= new ArrayPage(driver);
		arrayPage.clickApplicationsOfArray();
		Assert.assertTrue(arrayPage.applicationsOfArrayIsDisplayed());
	}
	@Test
	public void navigateToArrayInPythonTryEditor() {
		arrayPage= new ArrayPage(driver);
		arrayPage.clickArrayInPython();
		arrayPage.tryHere();
		Assert.assertTrue(arrayPage.runButtonIsDisplayed());
	//	Assert.assertTrue(arrayPage.tryEditorIsDisplayed());	
	}
	@Test
	public void navigateToArrayUsingListTryEditor() {
		arrayPage= new ArrayPage(driver);
		arrayPage.clickArraysUsingList();
		arrayPage.tryHere();        
		Assert.assertTrue(arrayPage.runButtonIsDisplayed());
		//Assert.assertTrue(arrayPage.tryEditorIsDisplayed());	
	}
	
	@Test
	public void navigateToBasicOperationInListTryEditor() {
		arrayPage= new ArrayPage(driver);
		arrayPage.clickBasicOperationsInLists();
		arrayPage.tryHere();      
		Assert.assertTrue(arrayPage.runButtonIsDisplayed());
	//	Assert.assertTrue(arrayPage.tryEditorIsDisplayed());		
	}
	
	@Test
	public void navigateToApplicationOfArrayTryEditor() {
		arrayPage= new ArrayPage(driver);
		arrayPage.clickApplicationsOfArray();
		arrayPage.tryHere();       
		Assert.assertTrue(arrayPage.runButtonIsDisplayed());
   //	Assert.assertTrue(arrayPage.tryEditorIsDisplayed());
	}
	
	@Test
	public void checkErrorMessageWhenExecutingWithoutCodeInArrayInPythonForTryEditor() { 
		arrayPage= new ArrayPage(driver);
		arrayPage.clickArrayInPython();
		arrayPage.tryHere();
		arrayPage.run();
		Assert.fail(
				"Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");	
	}
	@Test
	public void checkErrorMessageWhenExecutingWithoutCodeArrayUsingListForTryEditor() { 
		arrayPage= new ArrayPage(driver);
		arrayPage.clickArraysUsingList();
		arrayPage.tryHere();
		arrayPage.run();
		Assert.fail(
				"Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");	
	}
	@Test
	public void checkErrorMessageWhenExecutingWithoutCodeBasicOperationInListsForTryEditor() { 
		arrayPage= new ArrayPage(driver);
		arrayPage.clickBasicOperationsInLists();
		arrayPage.tryHere();
		arrayPage.run();
		Assert.fail(
				"Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");	
	}
	@Test
	public void checkErrorMessageWhenExecutingWithoutCodeApplicationofArrayForTryEditor() { 
		arrayPage= new ArrayPage(driver);
		arrayPage.clickApplicationsOfArray();
		arrayPage.tryHere();
		arrayPage.run();
		Assert.fail(
				"Test failed: Expected an error message when clicking the 'Run' button without entering code, but no message was displayed.");	
	}
	@Test(dataProvider = "TryEditorDataArray", dataProviderClass = TestDataProvider.class)
	public void verifyCodeExecutionForArraySections(String Options, String Code, String ExpectedResult) {
		arrayPage = new ArrayPage(driver);
		tryEditorPage = new TryEditorPage(driver);
		arrayPage.Option(Options);
		// Enter the code and execute it
		arrayPage.tryHere();  // Ensure this clicks the "Try Here" button
		tryEditorPage.enteringCode(Code);  // Enter the code into the editor
		tryEditorPage.runButton();  // Run the code
		String actualResult = tryEditorPage.output();  // Get the output from the editor

		// Compare the actual output with the expected output
		Assert.assertEquals(actualResult, ExpectedResult, "Output mismatch for section: " + Options);
	}
	
	@Test(dataProvider = "PracticeQuestionForArrayRun", dataProviderClass = TestDataProvider.class)
	public void PracticeQuestionVaildAndInvalidDataWithRunButton(String Options, String Questions, String pcode, String expectedResult) {
	    arrayPage = new ArrayPage(driver);
	    tap = new TryEditorForArraysPracticeQuestions(driver);

    arrayPage.PracticeQuestion(Options, Questions); // Navigate to the question
	    tap.enteringCodeForArray(pcode);  // Enter the code
    tap.clickRunButton();  // Run the code

	    String actualResult = tap.getOutput(); // Get the output
    Assert.assertEquals(actualResult, expectedResult, "Output mismatch for section: " + Options);
}

	//PracticeQuestionSubmit
	@Test(dataProvider = "PracticeQuestionForArraySubmit", dataProviderClass = TestDataProvider.class)
	public void PracticeQuestionVaildAndInvalidDataWithSubmitButton(String Options, String Question, String pcode, String expectedResult) {
	    tap = new TryEditorForArraysPracticeQuestions(driver);
       arrayPage.PracticeQuestion(Options, Question); // Navigate to the question
	    tap.enteringCodeForArray(pcode);  // Enter the code
        arrayPage.submit();  // Run the code

	    String actualResult = tap.getOutput(); // Get the output
    Assert.assertEquals(actualResult, expectedResult, "Output mismatch for section: " + Options);
}
	}

