package dsAlgoListeners;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.chaintest.plugins.ChainTestListener;

import dsAlgoBase.Base;

public class Listeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName() + " started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName() + " success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println(result.getName() + " failed");

		WebDriver driver = Base.getDriver(); // Fetch WebDriver from Hooks

		if (driver != null) {
			try {
				File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				ChainTestListener.embed(screenshotFile, "image/png");

				// Define screenshot folder path dynamically
				String screenshotDir = "src/test/resources/listenersTestFailScreenshots/Screenshots";
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
		System.out.println(result.getName() + " skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Tests executions started");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Tests executions completed");
	}
}
