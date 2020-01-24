package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'User: Yamini S')]")
	WebElement usernameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")///following-sibling::ul/li/a")
	WebElement newContactLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement DealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement TasksLink;
	
	//Intializing the page objects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyUserName() {
		return usernameLabel.isDisplayed();
	}
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		DealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink() {
		TasksLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactLink() {
		Actions action=new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
	}

}
