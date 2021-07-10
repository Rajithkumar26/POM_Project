package com.FreeCRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.FreeCRM.Base.Parentclass;

public class LoginPage  extends Parentclass {

//	@FindBy(xpath="/html/body/div[1]/header/div/nav/div/div/a/span[1]")
//	WebElement login_button;
//	
	
	@FindBy(xpath="//*[@id=\'ui\']/div/div/form/div/div[1]/div/input")
	WebElement username;
	
	@FindBy(xpath= "//*[@id=\'ui\']/div/div/form/div/div[2]/div/input")
	WebElement password;
	
	@FindBy(xpath="//*[@id=\'ui\']/div/div/form/div/div[3]")
	WebElement LogIn;
	
	@FindBy(xpath= "//a[contains(text(), \'Sign Up\')]")
	WebElement Newuser;

	public LoginPage() {
	PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="/html/head/title")
	WebElement loginTitle;
	
	public String title() {
		return loginTitle.getText();
	}
	
	public Homepage login(String uname, String pwd) {
		username.clear();
		username.sendKeys(uname);
		password.clear();
		password.sendKeys(pwd);
				LogIn.click();
	return new Homepage();
	}
	
	
	
	
	
	



}


