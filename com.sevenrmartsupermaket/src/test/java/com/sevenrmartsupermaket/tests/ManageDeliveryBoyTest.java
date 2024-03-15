package com.sevenrmartsupermaket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermaket.bases.Base;
import com.sevenrmartsupermaket.pages.HomePage;
import com.sevenrmartsupermaket.pages.LoginPage;
import com.sevenrmartsupermaket.pages.ManageDeliveryBoyPage;
import com.sevenrmartsupermaket.utilities.GeneralUtility;

public class ManageDeliveryBoyTest extends Base {
	LoginPage login;
	HomePage home;
	ManageDeliveryBoyPage deliveryboy;
	GeneralUtility generalutility= new GeneralUtility();
	
//	@Test (groups="smoke")
//	public void verifyDeliveryBoyCreation() {
//		login = new LoginPage(driver);
//		home = new HomePage(driver);
//		deliveryboy = new ManageDeliveryBoyPage(driver);
//		login.logIn();
//		home.clickOnManageDeliverBoyLink();
//		deliveryboy.createDeliveryBoy("Nandhu", "nandhu@123gmail.com", "9445687815", "TVM", "nandhutest",
//				"nandhu123@");
//		String expectedMssg = "×\nAlert!\nDelivery Boy Details Created Successfully";
//		String actualMssg = deliveryboy.displaySuccessMessage();
//		Assert.assertEquals(actualMssg, expectedMssg);
//	}
	
	@Test
	public void searchDeliveryBoyByName() {
		login = new LoginPage(driver);
		login.logIn();
		home = new HomePage(driver);
		home.clickOnManageDeliverBoyLink();
		deliveryboy = new ManageDeliveryBoyPage(driver);
		deliveryboy.clickOnSearch();
		deliveryboy.searchDeliveryBoyByName("Juno");
		deliveryboy.clickOnSearchListSearchButton();
		String exp_result = "Juno";
		String act_result = deliveryboy.searchResultName();
		Assert.assertEquals(act_result, exp_result);
	}
	
	@Test
	public void searchDeliveryBoyByEmail() {
		login = new LoginPage(driver);
		login.logIn();
		home = new HomePage(driver);
		home.clickOnManageDeliverBoyLink();
		deliveryboy = new ManageDeliveryBoyPage(driver);
		deliveryboy.clickOnSearch();
		deliveryboy.searchDeliveryBoyByName("Juno");
		deliveryboy.clickOnSearchListSearchButton();
		String exp_result = "luttusjunoos@gmail.com";
		String act_result = deliveryboy.searchResultEmail();
		Assert.assertEquals(act_result, exp_result);
	}
	

	@Test
	public void searchDeliveryBoyByPhone() {
		login = new LoginPage(driver);
		login.logIn();
		home = new HomePage(driver);
		home.clickOnManageDeliverBoyLink();
		deliveryboy = new ManageDeliveryBoyPage(driver);
		deliveryboy.clickOnSearch();
		deliveryboy.searchDeliveryBoyByName("Juno");
		deliveryboy.clickOnSearchListSearchButton();
		String exp_result = "8426579523";
		String act_result = deliveryboy.searchResultPhone();
		Assert.assertEquals(act_result, exp_result);
	}
	@Test
	public void verifyAddingDeliveryBoyFailsWithExistingUsername() {
		login = new LoginPage(driver);
		login.logIn();
		home = new HomePage(driver);
		home.clickOnManageDeliverBoyLink();
		deliveryboy = new ManageDeliveryBoyPage(driver);
		deliveryboy.createDeliveryBoy("Anandhu", "anandhu@123gmail.com", "9445687815", "TVM", "anandhu12345",
				"anandhu123@");
		String expectedErrorMssg = "�\nAlert!\nUsername already exists.";
		String actualErrorMssg = deliveryboy.displayErrorMessage();
		Assert.assertEquals(actualErrorMssg, expectedErrorMssg);
	}
}
