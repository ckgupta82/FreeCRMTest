package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.SignUpPage;
import com.crm.qa.pages.WelcomePage;

public class WelcomePageTest extends TestBase{
	
	WelcomePage welcomepg;
	LoginPage loginpg;
	SignUpPage signuppg;
	
	public WelcomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		System.out.println("WelcomePageTest - BeforeMethod Setup");
		TestBase.initialization();
		welcomepg = new WelcomePage();
		loginpg = new LoginPage();
		
		
	}
	
	@Test(priority=1)
	public void VerifyLoginBtnTest()
	{
		System.out.println("WelcomePageTest - VerifyLoginBtnTest");
		loginpg = welcomepg.LoginBtnClick();
		Assert.assertTrue(loginpg.PasswordElementPresent());
	}
	@Test(priority=2)
	public void VerifySignUpBtnTest()
	{
		System.out.println("WelcomePageTest - VerifySignUpBtnTest");
		signuppg = welcomepg.SignUpBtnClick();
		Assert.assertTrue(signuppg.checkSignUpPageMainLable());
	}
	@Test(priority=3)
	public void VerifyWelcomePageTitle()
	{
		System.out.println("WelcomePageTest - VerifyWelcomePageTitle");
		String title = welcomepg.pageTitle();
		Assert.assertEquals(title, "Free CRM #1 cloud software for any business large or small", "Welcome Page Title is not correct");
	}
	@Test(priority=4)
	public void VerifyLogoPresent()
	{
		System.out.println("WelcomePageTest - VerifyLogoPresent");
		boolean flag = welcomepg.CheckLogo();
		Assert.assertEquals(flag, true, "Welcome Page Logo is not present");
	}
	
	@AfterMethod
	public void teardown()
	{
		System.out.println("WelcomePageTest - AfterMethod - driverQuit");
		driver.quit();
	}
}
