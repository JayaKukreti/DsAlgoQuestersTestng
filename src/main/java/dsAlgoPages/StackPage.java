package dsAlgoPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StackPage {
	WebDriver driver;

	public StackPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[text()='Try here>>>']")
	private WebElement Tryhere;
	@FindBy(xpath = "//a[@href='operations-in-stack']")
	private WebElement Operationsinstack;
	@FindBy(linkText = "Implementation")
	private WebElement Implementation;
	@FindBy(linkText = "Applications")
	private WebElement Applications;
	@FindBy(xpath = "//h4[text()='Stack']")
	private WebElement Textconfirnforstack;
	@FindBy(xpath = "//*[@onclick='runit()']")
	private WebElement runbutton;
	@FindBy(xpath = "//p[contains(text(),'Operations in Stack')]")
	private WebElement Textconfirmforoperationsinstack;
	@FindBy(xpath = "//p[contains(text(),'Implementation')]")
	private WebElement textconfirmofimplementation;
	@FindBy(xpath = "//p[contains(text(),'Applications')]")
	private WebElement textconfirmforApplications;
	@FindBy(linkText = "Practice Questions")
	private WebElement practicequestions;
	@FindBy(xpath = "//a[text()='Data Structures']")
	private WebElement Textconfirmforpracticequestion;

	public void tryHere() {
		Tryhere.click();
	}

	public void operationsinstack() {
		Operationsinstack.click();
	}

	public void implementation() {
		Implementation.click();
	}

	public void applications() {
		Applications.click();
	}

	public boolean textconfirmforstack() {
		boolean textconfirnforstack = Textconfirnforstack.isDisplayed();
		return textconfirnforstack;

	}

	public boolean textconfirmfortryeditor() {
		boolean textconfirmfortryeditor = runbutton.isDisplayed();
		return textconfirmfortryeditor;
	}

	public boolean textConfirmForOperationsInStack() {
		boolean textconfirmforoperationsinstack = Textconfirmforoperationsinstack.isDisplayed();
		return textconfirmforoperationsinstack;
	}

	public boolean textConfirmOfImplementation() {
		boolean Textconfirmofimplementation = textconfirmofimplementation.isDisplayed();
		return Textconfirmofimplementation;

	}

	public boolean textConfirmForApplications() {
		boolean TextconfirmforApplications = textconfirmforApplications.isDisplayed();
		return TextconfirmforApplications;

	}

	public void runButton() {
		runbutton.click();
	}

	public void clickpracticequestions() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement pq = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Practice Questions")));

		pq.click();
	}

	public boolean textconfirmpracticequestion() {
		boolean textconfirmforpracticequestion = Textconfirmforpracticequestion.isDisplayed();
		return textconfirmforpracticequestion;
	}

}