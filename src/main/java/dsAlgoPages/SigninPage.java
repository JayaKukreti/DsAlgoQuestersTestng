package dsAlgoPages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dsAlgoUtils.ConfigReader;
import dsAlgoUtils.ExcelDataReaderArrayLinkedlist;

public class SigninPage {
	WebDriver driver;
	Properties prop;
	List<String> actualresults = new ArrayList<>();

	List<Map<String, String>> excelData;
	ExcelDataReaderArrayLinkedlist exceldatareader;

	public SigninPage(WebDriver driver) {
		this.driver = driver;
		this.prop = ConfigReader.initializeProp();
		PageFactory.initElements(driver, this);
	}

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

	

	public String errormessage() {
		return error.getText();
	}

	public String loggedinmessage() {
		return loggedinmessage.getText();

	}

	public String switchToElementAndGetValidationMessage() {
		// Switch to the active element to retrieve the validation message
		WebElement activeElement = driver.switchTo().activeElement();
		String actualMessage = activeElement.getAttribute("validationMessage").trim();

		// Log the validation message for debugging
		System.out.println("Validation Message: " + actualMessage);

		 actualMessage.replaceAll("\\.+$", "").trim();

		return actualMessage;

	}
	public void signout() {
		Signout.click();
	}
	public String loggedoutmessage() {
	return	Loggedoutmessage.getText();
	}

}