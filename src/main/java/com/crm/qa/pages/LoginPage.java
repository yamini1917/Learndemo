package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	//Page Factory - Object Repository
	
	@FindBy(xpath="//a[@href='https://ui.freecrm.com']")
	WebElement loginclick;
	
	@FindBy(xpath="//a[text()='Classic CRM']")
	WebElement clickcrm;
	
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement clicksignup;
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement logbtn;
	
	@FindBy(xpath="//img[@class='img-responsive']")
	WebElement logo;
	
	//Intilization of all object repositories
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();		
	}
	
	public boolean validateCRMLogo() {
		loginclick.click();
		clickcrm.click();
		return logo.isDisplayed();
	}
	
	public HomePage login(String un,String pwd) {
		loginclick.click();
		clickcrm.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		logbtn.click();
		
		return new HomePage();
	}

}
