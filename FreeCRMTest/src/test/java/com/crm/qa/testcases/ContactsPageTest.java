package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.CreateNewContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.WelcomePage;

public class ContactsPageTest extends TestBase{
	
	WelcomePage welcomepg;
	LoginPage lgnpg;
	HomePage homepg;
	ContactsPage cntpg;
	CreateNewContactsPage creNewContPage;
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		System.out.println("ContactsPageTest - BeforeMethod - setup"); 
		initialization();
		welcomepg = new WelcomePage();
		lgnpg = new LoginPage();
		homepg = new HomePage();
		cntpg = new ContactsPage();
		creNewContPage = new CreateNewContactsPage();
		lgnpg = welcomepg.LoginBtnClick();
		homepg = lgnpg.Login(prop.getProperty("username"), prop.getProperty("password") );
		cntpg = homepg.clickOnContactsLink();
		
		
	}
    @Test
    public void VerifyCreateNewContactbtn()
    {
    	System.out.println("ContactsPageTest - VerifyCreateNewContactbtn"); 
    	creNewContPage=cntpg.clickOnNewContactsBtn();
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			System.out.println("The verifyCreateNewContactBtn exception error is ");
			e.printStackTrace();
		}
    	Assert.assertEquals(creNewContPage.getVerificationLabelText(), "Create New Contact");
    }
    
    @AfterMethod
    public void teardown()
    {
    	System.out.println("ContactsPageTest - AfterMethod - driverQuit"); 
    	driver.quit();
    }
}
