package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		intilization();
		loginPage=new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String Title=loginPage.validateLoginPageTitle();
		Assert.assertEquals(Title, "#1 Free CRM software in the Cloud FreeCRM");
	}
	
	@Test(priority=2)
	public void crmLogoImageTest() {
		boolean flag=loginPage.validateCRMLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
