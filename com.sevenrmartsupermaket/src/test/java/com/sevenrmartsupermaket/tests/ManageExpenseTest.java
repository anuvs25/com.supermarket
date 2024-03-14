package com.sevenrmartsupermaket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermaket.bases.Base;
import com.sevenrmartsupermaket.pages.HomePage;
import com.sevenrmartsupermaket.pages.LoginPage;
import com.sevenrmartsupermaket.pages.ManageExpensePage;
import com.sevenrmartsupermaket.utilities.Excel;

public class ManageExpenseTest extends Base {
	LoginPage login;
	HomePage homepage;
	ManageExpensePage manageexpense;
	Excel excel = new Excel();

	@Test
	public void verifyNewExpenseCreation() {
		login = new LoginPage(driver);
		login.logIn();
		homepage = new HomePage(driver);
		homepage.clickOnManageExpenseLink();
		homepage.clickOnManageExpenseSubLink();
		manageexpense = new ManageExpensePage(driver);
		manageexpense.addExpenseEntry("Sumesh(PR)", "21-01-2024", "Grocery", "8", "8", "Credit Bank", "4350",
				"Paid for Grocery purchase");
		String exp_message = "×\nAlert!\nExpense Record Created Successfully";
		String act_message = manageexpense.displaySuccessMessage();
		Assert.assertEquals(act_message, exp_message);
	}

	@Test
	public void verifyMultipleExpenseCreationFromExcel() {
		login = new LoginPage(driver);
		login.logIn();
		homepage = new HomePage(driver);
		homepage.clickOnManageExpenseLink();
		homepage.clickOnManageExpenseSubLink();
		manageexpense=new ManageExpensePage(driver);
		excel.setExcelFile("ManageExpenseList", "ExpenseList");
		int i;
		for(i=1;i<=4;i++) {
			manageexpense.addExpenseEntry(excel.getCellData(i, 0),"13-01-2024",
					excel.getCellData(i, 2),excel.getCellData(i, 3),
					excel.getCellData(i, 4),excel.getCellData(i, 5),
					excel.getCellData(i, 6),excel.getCellData(i, 7));
			manageexpense.clickOnManageExpensesLink();
		}
	}

	@Test
	public void printExcelData() {
		excel.setExcelFile("ManageExpenseList", "ExpenseList");
		System.out.println(excel.getCellData(2, 1));

	}
}
