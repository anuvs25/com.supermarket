package com.sevenrmartsupermaket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermaket.utilities.PageUtility;
import com.sevenrmartsupermaket.constants.Constants;

public class ManageLocationPage {
	WebDriver driver;
	Properties properties = new Properties();
	PageUtility pageutility;
	
	@FindBy(xpath = "//a[contains(text(),'New')]")
	WebElement newLocation;

	@FindBy(xpath = "//select[@name='country_id']")
	WebElement selectCountry;

	@FindBy(xpath = "//select[@name='state_id']")
	WebElement selectState;

	@FindBy(xpath = "//input[@name='location']")
	WebElement addLocation;

	@FindBy(xpath = "//input[@name='delivery']")
	WebElement deliveryCharge;

	@FindBy(xpath = "//button[@name='create']")
	WebElement saveButton;

	@FindBy(xpath = "//a[text()='Cancel']")
	WebElement cancelButton;

	@FindBy(xpath = "//a[contains(text(),'Search')]")
	WebElement SearchButton;

	@FindBy(xpath = "//select[@id='country_id']")
	WebElement searchListCountry;

	@FindBy(xpath = "//input[@name='location']")
	WebElement searchListLocation;

	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchListSearchButton;

	@FindBy(xpath = "//table//tbody//tr//td[1]")
	WebElement locationResult;

	public ManageLocationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		try {
			FileInputStream fi = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(fi);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void clickOnNewButton() {
		newLocation.click();
	}

	public void selectCountry() {
		pageutility = new PageUtility(driver);
		pageutility.selectVisibleText(selectCountry, "United Kingdom");
	}

	public void selectState() {
		pageutility = new PageUtility(driver);
		pageutility.selectVisibleText(selectState, "North Yorkshire");
	}

	public void addNewPlace(String place) {
		addLocation.sendKeys(place);
	}

	public void addDeliveryCharge(String price) {
		deliveryCharge.sendKeys(price);
	}

	public void clickOnSaveButton() {
		saveButton.click();
	}

	public void clickOnCancelButton() {
		cancelButton.click();
	}

	public void clickOnSearchButton() {
		SearchButton.click();
	}

	public void searchLocationCountry(String searchCountry) {
		pageutility = new PageUtility(driver);
		pageutility.selectVisibleText(searchListCountry, searchCountry);
	}
	
	public void searchLocation(String searchLocation) {
		searchListLocation.sendKeys(searchLocation);
	}
	
	public void clickOnSearchListSearchButton() {
		searchListSearchButton.click();
	}

	public String searchLocationResult() {
		return locationResult.getText();
	}

	public void createNewLocation() {
		clickOnNewButton();
		selectCountry();
		selectState();
		String place = properties.getProperty("place");
		addNewPlace(place);
		String price = properties.getProperty("price");
		addDeliveryCharge(price);
		clickOnSaveButton();
	}

	public void createNewLocation(String place, String price) {
		clickOnNewButton();
		selectCountry();
		selectState();
		addNewPlace(place);
		addDeliveryCharge(price);
		clickOnSaveButton();
	}

	public void searchAddedLocation(String searchCountry,String searchLocation) {
		clickOnSearchButton();
		searchLocationCountry(searchCountry);
		searchLocation(searchLocation);
		clickOnSearchListSearchButton();
	}
	

}
