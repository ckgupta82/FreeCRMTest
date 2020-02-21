package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.CreateNewContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.WelcomePage;
import com.crm.qa.util.TestUtil;

public class CreateNewContactsPageTest extends TestBase{
	
	WelcomePage welcomepg;
	LoginPage lgnpg;
	HomePage homepg;
	ContactsPage cntpg;
	CreateNewContactsPage cNewCntpg;
	String sheetName = "contacts";
	
	public CreateNewContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		System.out.println("CreateNewContactsPageTest - BeforeMethod - setup"); 
		initialization();
		welcomepg = new WelcomePage();
		lgnpg = new LoginPage();
		homepg = new HomePage();
		cntpg = new ContactsPage();
		cNewCntpg = new CreateNewContactsPage();
		lgnpg = welcomepg.LoginBtnClick();
		homepg = lgnpg.Login(prop.getProperty("username"), prop.getProperty("password") );
		cntpg = homepg.clickOnContactsLink();
		cNewCntpg =cntpg.clickOnNewContactsBtn();
	}
	@DataProvider
	public Object[][] getCRMTestData()
	{
		System.out.println("CreateNewContactsPageTest - DataProvider - getCRMTestData"); 
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}
    @Test(dataProvider="getCRMTestData")
    public void VerifyCreateNewContactFunctionality(String FirstName, String LastName, String EmailAddress, String ContactStatus)
    {
    	System.out.println("CreateNewContactsPageTest - VerifyCreateNewContactFunctionality"); 
    	cNewCntpg.createNewContact(FirstName, LastName, EmailAddress, ContactStatus);
    }
    
    @AfterMethod
    public void teardown()
    {
    	System.out.println("CreateNewContactsPageTest - AfterMethod - driverQuit"); 
    	driver.quit();
    }
}
