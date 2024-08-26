package com.seleniumframework;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.LogEntry;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.manager.SeleniumManager;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class Amazonshopping extends BaseTest {

	@Test(groups = { "Startshopping" }, priority = 1)
	public void navigateToAmazon() {
		driver.get("https://www.amazon.com");
		for (int i = 0; i < 500; i++) {

		}
		driver.manage().window().fullscreen();
	}

	@Test(groups = { "Startshopping" }, priority = 2)
	public void searchItem() {
		WebElement searchtextbox = driver.findElement(By.id("twotabsearchtextbox"));
		searchtextbox.sendKeys("swimming fins xs");
		searchtextbox.sendKeys(Keys.ENTER);

	}

	@Test(groups = { "Startshopping" }, priority = 3)
	public void addItemToCart() throws InterruptedException {
		System.out.println("::::addItemToCart");
		driver.get(
				"https://www.amazon.com/Apple-iPhone-Silicone-Case-MagSafe/dp/B0CHX47SZ7/ref=sr_1_1_sspa?crid=DVMOSBIUAV&dib=eyJ2IjoiMSJ9.x6IF4FpOXQPBhWSSJal9u94usikz9KqZEqll0HMaFsbmqGdqidk9s4cPwKFZy7NCwKm8b3PCAdgtculRqTqEPefyPMvufRyVKXi48XZ5RR_5fjsfArJCUqTszsVrMvYvKn8iW0VcNSMaPbvJhg8hXWy-9FyJcTToThmTWFw4qIptMtxOotAzw5QoRIC-YpGX6knOi-hCBqnJcYC_LWhLclHiqqAyFtbJLIDBZOANPHg.7eCgG9v17CgMx5QWpTytzUa9h0FrrwycPBz8N3FkbLM&dib_tag=se&keywords=iphone&qid=1724542348&sprefix=iphone%2Caps%2C140&sr=8-1-spons&sp_csd=d2lkZ2V0TmFtZT1zcF9hdGY&psc=1");
		System.out.println("xx34343434");
		driver.manage().window().fullscreen();
		System.out.println("wait executed");
		WebElement dropdownElement = null;
		try {
			dropdownElement = new WebDriverWait(driver, Duration.ofMillis(5000))
					.until(ExpectedConditions.elementToBeClickable(By.id("native_dropdown_selected_material_type")));
			System.out.println(dropdownElement.getText());
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].selectedIndex =1;", dropdownElement);
			Thread.sleep(2000);
			dropdownElement.sendKeys(Keys.ENTER);
			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
		}
       driver.close();
	}
	

}
