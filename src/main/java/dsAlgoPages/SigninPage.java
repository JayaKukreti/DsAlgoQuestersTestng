package dsAlgoPages;

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
import org.openqa.selenium.support.ui.Wait;

import dsAlgoUtils.ConfigReader;
import dsAlgoUtils.ExcelDataReader;

public class SigninPage {
	WebDriver driver;
	Properties prop;
	List<String> actualresults = new ArrayList<>();

	List<Map<String, String>> excelData;
	ExcelDataReader exceldatareader;

	public SigninPage(WebDriver driver) {
		this.driver = driver;
		this.prop = ConfigReader.initializeProp();
		PageFactory.initElements(driver, this);
	}
	

	
	@FindBy(xpath="//a[@href='/login']")
	private WebElement Signinlink;

	@FindBy(id = "id_username")
	private WebElement username;
	@FindBy(id = "id_password")
	private WebElement password;
	@FindBy(xpath = "//*[@value='Login']")
	private WebElement Loginbutton;
	@FindBy(xpath = "//label[@for='id_username']")
	private WebElement Registertext;

	@FindBy(xpath = "//div[contains(text(),'Invalid Username and Password')]")
	private WebElement error;
	@FindBy(xpath = "//div[contains(text(),'You are logged in')]")
	private WebElement loggedinmessage;
	@FindBy(xpath = "//label[text()='Username:']")
	private WebElement Confirmtextsignin;
	@FindBy(linkText="Sign out")
	private WebElement Signout;
	@FindBy(xpath="//div[contains(text(),'Logged out')]")
	private WebElement Loggedoutmessage;

	

	@FindBy(xpath="//a[contains(text(),'Sign out')]")
	private WebElement signOutLink;

	public void clickSignin() {
		Signinlink.click();
	}
	
	public void clickSignOut() {
        signOutLink.click();
    }



	public boolean textConfirmforRegister() {
		boolean textconfirmforregister = Registertext.isDisplayed();
		return textconfirmforregister;

	}

	public boolean confirmtextsignin() {
		return Confirmtextsignin.isDisplayed();
	}

	public void sendtextusername() {

		username.sendKeys(prop.getProperty("username"));
	}

	public void sendtextpassword() {
		password.sendKeys(prop.getProperty("password"));
	}

	public void clickLoginbutton() {
		Loginbutton.click();
	}

//	public void enterusernametxtbox(String username) {
//		 username.sendKeys(username);
//	}

	public String errormessage() {
		return error.getText();
	}

	public String loggedinmessage() {
		return loggedinmessage.getText();

	}

//public String switchToElementAndGetValidationMessage() {
//		// Switch to the active element to retrieve the validation message
//	WebElement activeElement = driver.switchTo().activeElement();
//		String actualMessage = activeElement.getAttribute("validationMessage").trim();
//
//		// Log the validation message for debugging
//		System.out.println("Validation Message: " + actualMessage);
//
//		 actualMessage.replaceAll("\\.+$", "").trim();
//
//		return actualMessage;
//
//	}

public String switchToElementAndGetValidationMessage() {
    try {
        // Switch to the active element (usually the input field with validation)
        WebElement activeElement = driver.switchTo().activeElement();

        // Ensure the element is present before proceeding
        if (activeElement == null) {
            System.out.println("No active element found.");
            return "No validation message available";
        }

        // Get validation message
        String actualMessage = activeElement.getAttribute("validationMessage");

        // Check for null value
        if (actualMessage == null || actualMessage.isEmpty()) {
            System.out.println("Validation message is empty or not present.");
            return "No validation message available";
        }

        // Log the validation message for debugging
        System.out.println("Validation Message: " + actualMessage.trim());

        return actualMessage.trim();
    } catch (Exception e) {
        System.out.println("Error retrieving validation message: " + e.getMessage());
        return "No validation message available"; // Prevents test failure due to NullPointerException
    }
}
	public void signout() {
		Signout.click();
	}
	public String loggedoutmessage() {
	return	Loggedoutmessage.getText();
	}
	

//	public void enteringcode(String Sheetname, int rowNumber) {
//		try {
//
//			ExcelDataReader ExcelDataReader = new ExcelDataReader();
//			excelData = ExcelDataReader.DataFromExcel(Sheetname);
//			String username = excelData.get(rowNumber).get("username");
//			String password = excelData.get(rowNumber).get("password");
//
//			System.out.println("excel data" + excelData);
//			System.out.println("codetorun: " + username);
//			System.out.println("codetorun: " + password);
//
//			WebElement usernamecode = driver.findElement(By.id("id_username"));
//
//			usernamecode.sendKeys(username);
//
//			WebElement passwordcode = driver.findElement(By.id("id_password"));
//
//			passwordcode.sendKeys(password);
//
//		} catch (Exception e) {
//			System.out.println("exception: " + e);
//		}
//	}

	
	
	 public void enterUsernameTxtBox(String username) {
	        WebElement usernameField = driver.findElement(By.id("id_username")); // Locate the username field
	        usernameField.sendKeys(username);

}
	 
		
	 public void enterPasswordTxtBox(String password) {
	        WebElement passwordField = driver.findElement(By.id("id_password")); // Locate the username field
	        passwordField.sendKeys(password);

}
}
	 
	 
	 
