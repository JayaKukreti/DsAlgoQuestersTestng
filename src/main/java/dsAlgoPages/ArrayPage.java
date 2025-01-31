package dsAlgoPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dsAlgoUtils.ConfigReader;
import dsAlgoUtils.ExcelDataReader;

public class ArrayPage {
	WebDriver driver;
    Properties prop;
	String option;
    String alertText;
    
 // 2. Constructor of Page Class
 	public ArrayPage(WebDriver driver) {
 		if (driver == null) {
 			throw new IllegalArgumentException("WebDriver instance cannot be null.");
 		}
 		this.driver = driver;
 		PageFactory.initElements(driver, this);
 	
 	}

	//1.Locators 
	@FindBy(xpath = "//h4[text()='Array']")private WebElement arrayHeader;
	@FindBy(linkText = "Arrays in Python")private WebElement arraysInPython;
	@FindBy(linkText = "Arrays Using List")private WebElement arraysUsingList;
	@FindBy(linkText = "Basic Operations in Lists")private WebElement basicOperationsinLists;
	@FindBy(linkText = "Applications of Array")private WebElement applicationsofArray;
	@FindBy(linkText = "Options")WebElement arrayOptions;
	@FindBy(linkText = "Practice Questions")private WebElement practiceQuestionLink;
	@FindBy(xpath = "//a[text()='Try here>>>']")private WebElement Tryhere;
	@FindBy(linkText="Search the array")private WebElement Question1;
	@FindBy(linkText = "Max Consecutive Ones")private WebElement Question2 ;
	@FindBy(linkText = "Find Numbers with Even Number of Digits")private WebElement Question3 ;
	@FindBy(linkText ="Squares of a Sorted Array")private WebElement Question4 ;
	@FindBy(xpath = "//a[contains(@class, 'list-group-item')]")List<WebElement> practiceQuestions;
	@FindBy(xpath="//button[@type='button']")private WebElement runbutton;
	@FindBy(xpath="//input[@type='submit' and @value='Submit' and contains(@class, 'button')]")private WebElement submitbutton ;
	@FindBy(xpath = "//pre[@id='output' and contains(text(), 'Submission Successful')]")
	private WebElement submissionMessage;
	@FindBy(xpath="//pre[@id='output']")
	private WebElement Consoleoutput;
	
	//Action methods
	public boolean arrayPageIsDisplayed() {
		return arrayHeader.isDisplayed();
	}
	public boolean arraysInPythonIsDisplayed() {
		return arraysInPython.isDisplayed();
	}
	public boolean arraysUsingListIsDisplayed() {
		return arraysUsingList.isDisplayed();
	}
	public boolean basicOperationsInListsIsDisplayed() {
		return basicOperationsinLists.isDisplayed();
	}
	public boolean applicationsOfArrayIsDisplayed() {
		return applicationsofArray.isDisplayed();
	}
	public void clickArrayInPython() {
		arraysInPython.click();
	}
	public void clickArraysUsingList() {
		arraysUsingList.click();
	}
	public void clickBasicOperationsInLists() {
		arraysInPython.click();
	}		
	public void clickApplicationsOfArray() {
		arraysInPython.click();
	}
	public void tryHere() {
		Tryhere.click();	
	}
	public String consoleoutput() {
		return Consoleoutput.getText();
	}
	
	public void clickOnPracticeQuestionLink() {
		practiceQuestionLink.click();
	}
	public boolean maxConsecutiveOnesIsDisplyed() {
		return Question2.isDisplayed();
	}
	public boolean findNumberswithEvenNumberofDigitsIsDisplyed() {
		return Question2.isDisplayed();
	}
	public boolean squaresofaSortedArrayIsDisplyed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOf(Question4)).isDisplayed();
	}
	public void clickOnsearchTheArray() {
		Question1.click();
	}
	public void clickOnMaxConsecutiveOnes() {
		Question2.click();
	}
	public void clickOnFindNumbersWithEvenNumber() {
		Question3.click();
	}
	public void clickOnSquaresofaSortedArray() {
		Question4.click();
	}
	public List<WebElement> getPracticeQuestions() {
		return practiceQuestions;
	}
	public void run() {
		runbutton.click();
	}

	public String actualResult() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			// Switch to alert box if present
			Alert alert = driver.switchTo().alert();
			alertText = alert.getText();
			alert.accept(); // Accept the alert
			System.out.println("Alert message of invalid code: " + alertText);
		} catch (NoAlertPresentException e) {
			// No alert present, handle as normal
			System.out.println("actual result of valid code: " + alertText);
		}
		return alertText;
	}
	public void submit() {
		submitbutton.click();
	}
	public String actualOutputResult() {
		return  submissionMessage.getText();
	}
}