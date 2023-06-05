package com.tutorialsninja.qa.testcases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
//import com.tutorialsninja.qa.pageobjcts.HomePage;
//import com.tutorialsninja.qa.pageobjcts.LoginPage;
import com.tutorialsninja.qa.utils.utils;

public class LoginTest extends Base {
	public LoginTest() {
	super();
	}
	//LoginPage loginpage;
	public WebDriver driver;
	@BeforeMethod
	public void setup() {
		driver=OpenUrlAndOpenBrowser();
		//HomePage homepage=new HomePage(driver);
		//homepage.selectmyaccount();
		//homepage.selectlogin();
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
	}
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
		
	
	
	@Test(priority=1,dataProvider="validdatasupplier")
	public void VerifyLoginWithValidCredentials(String email, String password) 
	{
		//LoginPage loginpage=new LoginPage(driver);//
		//as we optimizd code by givng loginpage obj in homepage and using obj ref above in line31
		//loginpage.enteremail(email);
		//loginpage.enterpassword(password);
		//loginpage.clickbutton();
	   driver.findElement(By.id("input-email")).sendKeys(email);
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Assert.assertTrue(driver.findElement(By.linkText("Change your password")).isDisplayed());
		driver.quit();//we create accountpage similar to above like page factory.
	}
	@DataProvider (name="validdatasupplier")
	public Object[][] supplytestdata(){
		Object[][] data= utils.gettestdatafromexcel("login");
		return data;
		
	}
		
	@Test(priority=2)
	public void VerifyLoginWithInValidCredentials() {
		  //LoginPage loginpage=new LoginPage(driver);//pagefactry obj
			driver.findElement(By.id("input-email")).sendKeys("practiseone@gmail.com");
			driver.findElement(By.id("input-password")).sendKeys("123456");
			driver.findElement(By.xpath("//input[@value='Login']")).click();
			//loginpage.clickbutton();// pgefactry obj
			String actualmsg=(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"))).getText();
			String expected="Warning: No match for E-Mail Address and/or Password";
			
			Assert.assertTrue(actualmsg.contains(expected),"Warning: No match for E-Mail Address and/or Password is not there");
			
		}
}			
			
		



		
		
		
		
		
		
		
				
		
	
		
	
	


