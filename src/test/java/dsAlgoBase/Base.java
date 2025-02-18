package dsAlgoBase;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import dsAlgoDriverFactory.DriverFactory;
import dsAlgoUtils.ConfigReader;

public class Base {
	public WebDriver driver;

	private DriverFactory driverFactory = new DriverFactory();
	private static Properties prop1;

	@BeforeSuite(alwaysRun = true)
	public void setupSuite() {
		prop1 = ConfigReader.initializeprop();
		System.out.println("Before Suite: Config properties initialized.");
	}

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void setup(@Optional("") String browser) {
		try {
			System.out.println("Browser received from testng.xml: " + browser);

			if (browser == null || browser.trim().isEmpty()) {
				browser = prop1.getProperty("browser");
				System.out.println("Using default browser from properties: " + browser);
			}

			driverFactory.initializeBrowser(browser);
			driver = DriverFactory.getDriver();

			driver.manage().deleteAllCookies();
			driver.get(prop1.getProperty("URL"));
		} catch (Exception e) {
			System.out.println("Error in setup(): " + e.getMessage());
			throw e;
		}

	}

	@AfterMethod(alwaysRun = true)
	public void tearDownTest(ITestResult result) {
		driver = DriverFactory.getDriver();
		driver.quit();
		DriverFactory.removeDriver();

	}

	public static WebDriver getDriver() {
		WebDriver driver = DriverFactory.getDriver();
		if (driver == null) {
			throw new IllegalStateException("WebDriver instance is null. Ensure setup() is called before tests.");
		}
		return driver;
	}

}
