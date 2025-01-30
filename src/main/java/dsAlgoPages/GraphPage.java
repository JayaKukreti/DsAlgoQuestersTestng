package dsAlgoPages;

import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dsAlgoUtils.ConfigReader;

public class GraphPage {
	WebDriver driver;
	Properties prop;

	public GraphPage(WebDriver driver) {
		this.driver = driver;
		this.prop = ConfigReader.initializeProp();
		PageFactory.initElements(driver, this);

	}

	@FindBy(linkText = "Graph")
	private WebElement graphpagegraphoption;
	@FindBy(linkText = "Try here>>>")
	private WebElement Tryherebutton;
	@FindBy(linkText = "Graph Representations")
	private WebElement GraphRepresentation;
	@FindBy(xpath = "//div[contains(@class, 'CodeMirror') and contains(@class, 'cm-s-default')]")
	private WebElement tryeditorpage;
	@FindBy(xpath = "//*[@onclick='runit()']")
	private WebElement runbutton;
	@FindBy(id = "output")
	private WebElement tryeditoroutput;
	@FindBy(linkText = "Practice Questions")
	private WebElement practicequestions;
	@FindBy(xpath = "//h4[text()='Graph']")
	private WebElement Textconfirmforgraph;
	@FindBy(xpath = "//p[contains(text(),'What is a graph?')]")
	private WebElement Textconfirmforgraphmodule;
	@FindBy(xpath = "//a[text()='Data Structures']")
	private WebElement Textconfirmforpracticequestion;
	@FindBy(xpath = "//p[text()='Graph Representations']")
	private WebElement Textconfirmforgraphrepresentation;

	public void clickgraphpagegraphoption() {
		graphpagegraphoption.click();
	}

	public boolean textconfirmforgraph() {
		boolean textconfirmforgraph = Textconfirmforgraph.isDisplayed();
		return textconfirmforgraph;
	}

	public boolean textconfirmforgraphmodule() {
		boolean textconfirmforgraphmodule = Textconfirmforgraphmodule.isDisplayed();
		return textconfirmforgraphmodule;
	}

	public boolean isGraphRepresentationTextDisplayed() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement graphTextElement = wait
					.until(ExpectedConditions.visibilityOf(Textconfirmforgraphrepresentation));
			return graphTextElement.isDisplayed();
		} catch (Exception e) {
			System.err.println("Graph Representation text not found: " + e.getMessage());
			return false; // Return false if element is not visible instead of throwing an exception
		}
	}

	public void tryherebutton() {
		Tryherebutton.click();

	}

	public void Graphrepresentation() {
		GraphRepresentation.click();

	}

	public void run() {
		runbutton.click();
	}

	public boolean textconfirmfortryeditor() {
		boolean textconfirmfortryeditor = runbutton.isDisplayed();
		return textconfirmfortryeditor;
	}

	public boolean textconfirmpracticequestion() {
		boolean textconfirmforpracticequestion = Textconfirmforpracticequestion.isDisplayed();
		return textconfirmforpracticequestion;
	}

	public void clickpracticequestions() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement pq = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Practice Questions")));

		pq.click();
	}

}