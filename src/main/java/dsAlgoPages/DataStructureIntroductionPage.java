package dsAlgoPages;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

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

import dsAlgoUtils.ConfigReader;

public class DataStructureIntroductionPage {
	private WebDriver driver;
	private Properties prop;

	public DataStructureIntroductionPage(WebDriver driver) {
		this.driver = driver;
		this.prop = ConfigReader.initializeprop();
		PageFactory.initElements(driver, this);
	}

//Web Locators	
  @FindBy(xpath ="//a[contains(@href, 'time-complexity')]")
	private WebElement timeComplexityLink ;
    @FindBy(xpath ="//h4[@class='bg-secondary text-white' and contains(text(), 'Data Structures-Introduction')]")
	  private WebElement textdisplayinDataStructurePage;
	@FindBy(xpath ="//p[@class='bg-secondary text-white' and text()='Time Complexity']")
	 private WebElement textdisplayinTimeComplexityPage;
	@FindBy(xpath = "//a[@href='/tryEditor']")
     private WebElement TryHereButton;
    @FindBy(xpath ="//a[@href=\"/tryEditor\"]")
    private WebElement btn_tryEditor;
    @FindBy(xpath ="//textarea[@tabindex='0']")
	private WebElement textArea ;
	@FindBy(xpath ="//button[text()='Run']")
	private WebElement runBtn ;
	@FindBy(xpath ="//*[@id='output']")
	private WebElement outputText;
	@FindBy(linkText = "Practice Questions")
	private WebElement practicequestions;
	@FindBy(xpath = "//a[text()='Data Structures']")
	private WebElement Textconfirmforpracticequestion;
	@FindBy(xpath = "//*[@onclick='runit()']")
	private WebElement runbutton;
	
	
	// *********************************************************
	public boolean textconfirmfortryeditor() {
		boolean textconfirmfortryeditor = runbutton.isDisplayed();
		return textconfirmfortryeditor;
	}
	
	// *********************************************************
	public void clickpracticequestions() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement pq = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Practice Questions")));
		pq.click();
	}

	// *********************************************************
	public boolean textconfirmpracticequestion() {
		boolean textconfirmforpracticequestion = Textconfirmforpracticequestion.isDisplayed();
		return textconfirmforpracticequestion;
	}

	// *********************************************************
	public boolean isTextDisplayedInDataStructurePage() {
		
			return textdisplayinDataStructurePage.isDisplayed();
		
	}

//*********************************************************	
	public boolean isTextDisplayedInTimeComplexityPage() {
		
			return textdisplayinTimeComplexityPage.isDisplayed();
			
			
		
	}
//*********************************************************

	public void ClickTryHereButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement TryHereButtonElement = wait.until(ExpectedConditions.elementToBeClickable(TryHereButton));
		TryHereButton.click();
		System.out.println("Navigated to try Editor with a Run button to test");
	}
	// *********************************************************

	public void ClickTimeComplexityLink() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement timeComplexityLinkElement = wait.until(ExpectedConditions.elementToBeClickable(timeComplexityLink));
		timeComplexityLink.click();
		System.out.println("Navigated to the Time Complexity page.");
	}

	// *********************************************************
	public String getDataStructureModuleUrl() {
		return prop.getProperty("DataStructureURL");
	}
	// *********************************************************

	public String actualUrl() {
		return driver.getCurrentUrl();
	}
	// *****************************************************

	public void enter_input(String code) {

		Actions actions = new Actions(driver);
		WebElement textEditor =textArea;
		actions.moveToElement(textEditor).click().sendKeys(code).build().perform();
	}
	// *****************************************************

	public void click_run() {
		runBtn.click();
	}
	// *****************************************************

	public void click_tryEditor() {
		try {
			By tryeditor = By.xpath("//a[@href='/tryEditor']");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			Actions act = new Actions(driver);
			act.moveToElement(driver.findElement(tryeditor)).perform();
			driver.findElement(tryeditor).click();
		} catch (Exception e) {
			System.out.println("Element not found or not clickable: " + e.getMessage());
		}
		// LoggerLoad.info("Clicking the try editor link of array page");

	}
	// *****************************************************

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}
	// *****************************************************

	public void capture_alert() {
		Alert alert = driver.switchTo().alert(); // switch to alert

		String alertMessage = driver.switchTo().alert().getText(); // capture alert message
		System.out.println(alertMessage); // Print Alert Message
	}
	// *****************************************************

	public String get_outputText() {

		String consoleOutput = outputText.getText();
		return consoleOutput;
	}
}
// *****************************************************
