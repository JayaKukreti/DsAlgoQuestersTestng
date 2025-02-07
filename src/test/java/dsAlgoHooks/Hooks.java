package dsAlgoHooks;


import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import dsAlgoBase.Base;
import dsAlgoUtils.ConfigReader;


public class Hooks {

public WebDriver driver;


private Base driverFactory = new Base();

private static Properties prop1;


@BeforeSuite

public void setupSuite() {

prop1 = ConfigReader.initializeprop();

System.out.println("Before Suite: Config properties initialized.");

}


@BeforeMethod

@Parameters("browser")

public void setup(@Optional("") String browser) {

try {

System.out.println("Browser received from testng.xml: " + browser);


if (browser == null || browser.trim().isEmpty()) {

browser = prop1.getProperty("browser");

System.out.println("Using default browser from properties: " + browser);

}


driverFactory.initializeBrowser(browser);

driver = Base.getDriver();
Assert.assertNotNull(driver, "WebDriver is null! Initialization failed.");


driver.manage().deleteAllCookies();

driver.get(prop1.getProperty("URL"));

} catch (Exception e) {

System.err.println("Error in setup(): " + e.getMessage());

throw e;

}

}


@AfterMethod

public void tearDownTest(ITestResult result) {

try {

driver = Base.getDriver();

if (driver != null) {

if (result.getStatus() == ITestResult.FAILURE && driver instanceof
TakesScreenshot) {

byte[] screenshot = ((TakesScreenshot)
driver).getScreenshotAs(OutputType.BYTES);

System.out.println("Captured screenshot on failure.");

}


driver.quit();

Base.removeDriver();

}

System.out.println("Browser closed after test execution.");

} catch (Exception e) {

System.err.println("Error in tearDownTest(): " + e.getMessage());

throw e;

}

}


public static WebDriver getDriver() {

return Base.getDriver();

}

}

