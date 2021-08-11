package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import generics.BaseClass;

public class Screenshot implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		TakesScreenshot screenshot = (TakesScreenshot) BaseClass.driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		String testName = result.getName();
		String param = result.getParameters()[0].toString();
		File destination = new File("./failure screenshots/"+testName+"/"+param+".png");
		try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
	}
	

}
