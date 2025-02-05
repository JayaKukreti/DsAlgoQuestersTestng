package dsAlgoPages;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dsAlgoUtils.ConfigReader;
import dsAlgoUtils.ExcelDataReader;

public class QueuePage {
	public WebDriver driver;
	Properties prop;
	ArrayList<String>actualURL= new ArrayList<>(); 
	List<Map<String,String>>exceldatareader;
	
	

	//1.Locators of page
	@FindBy(xpath="//a[text()='Implementation of Queue in Python']" )
	private WebElement implementationOfQueueInPythonBtn;
	@FindBy(xpath="//a[text()='Implementation using collections.deque']")
	private WebElement  implementationUsingCollectionsDequeBtn;
	@FindBy(xpath="//a[text()='Implementation using array']")
	private WebElement ImplementationUsingArrayBtn;
	@FindBy(xpath="//a[text()='Queue Operations']")
	private WebElement QueueOperationsBtn;
	@FindBy(xpath="//p[contains(text(),'Implementation of Queue in Python')]")
	private WebElement textconfirmImplementationofQueue;
	@FindBy(xpath="//p[contains(text(),'Implementation using collections.deque')]")
	private WebElement textconfirmImplementationUsingCollectionsDeque;
	@FindBy(xpath="//button[contains(text(),'Run')]")
	private WebElement textconfirmTextEditor;
	@FindBy(xpath="//p[contains(text(),'Implementation using array')]")
	private WebElement textconfirmImplementationUsingArray;
	@FindBy(xpath="//p[contains(text(),'Queue Operations')]")
	private WebElement textconfirmQueueOperations;
	@FindBy(xpath="//a[contains(text(),'NumpyNinja')]")
	private WebElement textconfirmPracticeQuestionPage;
	@FindBy(xpath="//a[text()='Try here>>>']" )
	private WebElement TryHereBtn;
	@FindBy(xpath = "//div[contains(@class, 'CodeMirror') and contains(@class, 'cm-s-default')]")
	private WebElement TryEditorPage;
	@FindBy(id="output")
	private WebElement TryEditorOutput;
	@FindBy(xpath="//button[@type='button']")
	private WebElement RunBtn;
	@FindBy(xpath="//a[text()='Practice Questions']")
	private WebElement PracticeQuestionBtn;
	
	//2.Constructor to initialize the driver   
	public  QueuePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		//this.prop = ConfigReader.initializeProp();
	}
	//3. Methods to interact with elements
	public boolean textconfirmImplementationofQueue() {
		return textconfirmImplementationofQueue.isDisplayed();
	}
	public boolean textconfirmTextEditor() {
		return textconfirmTextEditor.isDisplayed();
	}
	public boolean textconfirmImplementationUsingCollectionsDeque() {
		return textconfirmImplementationUsingCollectionsDeque.isDisplayed();
	}
	public boolean textconfirmImplementationUsingArray() {
		return textconfirmImplementationUsingArray.isDisplayed();
	}
	public boolean textconfirmQueueOperations() {
		return textconfirmQueueOperations.isDisplayed();
	}
	public boolean textconfirmPracticeQuestionPage() {
		return textconfirmPracticeQuestionPage.isDisplayed();
	}
	public String Option(String Options) {
		//Option in Queue page to go till try Editor
		switch (Options) {
		case "Implementation of Queue in Python":
			implementationOfQueueInPythonBtn();
			break;
		case "Implementation using collections.deque":
			implementationUsingCollectionsDequeBtn();
			break;
		case "Implementation using array":
			ImplementationUsingArrayBtn();
			break;
		case "Queue Operations":
			QueueOperationsBtn();
			break;
		default:
			throw new IllegalArgumentException("Invalid section: " + Options);
	
}
		return Options;
}
	
	
	public void QueueOperationsBtn() {
		QueueOperationsBtn.click();
	}
	
	public void implementationUsingCollectionsDequeBtn() {
		implementationUsingCollectionsDequeBtn.click();
	}
		//....................................................................
		public void implementationOfQueueInPythonBtn() {
		implementationOfQueueInPythonBtn.click();
	}
		public void ImplementationUsingArrayBtn() {
			ImplementationUsingArrayBtn.click();
		}
	//....................................................................	
	public void TryHereBtn() {
		TryHereBtn.click();
	}
    //.....................................................................
	 public  void RunBtn()
	    {
	    	RunBtn.click();
	    }
	//......................................................................
	 public void PracticeQuestionBtn() {
		 PracticeQuestionBtn.click();
	 }

} 
	 
