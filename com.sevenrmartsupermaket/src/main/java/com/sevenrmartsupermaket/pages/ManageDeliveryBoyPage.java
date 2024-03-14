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

public class ManageDeliveryBoyPage {
	WebDriver driver;
	PageUtility pageutility;
	GeneralUtility generalutility= new GeneralUtility();

	@FindBy(xpath = "//a[contains(text(),'New')]")
	WebElement newButton;

	@FindBy(xpath = "//a[contains(text(),'Search')]")
	WebElement searchButton;

	@FindBy(xpath = "//input[@id='name']")
	WebElement deliverBoyName;

	@FindBy(xpath = "//input[@id='email']")
	WebElement deliverBoyEmail;

	@FindBy(xpath = "//input[@id='phone']")
	WebElement deliverBoyPhone;

	@FindBy(xpath = "//textarea[@id='address']")
	WebElement deliverBoyAddress;

	@FindBy(xpath = "//input[@name='username']")
	WebElement newUserName;

	@FindBy(xpath = "//input[@name='password']")
	WebElement newPassword;

	@FindBy(xpath = "//button[@name='create']")
	WebElement saveButton;

	@FindBy(xpath = "//a[text()='Cancel']")
	WebElement cancelButton;

	@FindBy(xpath = "//input[@id='un']")
	WebElement searchListNameField;

	@FindBy(xpath = "//input[@id='ut']")
	WebElement searchListEmailField;

	@FindBy(xpath = "//input[@id='ph']")
	WebElement searchListPhoneField;

	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchListSearchButton;

	@FindBy(xpath = "//tbody/tr[1]/td[1]")
	WebElement searchResultName;

	@FindBy(xpath = "//table//tbody//tr[1]//td[2]")
	WebElement searchResultEmail;

	@FindBy(xpath = "//table//tbody//tr[1]//td[3]")
	WebElement searchResultPhone;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement alertMessage;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successMessage;
	
	@FindBy(xpath = "//table//tbody//tr//td//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement editButton;
	
	@FindBy(xpath = "//table//tbody//tr//td//a[@class='btn btn-sm btn btn-danger btncss']")
	WebElement deleteButton;
	
	@FindBy(xpath = "//table//tbody//tr//td[5]")
	List<WebElement> userNames;
	

	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnNew() {
		newButton.click();
	}

	public void enterName(String name) {
		deliverBoyName.sendKeys(name);
	}

	public void enterEmail(String email) {
		deliverBoyEmail.sendKeys(email);
	}

	public void enterPhone(String phone) {
		deliverBoyPhone.sendKeys(phone);
	}

	public void enterAddress(String address) {
		deliverBoyAddress.sendKeys(address);
	}

	public void newUsername(String username) {
		newUserName.sendKeys(username);
	}

	public void newPassword(String password) {
		newPassword.sendKeys(password);
	}

	public void clickOnSave() {
		pageutility = new PageUtility(driver);
		pageutility.mouseHover(saveButton);
		saveButton.click();
	}

	public void createDeliveryBoy(String name, String email, String phone, String address, String username,
			String password) {
		clickOnNew();
		enterName(name);
		enterEmail(email);
		enterPhone(phone);
		enterAddress(address);
		newUsername(username);
		newPassword(password);
		clickOnSave();
	}

	public void clickOnSearch() {
		searchButton.click();
	}

	public void clickOnSearchListSearchButton() {
		searchListSearchButton.click();
	}

	public void searchDeliveryBoyByName(String del_boy_name) {
		searchListNameField.sendKeys(del_boy_name);
	}

	public void searchDeliveryBoyByEmail(String del_boy_email) {
		searchListEmailField.sendKeys(del_boy_email);
	}

	public void searchDeliveryBoyByPhone(String del_boy_phone) {
		searchListPhoneField.sendKeys(del_boy_phone);
	}

	public String searchResultName() {
		return searchResultName.getText();
	}

	public String searchResultEmail() {
		return searchResultEmail.getText();
	}

	public String searchResultPhone() {
		return searchResultPhone.getText();
	}

	public String displayErrorMessage() {
		return alertMessage.getText();
	}

	public String displaySuccessMessage() {
		return successMessage.getText();
	}
	
	public String getNameOfUser(String username) {
		int index = 0;
		List<String> user_names = new ArrayList<String>();
		user_names = generalutility.getTextOfElements(userNames);
		for (index = 0; index < user_names.size(); index++) {
			if (username.equals(user_names.get(index))) {
				index++;
				break;
			}
		}
		WebElement delboy_name = driver.findElement(By.xpath("//table//tbody//tr["+index+"]//td[1]"));
		return delboy_name.getText();
	}
}
