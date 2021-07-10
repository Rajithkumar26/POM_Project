package com.FreeCRM.commonUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.RenderingHints.Key;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.FreeCRM.Base.Parentclass;
import com.aventstack.extentreports.utils.FileUtil;

public class TestUtility extends Parentclass {

	public static long PAGE_LOAD_TIMEOUT=15;
	public static long IMPLICIT_TIME=10;
	public static String TESTDATA_SHEET_PATH = "C://Users//Vaibhav//eclipse-workspace//SeleniumScript//src//main//java//com//FreeCRM//TestData//FreeCRMTestData.xlsx";

	static Workbook book;
	static org.apache.poi.ss.usermodel.Sheet sheet;
	
	public void movemouse() {

		Actions action= new Actions(driver);
//		
//		WebElement link = driver.findElement(By.xpath("//*[@id=\'main-nav\']/div[3]/a/span"));
//		action.contextClick(link);
//		//.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER);
//		Set<String> element = driver.getWindowHandles();
//
//		
//		Iterator<String> itr= element.iterator();
//		String parentwindow= itr.next();
//		String childwindow= itr.next();
//	
//	driver.switchTo().window(childwindow);
//		
//		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"top-header-menu\"]/div[2]/div[1]/input"))).click();
//		driver.findElement(By.xpath("//*[@id=\"top-header-menu\"]/div[2]/div[1]/input")).sendKeys("abc");
//		driver.findElement(By.xpath("//*[@id=\"top-header-menu\"]/div[2]/div[1]/input")).clear();
//			
	}
	
	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}

	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File DestFile = new File("C://Users//Vaibhav//eclipse-workspace//SeleniumScript//test-output//old//report.html");
		FileUtils.copyFile(scrFile, DestFile);
	//			new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

	
	
}
