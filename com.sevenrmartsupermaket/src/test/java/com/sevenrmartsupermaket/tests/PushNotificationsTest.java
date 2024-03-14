package com.sevenrmartsupermaket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermaket.bases.Base;
import com.sevenrmartsupermaket.pages.HomePage;
import com.sevenrmartsupermaket.pages.LoginPage;
import com.sevenrmartsupermaket.pages.PushNotificationsPage;
import com.sevenrmartsupermaket.utilities.Excel;

public class PushNotificationsTest extends Base {
	LoginPage login;
	HomePage home;
	PushNotificationsPage pushnotification;
	Excel excel = new Excel();

	@Test
	public void verifyPushNotifications() {
		login = new LoginPage(driver);
		home = new HomePage(driver);
		pushnotification = new PushNotificationsPage(driver);
		login.logIn();
		home.clickOnPushNotificationLink();
		excel.setExcelFile("PushNotifications", "Notifications");
		pushnotification.sendNotifications(excel.getCellData(0, 0), excel.getCellData(0,1 ));
		boolean exp_successmsg = true;
		boolean act_successmsg = pushnotification.visibilityOfSuccessMessageBox();
		Assert.assertEquals(act_successmsg, exp_successmsg);
//		String act_successmsgbox = pushnotification.alertMessageGetText();
//		System.out.println(act_successmsgbox);
	}
	

	@Test
	public void verifyResetButtonFunctionality() {
		login = new LoginPage(driver);
		home = new HomePage(driver);
		pushnotification = new PushNotificationsPage(driver);
		login.logIn();
		home.clickOnPushNotificationLink();
		excel.setExcelFile("PushNotifications", "Notifications");
		pushnotification.resetNotifications(excel.getCellData(0, 0), excel.getCellData(0,1 ));
//		boolean exp_successmsgbox = true;
//		boolean act_successmsgbox = pushnotification.visibilityOfSuccessMessageBox();
//		Assert.assertEquals(act_successmsgbox, exp_successmsgbox);
	}
	
	@Test
	public void printExcelData() {
		excel.setExcelFile("LoginData", "Logins");
		System.out.println(excel.getCellData(0, 0));
		
	}
}
