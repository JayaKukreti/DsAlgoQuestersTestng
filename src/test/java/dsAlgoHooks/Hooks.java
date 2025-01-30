package dsAlgoHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import dsAlgoBase.Base;
import dsAlgoUtils.ConfigReader;

public class Hooks {

	private static WebDriver driver;
	private static Base driverFactory = new Base();
	private static Properties prop1;

	@BeforeSuite
	public void setupSuite() {
		prop1 = ConfigReader.initializeProp();
		System.out.println("Before Suite: Config properties initialized.");
	}

	@BeforeMethod
	@Parameters("browser")
	public void before(@Optional("") String browser) { // Optional allows empty/missing values
		System.out.println("Browser received from testng.xml: " + browser);

		// If browser is empty or null, use the value from config.properties
		if (browser == null || browser.trim().isEmpty()) {
			browser = prop1.getProperty("browser");
			System.out.println("Using default browser from properties: " + browser);
		}

		driver = driverFactory.initializeBrowser(browser);
		driver.get(prop1.getProperty("URL"));
	}

	@AfterMethod
	public void tearDownTest(ITestResult result) {
	    if (result.getStatus() == ITestResult.FAILURE && driver instanceof TakesScreenshot) {
	        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	        
	    }
	    if (driver != null) {
	        driver.quit();
	        driverFactory.removeDriver();
	    }
	}
	@AfterSuite
	public void tearDownSuite() {
		System.out.println("After Suite: Cleanup completed.");
	}

	public static WebDriver getDriver() {
		return driver;
	}

}
