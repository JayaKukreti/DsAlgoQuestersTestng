package dsAlgoPages;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import dsAlgoUtils.ExcelDataReader;

public class RegisterPage {

	WebDriver driver;
	List<Map<String, String>> excelData;
	ExcelDataReader exceldatareader;
	SigninPage signinpage = new SigninPage(driver);

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//Web Locators
	@FindBy(xpath = "//label[@for='id_username']")
	private WebElement Registertext;
	@FindBy(id = "id_username")
	private WebElement Username;
	@FindBy(xpath = "//input[@id='id_password']")
	private WebElement Password;
	@FindBy(xpath = "//input[@value='Register']")
	private WebElement Registerbutton;
	@FindBy(xpath = "//div[contains(text(),'password_mismatch:The two')]")
	private WebElement Passwordmismatch;
	@FindBy(linkText = "Register")
	private WebElement Registerlinktext;
	@FindBy(linkText = "Sign in")
	private WebElement Signinlinktext;
	@FindBy(xpath = "//div[contains(text(),'You are logged in')]")
	private WebElement loggedinmessage;
	@FindBy(xpath = "//div[contains(text(),'Invalid Username and Password')]")
	private WebElement error;
	@FindBy(xpath ="//div[contains(text(),'The two password fields didn’t match')]")
	private WebElement passwordmismatcherror;

// ***************************************************

	public boolean registerlinktext() {
		return Registerlinktext.isDisplayed();
	}

//***************************************************
	public boolean Signinlinktext() {
		return Signinlinktext.isDisplayed();
	}
// ***************************************************

	public String isInvalidPasswordmismatch() {
		return passwordmismatcherror.getText();
	}

// ****************************************************
	public boolean textConfirmforRegister() {
		boolean textconfirmforregister = Registertext.isDisplayed();
		return textconfirmforregister;
	}
// ****************************************************

	public void Clickregisteronregisterpage() {
		Registerbutton.click();
	}

// ************************************************************************

	public String switchToElementAndGetValidationMessage(String expectedresult) {
		// Switch to the active element to retrieve the validation message
		WebElement activeElement = driver.switchTo().activeElement();
		String actualMessage = activeElement.getAttribute("validationMessage").trim();
		// Log the validation message for debugging
		System.out.println("Validation Message: " + actualMessage);
		String normalizedActualMessage = actualMessage.replaceAll("\\.+$", "").trim();
		String normalizedExpectedMessage = expectedresult.replaceAll("\\.+$", "").trim();
		// Validate the messages
		if (normalizedActualMessage.equals(normalizedExpectedMessage)) {
			System.out.println("Validation message matched successfully!");
		} else {
			System.out.println("Validation message mismatch!");
			System.out.println("Actual: " + normalizedActualMessage);
			System.out.println("Expected: " + normalizedExpectedMessage);
		}
// Return the actual validation message
		return actualMessage;
	}

//************************************************************************
	public void enteringcode(String username, String password, String passwordconfirmation) {
		try {
			WebElement usernamecode = driver.findElement(By.xpath("//input[@type='text' and @name='username' and @id='id_username']"));
			usernamecode.clear();
			usernamecode.sendKeys(username);
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement passwordcode = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password' and @name='password1' and @id='id_password1']")));
			//WebElement passwordcode = driver.findElement(By.id("id_password"));
			passwordcode.clear();
			passwordcode.sendKeys(password);
			
			WebElement passwordconfirmcode = driver.findElement(By.xpath("//input[@type='password' and @name='password2' and @id='id_password2']"));
			passwordconfirmcode.clear();
			passwordconfirmcode.sendKeys(passwordconfirmation);
			
			
			System.out.println("Entered Username: " + username);
			System.out.println("Entered Password: " + password);
			System.out.println("Entered Password Confirmation: " + passwordconfirmation);
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}

//********************************************************

//public String credentialsResult(String username, String password, String passwordconfirmation,
//	                                String expectedResult) throws TimeoutException {
//	    String actualMessage = "";
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//	    try {
//	        if (username.isEmpty() || password.isEmpty() || passwordconfirmation.isEmpty()) {
//	            WebElement activeElement = driver.switchTo().activeElement();
//	            actualMessage = activeElement.getAttribute("validationMessage").trim();
//	            System.out.println("Validation Message (Empty Field): " + actualMessage);
//	            actualMessage = actualMessage.replaceAll("\\.+$", "").trim();
//	        } else { 
//	            // Wait for the error message to appear
//	            WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
//	                    By.xpath("//div[@class='password-error' and @role='alert']")));
//	            actualMessage = errorElement.getText();
//	            System.out.println("Error Message Displayed: " + actualMessage);
//	        }
//	    } catch (TimeoutException e) {
//	        System.out.println("Timeout: Error message not found within 10 seconds.");
//	    } catch (NoSuchElementException e) {
//	        System.out.println("Element not found: " + e.getMessage());
//	    }
//
//	    System.out.println("🔹 Actual Message Retrieved: [" + actualMessage + "]");
//	    return actualMessage;
//	}

	// Method to check if password mismatch error exists
//	private boolean isInvalidPasswordMismatch(WebDriverWait wait) {
//	    try {
//	        WebElement errorElement = wait.until(ExpectedConditions.presenceOfElementLocated(
//	                By.xpath("//div[contains(text(),'The two password fields didn’t match')]")));
//	        return errorElement.isDisplayed();
//	    } catch (TimeoutException e) {
//	        return false; // If element not found within timeout, return false
//	    }
	//}
	
	//****************************************************************************************************
	public String credentialsResult(String username, String password, String passwordconfirmation, String expectedResult) throws TimeoutException {
	    String actualMessage = "";
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    try {
	        if (username.isEmpty() || password.isEmpty() || passwordconfirmation.isEmpty()) {
	            WebElement activeElement = driver.switchTo().activeElement();
	            actualMessage = activeElement.getAttribute("validationMessage").trim();
	            System.out.println("Validation Message (Empty Field): " + actualMessage);
	            actualMessage = actualMessage.replaceAll("\\.+$", "").trim();
	        } else {
	            // Wait for the error message to appear
	            try {
	                WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                    By.xpath("//div[contains(@class, 'alert alert-primary') and contains(text(), 'The two password fields didn’t match')]")
	                ));

	                actualMessage = errorElement.getText().trim();
	                System.out.println("Error Message Displayed: " + actualMessage);

	                // Check for password mismatch error
	                if (actualMessage.contains("The two password fields didn’t match")) {
	                    actualMessage = "password_mismatch:The two password fields didn’t match.";
	                }
	            } catch (TimeoutException e) {
	                System.out.println("Timeout: Error message not found within 10 seconds.");
	            }
	        }
	    } catch (NoSuchElementException e) {
	        System.out.println("Error Element not found: " + e.getMessage());
	    }

	    System.out.println("🔹 Actual Message Retrieved: [" + actualMessage + "]");
	    return actualMessage;
	}

	
	//*********************************************************************************************************
}
