	package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//span[contains(.,'Chetan Kumar')]")
	WebElement UserNameOnHomePage;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	public  HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean CheckUserNameOnHomePage()
	{
		return UserNameOnHomePage.isDisplayed();
	}
	public void CheckUserNameValueOnHomePage()
	{
		System.out.println("With innerHTML it is " + UserNameOnHomePage.getAttribute("innerHTML"));
		System.out.println("With innerText it is " + UserNameOnHomePage.getAttribute("innerText"));
		System.out.println("With getText() it is " + UserNameOnHomePage.getText());
	}
	public String getHomePageTitle()
	{
		return driver.getTitle();
	}
	public ContactsPage clickOnContactsLink()
	{
		contactsLink.click();
		return new ContactsPage();
	}

}
