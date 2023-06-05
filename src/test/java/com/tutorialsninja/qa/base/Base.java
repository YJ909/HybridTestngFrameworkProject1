package com.tutorialsninja.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

import com.tutorialsninja.qa.utils.utils;

//import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Base {
	WebDriver driver;
	public Properties prop;
	
	public Base() {
		prop=new Properties();
		File propfile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
		try {
		FileInputStream fis= new FileInputStream(propfile);
		prop.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		}
		
		
	public  WebDriver OpenUrlAndOpenBrowser() {
	   // driver=new FirefoxDriver();
	 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(utils.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(utils.PAGELOAD_WAIT_TIME));
		driver.get(prop.getProperty("url"));
		
		return driver;
		
		
		
	}

}
