package com.tutorialsninja.qa.pageobjcts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	WebDriver driver;
	//Object
	@FindBy(name="search")
	private WebElement searchbox;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	private WebElement searchbutton;
	
	@FindBy(linkText="MacBook")
	private WebElement validproduct;
	
	public SearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	//Actions
	public void entersearch() {
		searchbox.sendKeys("MacBook");
    }
	public void clicksearch() {
		searchbutton.click();
    }
	public boolean displaystatusofmacbook() {//this is for assertion condition
		boolean display=validproduct.isDisplayed();
		return display; 
    }
	

}
