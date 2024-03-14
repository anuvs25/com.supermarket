package com.sevenrmartsupermaket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermaket.constants.Constants;

public class LoginPage {
	WebDriver driver;

	Properties properties = new Properties();

	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	WebElement loginHeaderText;

	@FindBy(xpath = "//input[@name='username']")
	WebElement userNameField;

	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordField;

	@FindBy(xpath = "//input[@id='remember']")
	WebElement remeberMeCheckBox;

	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement logInButton;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement errorMessage;
	

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

		try {
			FileInputStream fi = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(fi);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterUserName(String userName) {
		userNameField.sendKeys(userName);
	}

	public void enterPassword(String passWord) {
		passwordField.sendKeys(passWord);
	}

	public void clickOnSignIn() {
		logInButton.click();
	}

	public void logIn(String userName, String passWord) {
		enterUserName(userName);
		enterPassword(passWord);
		clickOnSignIn();
	}

	public void logIn() {
		String userName = properties.getProperty("userName");
		String passWord = properties.getProperty("passWord");
		logIn(userName, passWord);
	}
	
	public String displayErrorMessage() {
		return errorMessage.getText();
	}
}