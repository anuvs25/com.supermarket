package com.sevenrmartsupermaket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PushNotificationsPage {
	WebDriver driver;

	@FindBy(xpath = "//input[@name='titlep']")
	WebElement enterTitle;

	@FindBy(xpath = "//input[@name='description']")
	WebElement enterDescription;

	@FindBy(xpath = "//button[@name='create']")
	WebElement sendButton;

	@FindBy(xpath = "//a[text()='Reset']")
	WebElement resetButton;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMessageBox;

	public PushNotificationsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterTitle(String title) {
		enterTitle.sendKeys(title);
	}

	public void enterDescription(String description) {
		enterDescription.sendKeys(description);
	}

	public void clickOnSendButton() {
		sendButton.click();
	}

	public boolean visibilityOfSuccessMessageBox() {
		return alertMessageBox.isDisplayed();
	}
	
	public String alertMessageGetText() {
		return alertMessageBox.getText();
	}
	
	public void resetFunction() {
		resetButton.click();
	}

	public void sendNotifications(String title, String description) {
		enterTitle(title);
		enterDescription(description);
		clickOnSendButton();
	}
	public void resetNotifications(String title, String description) {
		enterTitle(title);
		enterDescription(description);
		resetFunction();
	}
}
