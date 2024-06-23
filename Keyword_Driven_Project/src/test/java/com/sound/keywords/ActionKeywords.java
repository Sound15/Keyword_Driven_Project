package com.sound.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sound.constants.Constants;
import com.sound.executionCore.Engine;
import com.sound.utilities.ExcelUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ActionKeywords {
	static WebDriver driver;
	
	public static void openBrowser() {
		switch(ExcelUtilities.dataColumnValue) {
		case Constants.CHROME:
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			break;
		case Constants.FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			break;
		case Constants.SAFARI:
			WebDriverManager.safaridriver().setup();
			driver= new ChromeDriver();
			break;
		default:
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			break;
		}
		
		
	}
	
	public static void goToUrl() {
		driver.get(ExcelUtilities.dataColumnValue);
	}
	
	public static void enterUserName() {
		WebElement userName=driver.findElement(Engine.Locator);
		userName.sendKeys(ExcelUtilities.dataColumnValue);
	}
	
	public static void enterPassword() {
		WebElement password=driver.findElement(Engine.Locator);
		password.sendKeys(ExcelUtilities.dataColumnValue);
	}
	
	public static void click() {
		WebElement login=driver.findElement(Engine.Locator);
		login.click();
	}

}
