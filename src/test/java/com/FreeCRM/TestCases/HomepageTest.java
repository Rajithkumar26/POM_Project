package com.FreeCRM.TestCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.FreeCRM.Base.Parentclass;
import com.FreeCRM.commonUtilities.TestUtility;
import com.FreeCRM.pages.Contactpage;
import com.FreeCRM.pages.Homepage;
import com.FreeCRM.pages.LoginPage;

public class HomepageTest extends Parentclass{
LoginPage  loginpage;
Homepage homepage;
Contactpage contactspage;
TestUtility testutility;
	public HomepageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage= new LoginPage();
		contactspage= new Contactpage();
	testutility = new TestUtility();
		homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
//	@Test
//	public void validateLoginImage() {
//		boolean flag= homepage.validateCRMimage();
//		assert.assertTrue(flag);
//		
//	}
	
	@Test(priority=1)
	public void validatetitle() {
		String title= homepage.title();
		String titles="cogmento CRM"; 
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(titles, "cogmento CRM");
	}
	

	@Test(priority=2)
	public  void ClickonContacts() {
		//testutility.takeScreenshotAtEndOfTest();
		contactspage = homepage.ClickOnContactsTab();
	}
	
	
	@AfterMethod
	public void teardown() {
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		driver.close();
	}
	
}
