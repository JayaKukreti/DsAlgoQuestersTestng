package dsAlgoPages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@class='btn']")
	private WebElement launchPageGetstartedbutton;
	@FindBy(xpath = "//h5[text()='Array']")
	private WebElement textdisplayofhompage;
	@FindBy(xpath = "//a[text()='Sign in']")
	private WebElement signin;
	@FindBy(linkText = "Register")
	private WebElement Register;
	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	private WebElement DataStructuresDropDown;
	@FindBy(xpath = "//*[@href='graph']")
	private WebElement GetStartedofGraph;
	@FindBy(xpath = "//a[@href='data-structures-introduction']")
	private WebElement getstartedofdatastructureintroduction;
	@FindBy(xpath = "//a[@href='array']")
	private WebElement getstartedArray;
	@FindBy(xpath = "//a[@href='linked-list']")
	private WebElement getstartedLinkedlist;
	@FindBy(xpath = "//a[@href='stack']")
	private WebElement getstartedStack;
	@FindBy(xpath = "//a[@href='queue']")
	private WebElement getstartedQueue;
	@FindBy(xpath = "//a[@href='tree']")
	private WebElement getstartedTree;
	@FindBy(xpath = "//div[@role='alert']")
	private WebElement errormessage;
	@FindBy(linkText = "Arrays")
	private WebElement Arrays;
	@FindBy(linkText = "Linked List")
	private WebElement LinkedList;
	@FindBy(linkText = "Stack")
	private WebElement Stack;
	@FindBy(linkText = "Queue")
	private WebElement Queue;
	@FindBy(linkText = "Tree")
	private WebElement Tree;
	@FindBy(linkText = "Graph")
	private WebElement Graph;

	public void clickLaunchPageGetstartedbutton() {
		launchPageGetstartedbutton.click();
	}

	public boolean textdisplayinhomepage() {
		boolean getarraytextinhomepage = textdisplayofhompage.isDisplayed();
		return getarraytextinhomepage;
	}

	public void clickSignin() {
		signin.click();
	}

	public void clickRegister() {
		Register.click();

	}

	public void clickDataStructuresDropDown() {
		DataStructuresDropDown.click();

	}

	public String errorMessageGetStarted() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement errorMessageElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']")));
		String actualMessage = errorMessageElement.getText();
		System.out.println(actualMessage);
		return actualMessage;
	}

	public String expectedmessage() {
		return errormessage.getText();
	}

	public WebElement getStartedofGraph() {
		GetStartedofGraph.click();
		return GetStartedofGraph;
	}

	public void getStartedDataStructureIntroduction() {
		getstartedofdatastructureintroduction.click();
	}

	public void getStartedArray() {
		getstartedArray.click();

	}

	public void getStartedLinkedlist() {
		getstartedLinkedlist.click();

	}

	public void getStartedStack() {
		getstartedStack.click();

	}

	public void getStartedQueue() {
		getstartedQueue.click();
	}

	public void getStartedTree() {
		getstartedTree.click();
	}

	public void arrays() {
		Arrays.click();

	}

	public void linkedList() {
		LinkedList.click();
	}

	public void stack() {
		Stack.click();
	}

	public void queue() {
		Queue.click();
	}

	public void tree() {
		Tree.click();
	}

	public void graph() {
		Graph.click();
	}
}