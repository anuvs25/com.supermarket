package com.sevenrmartsupermaket.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	WebDriverWait wait;

	// Method to wait for a button to be clickable
	public void waitForButtonTobeClickable(WebDriver driver, WebElement element, long time) {
		// Initialize WebDriverWait with the specified time
		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	// Method to wait for an element's visibility by its XPath
	public void waitForElementVisibilityByXPath(WebDriver driver, String xpath, long time) {

		wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

	}
}
