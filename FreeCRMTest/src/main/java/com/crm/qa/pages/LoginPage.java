package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//PageFactory - OR
	
	@FindBy(xpath="//input[@name='email']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//div[@id='ui']/div/div/form/div/div[3]")
	WebElement Submit;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div/div[1]/a")
	WebElement ForgotPassword;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div/div[3]/a")
	WebElement signup;
	
	//initialize the page objects
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	//Actions
	public boolean PasswordElementPresent()
	{
		TestBase.logger.info("Checking Password element present on Login Page");
		return password.isDisplayed();
	}
	
	public SignUpPage SignupClick()
	{
		TestBase.logger.info("Clicking on SignUp button on Login Page");
		signup.click();
		
		return new SignUpPage();
	}
	public ForgotPasswordPage ForgotpasswordClick()
	{
		TestBase.logger.info("Clicking on ForgotPassword link on Login Page");
		ForgotPassword.click();
		
		return new ForgotPasswordPage();
	}
	public String LoginPageTitle()
	{
		TestBase.logger.info("Checking Login Page Title");
		return driver.getTitle();
	}
	
	public HomePage Login(String uname, String pw)
	{
		TestBase.logger.info("Checking Login functionality");
		username.sendKeys(uname);
		password.sendKeys(pw);
		Submit.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return new HomePage();
	}
	
	

}
