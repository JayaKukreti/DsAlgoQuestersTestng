package dsAlgoPages;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	@FindBy(xpath = "//pre[@id='output' and contains(text(), 'Submission Successful')]")private WebElement submissionMessage;
	@FindBy(xpath="//pre[@id='output']")private WebElement consoleOutput;
	@FindBy(xpath="//div[@class='CodeMirror cm-s-default']")private WebElement tryEditor;
	
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
		basicOperationsinLists.click();
	}		
	public void clickApplicationsOfArray() {
		applicationsofArray.click();
	}
	public void tryHere() {
		Tryhere.click();	
	}
	public String consoleoutput() {
		return consoleOutput.getText();
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
	public boolean runButtonIsDisplayed() {
		return runbutton.isDisplayed();
	}
	public void run() {
		runbutton.click();
	}
	public boolean tryEditorIsDisplayed() {
		return tryEditor.isDisplayed();
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
	public String Option(String Options) {
//		  Switch to the appropriate section
			switch (Options) {
			case "Arrays in Python":
			clickArrayInPython();
				break;
			case "Arrays Using List":
			clickArraysUsingList();
				break;
			case "Basic Operations in Lists":
				clickBasicOperationsInLists();
				break;
			case "Applications of Array":
				clickApplicationsOfArray();
				break;
			default:
				throw new IllegalArgumentException("Invalid section: " + Options);
		
	}
			return Options;
}

	
	public String PracticeQuestion(String Options, String Questions) {
	    // Switch to the appropriate section
	    switch (Options) {
	        case "Arrays in Python":
	            clickArrayInPython();
	            clickOnPracticeQuestionLink(); // Move this here to avoid repetition

	            switch (Questions) {
	                case "Search the array":
	                    clickOnsearchTheArray();
	                    break;
	                case "Max Consecutive Ones":
	                    clickOnMaxConsecutiveOnes();
	                    break;
	                case "Find Numbers with Even Number":
	                    clickOnFindNumbersWithEvenNumber();
	                    break;
	                case "Squares of Sorted Array":
	                    clickOnSquaresofaSortedArray();
	                    break;
	                default:
	                    throw new IllegalArgumentException("Invalid Practice Question: " + Questions);
	            }
	            break;

	        default:
	            throw new IllegalArgumentException("Invalid Option: " + Options);
	    }

	    return "Practice Question: " + Questions + " selected.";
	}
}