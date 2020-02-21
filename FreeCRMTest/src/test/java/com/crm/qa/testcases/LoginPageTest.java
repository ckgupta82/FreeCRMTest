package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ForgotPasswordPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.SignUpPage;
import com.crm.qa.pages.WelcomePage;
import com.crm.qa.util.TestUtil;

public class LoginPageTest extends TestBase{
	WelcomePage welcomepg;
	LoginPage loginpg;
	HomePage homepg;
	ForgotPasswordPage forgotpw;
	SignUpPage Sign;
	TestUtil testUtil;
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		System.out.println("LoginPageTest - BeforeMethod - setup");
		initialization();
		
		loginpg = new LoginPage();
		homepg = new HomePage();
		testUtil = new TestUtil();
		Sign = new SignUpPage();
		forgotpw = new ForgotPasswordPage();
		welcomepg = new WelcomePage();
		loginpg = welcomepg.LoginBtnClick();
	}
	
	@Test(priority=1)
	public void LoginPageTitle()
	{
		System.out.println("LoginPageTest - LoginPageTitle");
		String loginPgTtle=loginpg.LoginPageTitle();
		Assert.assertEquals(loginPgTtle, "Cogmento CRM");
	}
	
	@Test(priority=2)
	public void SignUpLinkTest()
	{
		System.out.println("LoginPageTest - SignUpLinkTest");
		Sign = loginpg.SignupClick();
		Assert.assertTrue(Sign.checkSignUpPageMainLable());
		
	}
	@Test(priority=3)
	public void ForgotPasswordLinkTest()
	{
		System.out.println("LoginPageTest - ForgotPasswordLinkTest");
		forgotpw = loginpg.ForgotpasswordClick();
		Assert.assertTrue(forgotpw.checkFGPMainLable());
	}
	@Test(priority=4)
	public void LoginTest()
	{
		System.out.println("LoginPageTest - LoginTest");
		homepg = loginpg.Login(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(homepg.CheckUserNameOnHomePage());
		System.out.println("The value of username present or not flag is " + homepg.CheckUserNameOnHomePage());
		homepg.CheckUserNameValueOnHomePage();
	}
	
	
	@AfterMethod
	public void teardown()
	{
		System.out.println("LoginPageTest - AfterMethod - driverQuit");
		driver.quit();
	}
}
