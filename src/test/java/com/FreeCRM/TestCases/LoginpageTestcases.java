package com.FreeCRM.TestCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.FreeCRM.Base.Parentclass;
import com.FreeCRM.pages.Homepage;
import com.FreeCRM.pages.LoginPage;

public class LoginpageTestcases extends Parentclass{
	
	LoginPage loginpage;
	Homepage homepage;
	
	
	public LoginpageTestcases() {
		super();
	}
	
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginpage= new LoginPage();
	}
	
	
//	@Test(priority=1)
//	public void loginpageTitle() {
//		String Title= loginpage.title();
//		assert.assertEquals(Title, "Cogmento CRM", "Title matched");
//	}
	
	@Test
	public void  loginTest() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
	}
}
