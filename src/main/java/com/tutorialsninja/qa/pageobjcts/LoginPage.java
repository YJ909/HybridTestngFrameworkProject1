package com.tutorialsninja.qa.pageobjcts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	//Objects
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement emailadress;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement password;
	
	@FindBy(linkText="Login")
	private WebElement loginbutton;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

   //Actions
    public void enteremail(String emailtext) {
    	emailadress.sendKeys("emailtext");
    }
    public void enterpassword(String passwordtext) {
    	password.sendKeys("passwordtext");
    }
    public void clickbutton() {
    	loginbutton.click();
    }
}



