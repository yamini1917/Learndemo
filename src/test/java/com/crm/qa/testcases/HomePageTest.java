package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testutil;
	ContactsPage contactspage;
	
	public HomePageTest() {
		super();
	}
	
	//test cases should be separated  -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute the test cases
	//after each test case -- close the browser
	@BeforeMethod
	public void setUp() {
		intilization();
		loginPage=new LoginPage();
		testutil=new TestUtil();
		contactspage=new ContactsPage();
		homePage= loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitle() {
		String homepagetitle=homePage.verifyHomePageTitle();
		Assert.assertEquals(homepagetitle, "CRMPRO","HomePage title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserName() {
		testutil.switchToFrame();
		Assert.assertTrue(homePage.verifyUserName());
		
	}
	@Test(priority=3)
	public void clickOnContactsLink() {
		testutil.switchToFrame();
		contactspage=homePage.clickOnContactsLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
