package com.sevenrmartsupermaket.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermaket.utilities.PageUtility;

public class ManageExpensePage {
	WebDriver driver;

	PageUtility pageutility;

	@FindBy(xpath = "//a[contains(text(),'New')]")
	WebElement newButton;

	@FindBy(xpath = "//select[@id='user_id']")
	WebElement userField;

	@FindBy(xpath = "//input[@id='ex_date']")
	WebElement dateField;

	@FindBy(xpath = "//div[@class='datepicker-days']//th[@class='datepicker-switch']")
	WebElement current_month_year;

	@FindBy(xpath = "//div[@class='datepicker-days']//th[@class='prev']")
	WebElement prev_btn;

	@FindBy(xpath = "//div[@class='datepicker-days']//th[@class='next']")
	WebElement next_btn;

	@FindBy(xpath = "//select[@id='ex_cat']")
	WebElement category;

	@FindBy(xpath = "//select[@id='order_id']")
	WebElement OrderId;

	@FindBy(xpath = "//select[@id='purchase_id']")
	WebElement purchaseId;

	@FindBy(xpath = "//select[@id='ex_type']")
	WebElement expenseType;

	@FindBy(xpath = "//input[@id='amount']")
	WebElement amount;

	@FindBy(xpath = "//textarea[@name='remarks']")
	WebElement remarks;
	
	@FindBy(xpath="//input[@name='userfile']")
	WebElement chooseFileButton;
	
	@FindBy(xpath = "//button[@name='create']")
	WebElement saveButton;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successMessage;
	
	@FindBy(xpath="(//p[contains(text(),'Manage Expense')])[2]")
	WebElement manageExpense;
	
	@FindBy(xpath="(//p[contains(text(),'Manage Expense')])[1]")
	WebElement manageExpenseLink;
	
	
	
	public ManageExpensePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickOnNewButton() {
		newButton.click();
	}

	public void selectUserName(String username) {
		pageutility = new PageUtility(driver);
		userField.click();
		pageutility.selectVisibleText(userField, username);
	}

	public void selectDate(String entrydate) {
		String Date = entrydate;
		String split[] = Date.split("-");
		String year = split[2];

		int m = Integer.parseInt(split[1]);
		int y = Integer.parseInt(split[2]);
		String day = split[0];

		String month = null;

		switch (m) {
		case 01:
			month = "January";
			break;
		case 2:
			month = "February";
			break;
		case 3:
			month = "March";
			break;
		case 4:
			month = "April";
			break;
		case 5:
			month = "May";
			break;
		case 6:
			month = "June";
			break;
		case 7:
			month = "July";
			break;
		case 8:
			month = "August";
			break;
		case 9:
			month = "September";
			break;
		case 10:
			month = "October";
			break;
		case 11:
			month = "November";
			break;
		case 12:
			month = "December";

		default:
			break;

		}

		String month_year = month + " " + year;
		dateField.click();

		while (true) {
			String current_month = current_month_year.getText();

			if (current_month.equals(month_year)) {
				break;
			} else if (y == 2024) {
				if (m > 3) {
					next_btn.click();
				} else {
					prev_btn.click();
				}
			} else if (y < 2024) {
				prev_btn.click();
			} else if (y > 2024) {
				next_btn.click();
			}
		}
		WebElement date = driver.findElement(By.xpath("//td[text()='" + day + "' and @class='day']"));
		date.click();
	}

	public void selectExpenseCategory(String exp_category) {
		pageutility = new PageUtility(driver);
		category.click();
		pageutility.selectVisibleText(category, exp_category);
	}

	public void selectOrderId(String exp_orderid) {
		pageutility = new PageUtility(driver);
		OrderId.click();
		pageutility.selectVisibleText(OrderId, exp_orderid);
	}

	public void selectPurchaseId(String exp_purchaseid) {
		pageutility = new PageUtility(driver);
		purchaseId.click();
		pageutility.selectVisibleText(purchaseId, exp_purchaseid);
	}

	public void selectExpenseType(String exp_type) {
		pageutility = new PageUtility(driver);
		expenseType.click();
		pageutility.selectVisibleText(expenseType, exp_type);
	}

	public void enterAmount(String exp_amount) {
		amount.sendKeys(exp_amount);
	}

	public void enterRemarks(String exp_remarks) {
		remarks.sendKeys(exp_remarks);
	}
	public void uploadFile(String location) {
		pageutility = new PageUtility(driver);
		pageutility.chooseFile(location, chooseFileButton);
	}
	public void clickOnSave() {
		pageutility = new PageUtility(driver);
		pageutility.mouseHover(saveButton);
		saveButton.click();
	}
	
	public void addExpenseEntry(String username, String entrydate, String exp_category, String exp_orderid, String exp_purchaseid,
			String exp_type,String exp_amount,String exp_remarks) {
		clickOnNewButton();
		selectUserName(username);
		selectDate(entrydate);
		selectExpenseCategory(exp_category);
		selectOrderId(exp_orderid);
		selectPurchaseId(exp_purchaseid);
		selectExpenseType(exp_type);
		enterAmount(exp_amount);
		enterRemarks(exp_remarks);
	}
	public String displaySuccessMessage() {
		return successMessage.getText();
	}
	public void clickOnManageExpensesLink() {
		manageExpenseLink.click();
		manageExpense.click();
	}
}
