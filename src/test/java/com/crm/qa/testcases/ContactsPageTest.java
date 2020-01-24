package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testutil;
	ContactsPage contactspage;
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		intilization();
		loginPage=new LoginPage();
		testutil=new TestUtil();
		contactspage=new ContactsPage();
		homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		testutil.switchToFrame();
		contactspage=homePage.clickOnContactsLink();
	}
	
	@Test(priority=1)
		public void verifyContactsLabel() {
		Assert.assertTrue(contactspage.verifyContactsLabel(), "contacts page is missing on the label");
	}
	
	@Test(priority=2)
	public void selectcontactsByName() {
		contactspage.selectContacts("test test");
	}
	
	@Test(priority=3)
	public void selectMultiplecontactsByName() {
		contactspage.selectContacts("test test");
		contactspage.selectContacts("ui sample");
	}
	
	@DataProvider
	public void getTestData() {
		
	}
	@Test(priority=4)
	public void validateCreateNewContact() {
	homePage.clickOnNewContactLink();
	contactspage.createNewContact("Mr.", "Tom", "Peter", "Google");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
