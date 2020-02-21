package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ForgotPasswordPage extends TestBase{
	
	@FindBy(xpath="//h2[@class='ui blue header']")
	WebElement FGPLabel;
	
	public ForgotPasswordPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean checkFGPMainLable()
	{
		return FGPLabel.isDisplayed();
	}
	public String getFGPPageTitle()
	{
		return driver.getTitle();
	}

}
