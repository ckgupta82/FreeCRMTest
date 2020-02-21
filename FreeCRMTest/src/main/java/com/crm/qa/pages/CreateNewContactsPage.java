package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class CreateNewContactsPage extends TestBase{
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@name='value']")
	WebElement eMail;
	
	@FindBy(xpath="//div[@name='status']")
	WebElement status;
	
	@FindBy(xpath="//span[contains(text(),'New')]")
	WebElement statusOptionNew;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement saveBtn;
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement LabelCreateNewContact;
	
	public CreateNewContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getTitleCreateNewContactsPage()
	{
		return driver.getTitle();
	}
	public void createNewContact(String fname, String lname,String emailadd, String contactStatus )
	{
		TestBase.logger.info("Creating new Contact on Create new Contact page");
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		eMail.sendKeys(emailadd);
		status.click();
		statusOptionNew.click();
		saveBtn.click();
		
		
	}
	public String getVerificationLabelText()
	{
		return LabelCreateNewContact.getText();
	}

}
