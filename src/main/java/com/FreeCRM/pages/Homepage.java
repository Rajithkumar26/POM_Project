package com.FreeCRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.FreeCRM.Base.Parentclass;

public class Homepage  extends Parentclass{

	
	@FindBy(xpath = "//*[@id=\'main-nav\']/div[3]/a/span")
	WebElement ContactsTab;
	
	
//	@FindBy(xpath ="//*[@id=\"main-nav\"]/div[4]/a/span")
//	WebElement CompaniesTab;
//	
	
	@FindBy(xpath= "//*[@id=\'main-nav\']/div[5]/a/span")
	WebElement DealsTab;
	
	@FindBy (xpath="/html/head/title")
	WebElement loginTitle;
	
	public String title() {
		System.out.println(loginTitle.getText());
		return loginTitle.getText();
	}
	
//	@FindBy(xpath="/html/head/link[2]")
//	boolean HomepageImage;
	
	public Homepage() {
		PageFactory.initElements(driver, this);
	}	
	
//	public void ClickOnCompanies() {
//		CompaniesTab.click();
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
//	}
	
//	
//	public boolean validateCRMimage() {
//		return HomepageImage;
//	}
	
	
	public Contactpage ClickOnContactsTab() {
		ContactsTab.click();
		return new Contactpage();
		
	}
	
	public Dealspage ClickOnDealsTab() {
		DealsTab.click();
		return new Dealspage();
	}
	
	
	
}
