package com.tutorialsninja.qa.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialsninja.qa.utils.ExtentReport;



public class MyListeners implements ITestListener{
	ExtentReports extentreport;
	ExtentTest extentreports;
	String testname;
	
	@Override
	public void onStart(ITestContext context) {
		//System.out.println("Execution of project test started");//previous bfre extent reports.
		extentreport = ExtentReport.generatereports();//classname.method(),it will generate 'obj'(extentreport) of class 
		//hover mouse n create local var(ExtentReports)
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		 testname=result.getName();
		 extentreports = extentreport.createTest(testname);//instead of testname we cn write"result.getName()"
		extentreports.log(Status.INFO,testname+"started execution");
		//System.out.println(testname+"started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//String testname=result.getName();
		extentreports.log(Status.PASS,testname+"passed");
		//System.out.println(testname+"success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//String testname=result.getName();
		//System.out.println("screenshottaken");
		WebDriver driver=null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File srcScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationscrnshotpath=System.getProperty("user.dir"+"\\screenshots\\"+testname+".png");
		try {
			FileHandler.copy(srcScreenShot,new File(destinationscrnshotpath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		extentreports.addScreenCaptureFromPath(destinationscrnshotpath);
		extentreports.log(Status.INFO,result.getThrowable());
		extentreports.log(Status.FAIL,testname+"failed" );
		
		//System.out.println(result.getThrowable());
		//System.out.println(testname+"failed");
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		//String testname=result.getName();
		extentreports.log(Status.INFO,result.getThrowable());
		extentreports.log(Status.SKIP,testname+"skipped" );
		//System.out.println(testname+"skipped");
		//System.out.println(result.getThrowable());
	}

	@Override
	public void onFinish(ITestContext context) {
		//System.out.println("finished");
		extentreport.flush();
		String pathofextentreport=System.getProperty("user.dir")+"\\test-output\\extentreport\\report.html";
		File rep=new File(pathofextentreport);
		try {
			Desktop.getDesktop().browse(rep.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
	}

}
