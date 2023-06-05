package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pageobjcts.SearchPage;

public class SearchTest extends Base{
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		driver=OpenUrlAndOpenBrowser();
		
	}
	@AfterMethod
	public void TearDown() {
		driver.quit();
		
	}
	@Test(priority=1)
	public void VerifySearchWithValidProduct() {
		SearchPage searchpage=new SearchPage(driver);//pagefactory design
		searchpage.entersearch();
		searchpage.clicksearch();
		
		//driver.findElement(By.name("search")).sendKeys("MacBook");
		//driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		//String actualmsg=(driver.findElement(By.linkText("MacBook"))).getText();
		String expectedmsg="MacBook";
		Assert.assertTrue(searchpage.displaystatusofmacbook(), expectedmsg);//pagefactory design
		//Assert.assertTrue(driver.findElement(By.linkText("iPhone"))).getText().isDisplayed();;
	}
	@Test(priority=2)
	
	public void VerifyWithInvalidProduct() {
		
		driver.findElement(By.name("search")).sendKeys("car");
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		String actualmsg=(driver.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criter')]"))).getText();		
		String expected="There is no product that matches the search criteria.";
		Assert.assertEquals(actualmsg, expected);
		
	}		
	
	}

