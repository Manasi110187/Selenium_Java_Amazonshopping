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
import org.testng.Assert;
import org.testng.annotations.*;

public class Amazonshopping extends BaseTest {

	//Navigate to amazon.com
	@Test(groups = { "Startshopping" }, priority = 1)
	public void navigateToAmazon() {
		driver.get("https://www.amazon.com");
		for (int i = 0; i < 500; i++) {

		}
		driver.manage().window().fullscreen();
	}

	//Click on search and provide the item to search
	@Test(groups = { "Startshopping" }, priority = 2)
	public void searchItem() {
		WebElement searchtextbox = driver.findElement(By.id("twotabsearchtextbox"));
		searchtextbox.sendKeys("iphone");
		searchtextbox.sendKeys(Keys.ENTER);

	}

	//Select perticular item from the list of displayed items, select specifications and then add it to the cart
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
			driver.findElement(By.id("add-to-cart-button")).click();
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	//Verify the count of items added in the cart 
	@Test(groups = { "Startshopping" }, priority = 4)
	public void assert_item_added() {
		String cartCount = driver.findElement(By.id("nav-cart-count-container")).getText();
		System.out.print(cartCount);
		// Thread.sleep(1000);
		if (cartCount.contains("1")) {
			System.out.println("Test case is passed");
		} else

			System.out.println("Test case is Failed");
	}
	
    //Re-enter item to search and this time, use filter option to apply additional filters like price-range
	@Test(groups = { "Startshopping" }, priority = 5)
	public void select_filter_range() throws InterruptedException {
		driver.get(
				"https://www.amazon.com/s?k=iphone&crid=2AYSJZIDHE2YO&sprefix=%2Caps%2C74&ref=nb_sb_ss_recent_1_0_recent");
		Thread.sleep(1000);
		WebElement searchtextbox = driver.findElement(By.id("twotabsearchtextbox"));
		searchtextbox.sendKeys("iphone");
		searchtextbox.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"s-all-filters-announce\"]")).click();
		Thread.sleep(1000);
		driver.get(
				"https://www.amazon.com/s?k=iphone&crid=367O13XKDVFF6&qid=1724775390&rnid=14674871011&sprefix=iphone%2Caps%2C123&ref=sr_nr_p_36_0_0&low-price=500&high-price=750");

	}

}
