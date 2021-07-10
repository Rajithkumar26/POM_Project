package com.FreeCRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.FreeCRM.Base.Parentclass;

public class Contactpage extends Parentclass {

	
	
	@FindBy(xpath= "//*[@id=\'dashboard-toolbar\']/div[1]")
	WebElement contactTablelabel;
	
	@FindBy(xpath = "//*[@id=\'dashboard-toolbar\']/div[2]/div/a/button")
	WebElement createcontactButton;
	
	@FindBy (name="first_name")
	WebElement first_name;
	
	@FindBy (name="last_name")
	WebElement last_name;
	
	@FindBy(xpath="//*[@id=\'main-content\']/div/div[2]/form/div[2]/div[2]/div/div/input")
	WebElement companyname;
	
	@FindBy(xpath="//*[@id=\'dashboard-toolbar\']/div[2]/div/button[2]")
	WebElement submitbutton;
	
	public Contactpage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContacttablelabel() {
		
		return contactTablelabel.isDisplayed();
		
	}
	

	
	public void SelectContactByname(String name) {
		
		Actions actions = new Actions(driver);
		driver.findElement(By.xpath("//*[@id=\"top-header-menu\"]/div[2]/div[1]/input")).sendKeys("abc");
		WebDriverWait wait= new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'"+name+"')]/parent::td//preceding-sibling::td//input[@name=\'id\']"))).click();
		WebElement element= driver.findElement(By.xpath("//a[contains(text(), '"+name+"')]/parent::td//preceding-sibling::td//input[@name='id']"));
		//a[contains(text(),'"+name+"')]/parent::td//preceding-sibling::td//input[@name=\'id\']
	actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"top-header-menu\"]/div[2]/div[1]/input"))).click();
	driver.findElement(By.xpath("//*[@id=\"top-header-menu\"]/div[2]/div[1]/input")).clear();
		actions.moveToElement(element).click().perform();
		
	}
		
		
	public void Createcontact(String fname, String lname, String compname) 
	{
		createcontactButton.click();
	first_name.sendKeys(fname);
	last_name.sendKeys(lname);
	companyname.sendKeys(compname);
	submitbutton.click();
	}
	
	
}
