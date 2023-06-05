package com.tutorialsninja.qa.pageobjcts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	//Objects: these are called objs.
	@FindBy(xpath="//span[normalize-space()='My Account']")
	private WebElement myaccountdropmenu;
	
	@FindBy(linkText="Login")
	private WebElement loginoption;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']")
	private WebElement Registeroption;
	
	public HomePage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);//this is POM or PODesignPattern, will avoid "stale element exception". and in login class when
	//when homepage object is called it comes to this constructor and it will initialize elements n add
	//them to locators to execute.
	}
	
	//Action: for each object we write actions for them inform of methods
	
	public void selectmyaccount() {
	myaccountdropmenu.click();
	}
	public void selectlogin() {
		loginoption.click();
		//return new LoginPage(driver);
	}
	public void selectregister() {
		Registeroption.click();
	}
	
}
