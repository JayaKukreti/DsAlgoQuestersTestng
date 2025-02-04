package dsAlgoPages;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import dev.failsafe.internal.util.Durations;
import dsAlgoUtils.ConfigReader;
import dsAlgoUtils.ExcelDataReader;

public class TreePage {
	public WebDriver driver;
	Properties prop;
	List<Map<String,String>> excelData; 
	String option;
	String codetorun;
	String actualResult;
	String result;
	List<String> actualresults = new ArrayList<>();
//1.Create constructor
	public TreePage(WebDriver driver) {
		this.driver=driver; 
		//this.prop= ConfigReader. initializeProp();
		PageFactory.initElements(driver, this);
	}
//2. Locators
	
	@FindBy(xpath="//a[text()='Try here>>>']")
	private WebElement TryHereBtn;
	@FindBy(xpath="//button[text()='Run']")
	private WebElement RunBtn;
	@FindBy(xpath="//p[contains(text(),'Overview of Trees')]")
	private WebElement  textconfirmOverviewOfTrees;
	@FindBy(xpath="//p[contains(text(),'Terminologies')]")
	private WebElement textconfirmTerminologies;
	@FindBy(xpath="//p[contains(text(),'Types of Trees')]")
	private WebElement textconfirmTypesOfTrees;
	@FindBy(xpath="//p[contains(text(),'Tree Traversals')]")
	private WebElement  textconfirmTreeTraversals;
	@FindBy(xpath="//p[contains(text(),'Traversals-Illustration')]")
	private WebElement  textconfirmTraversalsIllustration;
	@FindBy(xpath="//p[contains(text(),'Binary Trees')]")
	private WebElement  textconfirmBinaryTrees;
	@FindBy(xpath="//p[contains(text(),'Types of Binary Trees')]")
	private WebElement  textconfirmTypesOfBinaryTrees;
	@FindBy(xpath="//p[contains(text(),'Implementation in Python')]")
	private WebElement  textconfirmImplementationInPython;
	@FindBy(xpath="//p[contains(text(),'Binary Tree Traversals')]")
	private WebElement  textconfirmBinaryTreeTraversals;
	@FindBy(xpath="//p[contains(text(),'Implementation of Binary Trees')]")
	private WebElement  textconfirmImplementationOfBinaryTrees;
	@FindBy(xpath="//p[contains(text(),'Applications of Binary trees')]")
	private WebElement  textconfirmApplicationsOfBinaryTrees;
	@FindBy(xpath="//p[contains(text(),'Binary Search Trees')]")
	private WebElement  textconfirmBinarySearchTreess;
	@FindBy(xpath="//p[contains(text(),'Implementation Of BST')]")
	private WebElement  textconfirmImplementationOfBST;
	@FindBy(xpath="//button[contains(text(),'Run')]")
	private WebElement textconfirmTextEditor;
	@FindBy(xpath="//a[contains(text(),'NumpyNinja')]")
	private WebElement textconfirmPracticeQuestionPage;
	@FindBy(xpath="//h4[text()='Tree']")
	private WebElement DisplayTreeText;
	@FindBy(id="output")
	private WebElement ValidPythonResult;
	@FindBy(xpath="//a[text()='Overview of Trees']")
	private WebElement OverviewOfTrees;
	@FindBy(xpath="//a[text()='Terminologies']")
	private WebElement Terminologies;
	@FindBy(xpath="//a[text()='Types of Trees']")
	private WebElement TypesOfTrees;
	@FindBy(xpath="//a[text()='Tree Traversals']")
	private WebElement TreeTraversals;
	@FindBy(xpath="//a[text()='Traversals-Illustration']")
	private WebElement TraversalsIllustration;
	@FindBy(xpath="//a[text()='Binary Trees']")
	private WebElement BinaryTrees;
	@FindBy(xpath="//a[text()='Types of Binary Trees']")
	private WebElement TypesOfBinaryTrees;
	@FindBy(xpath="//a[text()='Implementation in Python']")
	private WebElement ImplementationInPython;
	@FindBy(xpath="//a[text()='Binary Tree Traversals']")
	private WebElement BinaryTreeTraversals;
	@FindBy(xpath="//a[text()='Implementation of Binary Trees']")
	private WebElement ImplementationOfBinaryTrees;
	@FindBy(xpath="//a[text()='Applications of Binary trees']")
	private WebElement ApplicationsOfBinaryTrees;
	@FindBy(xpath="//a[text()='Binary Search Trees']")
	private WebElement BinarySearchTrees;
	@FindBy(xpath="//a[text()='Implementation Of BST']")
	private WebElement ImplementationOfBST;
	@FindBy(xpath="//a[text()='Practice Questions']")
	private WebElement PracticeQuestionPage;
	//Methods
	public String Option(String Options) {
		switch(Options) {
	case "Overview of Trees":
	OverviewOfTrees();
	break;
	case "Terminologies":
		Terminologies() ;
		break;
	case "Types of Trees":
		TypesOfTrees();
		break;
	case "Tree Traversals":
		TreeTraversals();
		break;
	case "Traversals-Illustration":
		TraversalsIllustration() ;
		break;
	case "Binary Trees"	:
		BinaryTrees();
		break;
	case "Types of Binary Trees":
		TypesOfBinaryTrees();
		break;
	case "Implementation in Python":
		ImplementationInPython();
		break;
	case "Binary Tree Traversals":
		BinaryTreeTraversals();
		break;
	case "Implementation of Binary Trees":
		 ImplementationOfBinaryTrees();
		 break;
	case "Applications of Binary trees"	:
		ApplicationsOfBinaryTrees();
		break;
	case "Binary Search Trees":
		BinarySearchTrees();
		break;
	case "Implementation Of BST":
		ImplementationOfBST() ;
		break;
	default:
		throw new IllegalArgumentException("Invalid section: " + Options);	
	
		}
		return Options;
	}
	public boolean textconfirmOverviewOfTrees() {
		return textconfirmOverviewOfTrees.isDisplayed();
	}
	public boolean textconfirmTerminologies() {
		return textconfirmTerminologies.isDisplayed();
	}
	public boolean textconfirmTypesOfTrees() {
		return textconfirmTypesOfTrees.isDisplayed();
	}
	public boolean  textconfirmTreeTraversals() {
		return  textconfirmTreeTraversals.isDisplayed();
	}
	public boolean textconfirmTraversalsIllustration() {
		return textconfirmTraversalsIllustration.isDisplayed();
	}
	public boolean textconfirmBinaryTrees() {
		return textconfirmBinaryTrees.isDisplayed();
	}
	public boolean textconfirmTypesOfBinaryTrees() {
		return textconfirmTypesOfBinaryTrees.isDisplayed();
	}
	public boolean  textconfirmImplementationInPython() {
		return  textconfirmImplementationInPython.isDisplayed();
	}
	public boolean textconfirmBinaryTreeTraversals() {
		return textconfirmBinaryTreeTraversals.isDisplayed();
	}
	public boolean textconfirmImplementationOfBinaryTrees() {
		return textconfirmImplementationOfBinaryTrees.isDisplayed();
	}
	public boolean  textconfirmApplicationsOfBinaryTrees() {
		return  textconfirmApplicationsOfBinaryTrees.isDisplayed();
	}
	public boolean  textconfirmBinarySearchTreess() {
		return  textconfirmBinarySearchTreess.isDisplayed();
	}
	public boolean  textconfirmImplementationOfBST() {
		return  textconfirmImplementationOfBST.isDisplayed();
	}
	public boolean  textconfirmTextEditor() {
		return  textconfirmTextEditor.isDisplayed();
	}
	public boolean textconfirmPracticeQuestionPage()  {
		return  textconfirmPracticeQuestionPage.isDisplayed();
	}
	
