package com.tutorialsninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
public static ExtentReports generatereports() {
		
		ExtentReports extentreports = new ExtentReports();
		File extentrep=new File(System.getProperty("user.dir")+"\\test-output\\extentreport\\report.html");
		ExtentSparkReporter sRep = new ExtentSparkReporter(extentrep);
		
		sRep.config().setTheme(Theme.DARK);
		sRep.config().setReportName("Tutorialsninja reportname");
		sRep.config().setDocumentTitle("TN Report");
		sRep.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		extentreports.attachReporter(sRep);
		
		Properties prop =new Properties();
		File sysprop= new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
		try {
		FileInputStream fs = new FileInputStream(sysprop);
		prop.load(fs);
		}catch(Throwable e) {
		e.printStackTrace();
		}
		extentreports.setSystemInfo("Appl URL", prop.getProperty("url"));
		extentreports.setSystemInfo("Browser", prop.getProperty("browser")); 
		extentreports.setSystemInfo("Email", prop.getProperty("validemail")); 
		extentreports.setSystemInfo("Password", prop.getProperty("validpassword")); 
		extentreports.setSystemInfo("Os name",System.getProperty("os.name"));
		extentreports.setSystemInfo("java vers",System.getProperty("java.version"));
		extentreports.setSystemInfo("user nam",System.getProperty("user.name"));
		
		return extentreports;
}
}