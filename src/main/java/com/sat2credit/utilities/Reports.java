package com.sat2credit.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reports extends BaseClass implements ITestListener {

	public ExtentReports extent;
	public ExtentSparkReporter spark;
	public ExtentTest test;
	
	@Override
	public void onStart(ITestContext testContext) {
		
		// Specify the date time format here.
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss").format(new Date());
		String repName = "Test Report - " + timeStamp + ".html";
		
		// Specify the report of the location here.
		spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/" + repName);
		
		// here XML file..
		try {
			spark.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		extent = new ExtentReports();
		extent.attachReporter(spark);
		
		extent.setSystemInfo("Host Name", "Local Host");
		extent.setSystemInfo("Project Name", "Sat2Credit WebApplication");
		extent.setSystemInfo("OS", "Windows 10 Home");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Test Engineer", "Vamsi Krishna T");
		
		// Specify the title of the report.
		spark.config().setDocumentTitle("Sat2Credit Web Test Results");
		
		// Specify the name of the name of the Report.
		spark.config().setReportName("Functional Test Results");	
		
		// Specify theme of the report.
		spark.config().setTheme(Theme.STANDARD);
		
		// Specify the time line of the report.
		spark.config().setTimelineEnabled(true);
	}
	
	@Override
	public void onTestSuccess(ITestResult tr) {
		
		// Create new entry in the report.
		test = extent.createTest(tr.getName()).createNode("Passed");
		
		// send the passed information.
		test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		
		// if any test case has screenshot and it can be added here.
		String path=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		
		File file=new File(path);
		if(file.exists()) {
			test.pass("Verification Screenshot is below :- " + test.addScreenCaptureFromPath(path));
		}
		
	}
	
	@Override
	public void onTestFailure(ITestResult tr) {
		
		// Create new entry in the report.
		test = extent.createTest(tr.getName()).createNode("Failed");
		
		// Send the failed information.
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		// To get throwable exception.
		test.log(Status.FAIL, "Test Case Failed is "+tr.getThrowable());
		
		// To draw a line around the element
		
		
		// Specify the screenshot location.
/*		WebDriver driver=null;
		
		try {
			driver =(WebDriver)tr.getTestClass().getRealClass().getDeclaredField("driver").get(tr.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e1) {
			
			e1.printStackTrace();
		}*/
		
		String path;
		try {
			path = getScreenShot(tr.getMethod().getMethodName(), driver);
		
			File file = new File(path);
			if(file.exists()) {
				test.fail("Screenshot is below :- " + test.addScreenCaptureFromPath(path));
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	@Override
	public void onTestSkipped(ITestResult tr) {
		
		// Create new entry in the report.
		test = extent.createTest(tr.getName()).createNode("Skipped");
		
		// Send the  skipped information.
		test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}
	
	@Override
	public void onFinish(ITestContext testContext) {
		
		extent.flush();
	}
}
