package listener;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import utilities.ExtentReporter;


//create listener class and implements overrided methods of listener class through souce tab in eclispe
//write listener related codes for logintest class
//use flush statement at the end

public class Lstner extends Base implements ITestListener {
	ExtentReports extentReport = ExtentReporter.getExtentReport();
	ExtentTest extentTest;
	//adding this line for thread safe parallel test execution
	ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();
	

	@Override
	public void onTestStart(ITestResult result) {
		String testName = result.getTestName();
		
		extentTest = extentReport.createTest(testName+"execution started");
		//adding extentTest inside extentTestThread.set()
		extentTestThread.set(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName = result.getTestName();
		//extentTest.log(Status.PASS,testName+ "Test successful"); adding extentTestThread.get()
	    extentTestThread.get().log(Status.PASS,"Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String testName = result.getTestName();
		//extentTest.fail(result.getThrowable()); adding extentTestThread.get()
		extentTestThread.get().fail(result.getThrowable());
		
		WebDriver driver = null;
	testName = result.getTestName();
	
	try {
		driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		String screenshotFilePath = takeScreenshot(testName, driver);
		extentTestThread.get().addScreenCaptureFromPath(screenshotFilePath, testName);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {


	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extentReport.flush();
	
	}
	


}
