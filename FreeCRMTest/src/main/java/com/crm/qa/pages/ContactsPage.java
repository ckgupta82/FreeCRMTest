package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	@FindBy(xpath = "//button[contains(.,'New')]")
	WebElement newContactBtn;
	@FindBy(xpath = "//button[contains(.,'Export')]")
	WebElement exportBtn;
	@FindBy(xpath = "//button[contains(.,'Show Filters')]")
	WebElement showFiletersBtn;
	
	public ContactsPage()
	{
		
		PageFactory.initElements(driver, this);
		
		
	}
	
	public CreateNewContactsPage clickOnNewContactsBtn()
	{
		TestBase.logger.info("Clicking on new contact button on contacts page");
		newContactBtn.click();
		
		return new CreateNewContactsPage();
	}
	

}
