package com.FreeCRM.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.FreeCRM.commonUtilities.TestUtility;

public class Parentclass {
static ChromeOptions op;
	public static WebDriver driver;
	public static Properties prop;
	
	
	
	
	public Parentclass()
	{
		try {
			prop= new Properties();
			FileInputStream fin= new FileInputStream("C://Users//Vaibhav//eclipse-workspace//SeleniumScript//src//main//java//com//FreeCRM//config//config.properties");
			try {
				prop.load(fin);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}




	protected void initialization() {
		// TODO Auto-generated method stub
		String browserName= prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vaibhav\\Desktop\\chromedriver.exe"); 
			op= new ChromeOptions();
			driver= new ChromeDriver(op);
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtility.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtility.IMPLICIT_TIME, TimeUnit.SECONDS);
		op.setExperimentalOption("useAutomationExtension", false);
		op.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
		
		driver.get(prop.getProperty("url"));
		
	}
}
