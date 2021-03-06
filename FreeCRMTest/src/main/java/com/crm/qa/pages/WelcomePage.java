package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class WelcomePage extends TestBase{
	
	
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/header[1]/div[1]/nav[1]/div[2]/div[1]/div[2]/ul[1]/a[1]")
	WebElement LOGINbtn;
	@FindBy(xpath="/html[1]/body[1]/div[1]/main[1]/section[1]/a[1]")
	WebElement SignUpBtn;
	@FindBy(xpath="//div[@class='rd-navbar-panel']//a[@class='brand-name']")
	WebElement Logo;
	
	public WelcomePage()
	{
		PageFactory.initElements(driver, this);
	}
	public LoginPage LoginBtnClick()
	{
		TestBase.logger.info("on Welcome page - Clicking on Login button ");
		LOGINbtn.click();
		 return new LoginPage();
		
	}
	public SignUpPage SignUpBtnClick()
	{
		TestBase.logger.info("on Welcome page - Clicking on SignUp button ");
		SignUpBtn.click();
		return new SignUpPage();
	}
	
	public String pageTitle()
	{
		TestBase.logger.info("on Welcome page - Checking PageTitle ");
		return driver.getTitle();
		
	}
	public boolean CheckLogo()
	{
		TestBase.logger.info("on Welcome page - Checking Logon ");
		boolean flag = Logo.isDisplayed();
		return flag;
	}

}
