package dsAlgoPages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dsAlgoUtils.ConfigReader;

public class TryEditorForArraysPracticeQuestions {

	WebDriver driver;
	Properties prop;
	String actualResult;
	List<String> actualresults = new ArrayList<>();

	public TryEditorForArraysPracticeQuestions(WebDriver driver) {
		this.driver = driver;
		this.prop = ConfigReader.initializeprop();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()='Run']")
	private WebElement runButton;

	@FindBy(id = "output")
	private WebElement tryEditorOutput;

	public void clickRunButton() {
		runButton.click();
	}
	    public void enteringCodeForArray(String code) {
	        try {
	            WebElement codeMirrorDiv = driver.findElement(By.xpath("//div[contains(@class, 'CodeMirror')]"));
	            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	
	            // Use JavaScript to set the value inside CodeMirror
	            jsExecutor.executeScript("arguments[0].CodeMirror.setValue(arguments[1]);", codeMirrorDiv, code);
	            //    enterCodePractice(code, codeMirror);
	        } catch (Exception e) {
	            System.out.println("Exception while entering code: " + e.getMessage());
	        }
	    }


	public String getOutput() {
		try {
			// Check for alert (error case)
			Alert alert = driver.switchTo().alert();
			actualResult = alert.getText();
			System.out.println("Alert message (invalid code): " + actualResult);
			alert.accept(); // Dismiss the alert
		} catch (NoAlertPresentException e) {
			// If no alert, get output from editor after waiting
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
			wait.until(ExpectedConditions.visibilityOf(tryEditorOutput));
			actualResult = tryEditorOutput.getText().trim();
			System.out.println("Actual result (valid code): " + actualResult);
		}
		return actualResult;
	}

	public void enterCodePractice(String code, WebElement element) {
		new Actions(driver).keyDown(Keys.CONTROL).keyUp(Keys.CONTROL).perform();

		String[] lines = code.split("\n");
		for (String line : lines) {
			if (line.equalsIgnoreCase("\\b")) {
				element.sendKeys(Keys.BACK_SPACE);
			} else {
				element.sendKeys(line);
				element.sendKeys(Keys.RETURN);
			}
		}
	}
}
