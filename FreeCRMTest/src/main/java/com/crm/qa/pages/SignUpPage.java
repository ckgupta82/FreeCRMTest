package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class SignUpPage extends TestBase{
	
	@FindBy(xpath="//p[contains(text(),'For Security you must verify Email and Phone')]")
	WebElement SignUpPageMainLabel;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement email;
	
	@FindBy(xpath="//input[@class='search']")
	WebElement country;
	
	@FindBy(xpath="//input[@name='phone']")
	WebElement phone;
	
	@FindBy(xpath="//input[@name='terms']")
	WebElement terms;
	
	@FindBy(xpath="//div[@class='recaptcha-checkbox-border']")
	WebElement captcha;
	
	@FindBy(xpath="//button[@name='action']")
	WebElement submit;
	
	public SignUpPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getSigunUppageTitle()
	{
		return driver.getTitle();
	}
	public boolean checkSignUpPageMainLable()
	{
		return SignUpPageMainLabel.isDisplayed();
	}

}
