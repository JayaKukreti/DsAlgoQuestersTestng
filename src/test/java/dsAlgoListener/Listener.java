package dsAlgoListener;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import dsAlgoHooks.Hooks;

public class Listener implements ITestListener {
//Triggered 
	@Override
	public void onTestStart(ITestResult result) {
		String testName=result.getName();
		System.out.println(testName+ " started");
		
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName=result.getName();
		System.out.println(testName+ "Success");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		 
		        System.out.println(result.getName() + " failed");

		        WebDriver driver = Hooks.getDriver(); // Fetch WebDriver from Hooks

		        if (driver != null) {
		            try {
		                File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		                // Define screenshot folder path dynamically
		                String screenshotDir = "src/test/resources/listnersTestFailScreenshots/Screenshots";
		                File screenshotFolder = new File(screenshotDir);

		                // Ensure the directory exists
		                if (!screenshotFolder.exists()) {
		                    screenshotFolder.mkdirs();
		                }

		                // Define file path
		                String filePath = screenshotDir + "/" + result.getName() + ".png";

		                // Save the screenshot
		                FileUtils.copyFile(screenshotFile, new File(filePath));
		                System.out.println("Screenshot saved at: " + filePath);
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        } else {
		            System.out.println("Driver is null, screenshot not taken.");
		        }
		    }
		
				

	@Override
	public void onTestSkipped(ITestResult result) {
		String testName=result.getName();
		System.out.println(testName+ "Skipped");
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		System.out.println("All the test execution started");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("All the test execution finished");	
		
	}

}
