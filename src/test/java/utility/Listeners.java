package utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import testExample.BaseTest;

public class Listeners extends BaseTest implements ITestListener  {
	WebDriver driver;
ExtentReports extent=report.startReport();
ExtentTest test;
	@Override
	public void onTestStart(ITestResult result) {
		test=extent.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
		test.info("************passed ********************");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName());
	try {
		test.addScreenCaptureFromPath(Screenshot.getScreenShot(driver, result.getMethod().getMethodName()));
	} catch (IOException e) {
		
		e.printStackTrace();
	}
		}

	@Override
	public void onTestSkipped(ITestResult result) {}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {}

	@Override
	public void onStart(ITestContext context) {}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
