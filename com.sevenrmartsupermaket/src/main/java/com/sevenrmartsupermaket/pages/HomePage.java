package com.sevenrmartsupermaket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	@FindBy(xpath="//div[@class='info']")
	WebElement profileName;
	
	@FindBy(xpath="//p[text()='Push Notifications']")
	WebElement pushNotificationLink;
	
	@FindBy(xpath="//p[text()='Manage Delivery Boy']")
	WebElement manageDeliveryBoyLink;
	
	@FindBy(xpath="//a/p[text()='Manage Location']")
	WebElement manageLocationLink;
	
	@FindBy(xpath="(//p[contains(text(),'Manage Expense')])[1]")
	WebElement manageExpenseLink;
	
	@FindBy(xpath="(//p[contains(text(),'Manage Expense')])[2]")
	WebElement manageExpense;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getProfileName() {
		return profileName.getText();
	}
	
	public void clickOnPushNotificationLink() {
		pushNotificationLink.click();
	}
	public void clickOnManageDeliverBoyLink() {
		manageDeliveryBoyLink.click();
	}
	public void clickOnManageLocationLink() {
		manageLocationLink.click();
	}
	public void clickOnManageExpenseLink() {
		manageExpenseLink.click();
	}
	public void clickOnManageExpenseSubLink() {
		manageExpense.click();
	}
}
