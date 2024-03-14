package com.sevenrmartsupermaket.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	WebDriver driver;
	Select select;
	Actions action;
	
	public PageUtility(WebDriver driver) {
		this.driver =driver;
	}
	
	public void selectIndex(WebElement element,int index) {
		select = new Select(element);
		select.selectByIndex(index);
	}
	
	public void selectValue(WebElement element,String value) {
		select = new Select(element);
		select.selectByValue(value);
	}
	
	public void selectVisibleText(WebElement element,String text) {
		select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	public void mouseHover(WebElement element) {
		action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}  
}
