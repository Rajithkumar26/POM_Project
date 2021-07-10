package com.FreeCRM.TestCases;

import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.FreeCRM.Base.Parentclass;
import com.FreeCRM.commonUtilities.TestUtility;
import com.FreeCRM.pages.Contactpage;
import com.FreeCRM.pages.Homepage;
import com.FreeCRM.pages.LoginPage;

public class ContactpageTest extends Parentclass{

	LoginPage loginpage;
	Homepage homepage;
	TestUtility testutility;
	Contactpage contactspage;
	String sheetname="Sheet1";
	
	public ContactpageTest() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage= new LoginPage();
		contactspage = new Contactpage();
		testutility = new TestUtility();
		homepage= loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactspage=homepage.ClickOnContactsTab();
	}
	
	@DataProvider()
	public Object[][] getTestData() {
		Object [][] data= testutility.getTestData(sheetname);
	return data;	
	}
	
	
//	@Test(priority=1)
//	public void contactpagelabel() {
//		
//		Assert.assertTrue(contactspage.verifyContacttablelabel(), "Label is found");
//	
//	}
	
//	@Test(priority=2)
//	public void Selectacontact() {
//		testutility.movemouse();
//		
//		contactspage.SelectContactByname("Ammo Memo Demo");
//	}
//	
	
	@Test(priority=3, dataProvider= "getTestData")
	public void createNewContact(String firstName, String LastName, String CompanyName) {
	contactspage.Createcontact(firstName, LastName, CompanyName);
		
	}
	
	
	@AfterMethod
	public void teardwon() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
		}
}
