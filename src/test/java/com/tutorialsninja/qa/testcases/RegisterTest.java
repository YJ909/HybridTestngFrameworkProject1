package com.tutorialsninja.qa.testcases;

//import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pageobjcts.HomePage;
import com.tutorialsninja.qa.utils.utils;

public class RegisterTest extends Base {
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver=OpenUrlAndOpenBrowser();
		HomePage homepage=new HomePage(driver);
		homepage.selectmyaccount();
		homepage.selectregister();
		//driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		//driver.findElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")).click();
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
	@Test
	
	public void RegisterWithValidCredentials() {
		
		driver.findElement(By.id("input-firstname")).sendKeys("practise1");
        driver.findElement(By.id("input-lastname")).sendKeys("two");
        driver.findElement(By.id("input-email")).sendKeys(utils.generatetimestamp());
        driver.findElement(By.id("input-telephone")).sendKeys("123412345");
        driver.findElement(By.id("input-password")).sendKeys("123456");
        driver.findElement(By.id("input-confirm")).sendKeys("123456");
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
       String actualmsg=(driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"))).getText();
       String expected=("Your Account Has Been Created!");
       Assert.assertEquals(actualmsg, expected, "account page not displayed");
       
       
	}
      @Test
      
	public void RegisterWithValidExistingCredentials() {
		
        driver.findElement(By.id("input-firstname")).sendKeys("practise1");
        driver.findElement(By.id("input-lastname")).sendKeys("two");
        driver.findElement(By.id("input-email")).sendKeys("practise1two@gmail.com");
        driver.findElement(By.id("input-telephone")).sendKeys("123412345");
        driver.findElement(By.id("input-password")).sendKeys("123456");
        driver.findElement(By.id("input-confirm")).sendKeys("123456");
        driver.findElement(By.name("agree")).click();
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
       String actualmsg=(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"))).getText();
       String expected=("Warning: E-Mail Address is already registered!");
       Assert.assertEquals(actualmsg, expected, "account page not displayed");
      }
}
           
        
        
		
		
	


