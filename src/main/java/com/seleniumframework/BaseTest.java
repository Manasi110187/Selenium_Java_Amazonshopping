package com.seleniumframework;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseTest {
	protected WebDriver driver;
	
	@BeforeGroups (groups = {"Startshopping"})
	public void BaseTest()
	{
		driver= new SafariDriver();
		//driver.get("https://www.amazon.com");
		
	}

	public void teardown()
	{
	//driver.close();
	driver.quit();
	}

}
