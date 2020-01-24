package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactLabel;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveButton;
	
//	@FindBy(xpath="//a[contains(text(),'test test')]//parent::td//preceding-sibling::td//input[@name='contact_id']")
//	WebElement checkboxClick;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);;
	}
	
	public boolean verifyContactsLabel() {
		return contactLabel.isDisplayed();
	}
	
	public void selectContacts(String name) {
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]"
				+ "//parent::td//preceding-sibling::td//input[@name='contact_id']")).click();;
	}
	
	public void createNewContact(String title,String ftName,String ltName,String Company) {
		Select s=new Select(driver.findElement(By.name("title")));
		s.selectByVisibleText(title);
		
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(Company);
		saveButton.click();
	}
}