  public void TryHereBtn() {
		TryHereBtn.click();
	}
	
	public String alertMessage() {
		Alert alert =driver.switchTo().alert();
		String AlertMessage=driver.switchTo().alert().getText();
		System.out.println("The alertmessge is " +AlertMessage);
		alert.accept();
		return AlertMessage;
		
	}
	public void RunBtn() {
		RunBtn.click();
	}
	public void OverviewOfTrees() {
		OverviewOfTrees.click();
	}
		
	
	public String Result() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			// Switch to alert box if present
			Alert alert = driver.switchTo().alert();
			actualResult = alert.getText();

			System.out.println("Alert message of invalid code: " + actualResult);
			actualresults.add(actualResult);
			alert.accept(); // Accept the alert
		} catch (NoAlertPresentException e) {
			// No alert present, handle as normal
			actualResult =ValidPythonResult.getText();
			actualresults.add(actualResult);
			System.out.println("actual result of valid code: " + actualResult);
		}
		return actualResult;
	}
	public void Terminologies() {
		 Terminologies.click();
	}
	public void TypesOfTrees() {
		TypesOfTrees.click();
	}
	public void TreeTraversals() {
		TreeTraversals.click();
	}
	public void TraversalsIllustration() {
		TraversalsIllustration.click();
	}
	public void BinaryTrees() {
		BinaryTrees.click();
	}
	public void TypesOfBinaryTrees() {
		TypesOfBinaryTrees.click();
	}
	public void ImplementationInPython() {
		ImplementationInPython.click();
	}
	public void BinaryTreeTraversals() {
		 BinaryTreeTraversals.click();
	}
	public void ApplicationsOfBinaryTrees() {
		ApplicationsOfBinaryTrees.click();
		}
	public void ImplementationOfBinaryTrees() {
		ImplementationOfBinaryTrees.click();
	}
	public void BinarySearchTrees() {
		BinarySearchTrees.click();
	}
	public void ImplementationOfBST() {
		ImplementationOfBST.click();
	}
	public void PracticeQuestionPage() {
		PracticeQuestionPage.click();
	}
		
	}
	
	
