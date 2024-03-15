package com.sevenrmartsupermaket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermaket.utilities.GeneralUtility;
import com.sevenrmartsupermaket.utilities.PageUtility;
import com.sevenrmartsupermaket.utilities.WaitUtility;

public class AdminUsersPage {
	WebDriver driver;
	GeneralUtility generalutility = new GeneralUtility();
	WaitUtility waitutility = new WaitUtility();
	PageUtility pageutility;

	@FindBy(xpath = "//table//tbody//tr//td[1]")
	List<WebElement> userNamesList;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement userStatusMessage;

	@FindBy(xpath = "//a[contains(text(),'New')]")
	WebElement newButton;

	@FindBy(xpath = "//input[@name='username']")
	WebElement adminUserName;

	@FindBy(xpath = "//input[@name='password']")
	WebElement adminPassWord;

	@FindBy(xpath = "//select[@name='user_type']")
	WebElement adminUserType;
	
	@FindBy(xpath = "//button[@name='Create']")
	WebElement saveButton;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnNewButton() {
		newButton.click();
	}

	public void enterUserName(String newUserName) {
		adminUserName.sendKeys(newUserName);
	}

	public void enterPassword(String newPassword) {
		adminPassWord.sendKeys(newPassword);
	}

	public void selectUserType(String newUserType) {
		pageutility = new PageUtility(driver);
		pageutility.selectVisibleText(adminUserType, newUserType);
	}
	
	public void clickOnSaveButton() {
		saveButton.click();
	}

	public void createNewAdminUser(String newUserName, String newPassword, String newUserType) {
		clickOnNewButton();
		enterUserName(newUserName);
		enterPassword(newPassword);
		selectUserType(newUserType);
		clickOnSaveButton();
	}

	public String initialUserStatus(String username) {
		List<String> user_names = new ArrayList<String>();
		user_names = generalutility.getTextOfElements(userNamesList);
		int index;
		for (index = 0; index < user_names.size(); index++) {
			if (username.equals(user_names.get(index))) {
				index++;
				break;
			}
		}
		WebElement userStatus = driver.findElement(By.xpath("//table//tbody//tr[" + index + "]//td[3]"));
		return userStatus.getText();
	}

	public void deactivateAdminUsers(String username) {
		List<String> user_names = new ArrayList<String>();
		user_names = generalutility.getTextOfElements(userNamesList);
		int index;
		for (index = 0; index < user_names.size(); index++) {
			if (username.equals(user_names.get(index))) {
				index++;
				break;
			}
		}
		WebElement userStatus = driver.findElement(By.xpath("//table//tbody//tr[" + index + "]//td[3]"));
		WebElement userStatusButton = driver.findElement(By.xpath("//table//tbody//tr[" + index + "]//td[5]//a[1]"));
		if (userStatus.getText().equals("Active")) {
			userStatusButton.click();
		}
		// By currentUserStatus = By.xpath("//table//tbody//tr[" + index + "]//td[3]");
		// waitutility.waitForElementVisibilityByXPath(driver, currentUserStatus, 15);
		// System.out.println("Current User Status : " + userStatus.getText());
	}

	public String userStatusMessage() {
		return userStatusMessage.getText();
	}
}
