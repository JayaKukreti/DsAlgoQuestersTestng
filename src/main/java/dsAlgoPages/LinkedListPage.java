package dsAlgoPages;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinkedListPage {
	WebDriver driver;
	Properties prop;
	String option;

	public LinkedListPage(WebDriver driver) {
		if (driver == null) {
 			throw new IllegalArgumentException("WebDriver instance cannot be null.");
 		}
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//h4[text()='Linked List']")
	private WebElement Textconfirmlinked;
	@FindBy(linkText = "Introduction")
	private WebElement Introduction;
	@FindBy(xpath = "//a[text()='Introduction']")
	private WebElement TextconfirmIntroduction;
	@FindBy(xpath = "//a[text()='Try here>>>']")
	private WebElement Tryhere;
	@FindBy(xpath="//button[@type='button']")
	private WebElement runbutton;
	@FindBy(xpath = "//a[text()='Creating Linked LIst']")
	private WebElement CreatingLinkedList;
	@FindBy(xpath = "//a[text()='Types of Linked List']")
	private WebElement TypesofLnkedlist;
	@FindBy(xpath = "//a[text()='Implement Linked List in Python']")
	private WebElement Implementlinkedlist;
	@FindBy(linkText = "Traversal")
	private WebElement Traversal;
	@FindBy(linkText="Insertion")
	private WebElement Insertion;
	@FindBy(linkText="Deletion")
	private WebElement Deletion;
	@FindBy(xpath="//a[text()='Practice Questions']")
	private WebElement PracticeQuestion;



	public boolean textconfirmlinked() {
		return Textconfirmlinked.isDisplayed();
	}
	public void clickOnIntroduction() {
		Introduction.click();
	}
	public boolean introductionIsDisplayed() {
		return Introduction.isDisplayed();
	}
	public void clickOnCreatingALinkedList() {
		CreatingLinkedList.click();
	}
	public boolean creatingALinkedListIsDisplayed() {
		return CreatingLinkedList.isDisplayed();
	}
	public void clickOnTypesOfLinkedList() {
		TypesofLnkedlist.click();
	}
	public boolean typesOfLinkedListIsDisplayed() {
		return TypesofLnkedlist.isDisplayed();
	}
	public void clickOnImplementLinkedList() {
		Implementlinkedlist.click();
	}
	public boolean implementLinkedListIsDisplayed() {
		return Implementlinkedlist.isDisplayed();
	}
	public void clickOnTraversal() {
		Traversal.click();
	}
	public boolean traversalIsDisplayed() {
		return Traversal.isDisplayed();
	}
	public void clickOnInsertion() {
		Insertion.click();
	}
	public boolean insertionIsDisplayed() {
		return Insertion.isDisplayed();
	}
	public void clickOnDeletion() {
		Deletion.click();
	}
	public boolean deletionIsDisplayed() {
		return Deletion.isDisplayed();
	}
	public void tryHere() {
		Tryhere.click();	
	}
	public boolean runButtonIsDisplayed() {
		return runbutton.isDisplayed();
	}

	public void run() {
		runbutton.click();	
	}
	public String Option(String Options) {
//		  Switch to the appropriate section
			switch (Options) {
			case "Introduction":
				clickOnIntroduction();
				break;
			case "Creating Linked LIst":
				clickOnCreatingALinkedList();
				break;
			case "Types of Linked List":
				clickOnTypesOfLinkedList();
				break;
			case "Implement Linked List in Python":
				clickOnImplementLinkedList();
				break;
			case "Traversal":
				clickOnTraversal();
				break;
			case "Insertion":
				clickOnInsertion();
				break;
			case "Deletion":
				clickOnDeletion();
				break;
			default:
				throw new IllegalArgumentException("Invalid section: " + Options);
	}
			return Options;
}
	public void practiceQuestions() {
		PracticeQuestion.click();
		
	}
}