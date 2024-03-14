package com.sevenrmartsupermaket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermaket.bases.Base;
import com.sevenrmartsupermaket.pages.HomePage;
import com.sevenrmartsupermaket.pages.LoginPage;
import com.sevenrmartsupermaket.pages.ManageLocationPage;

public class ManageLocationPageTest extends Base {
	LoginPage login;
	HomePage home;
	ManageLocationPage location;
	
	@Test(groups={"smoke","regression"})
	public void verifyNewLocationCreation() {
		login = new LoginPage(driver);
		home = new HomePage(driver);
		location = new ManageLocationPage(driver);
		login.logIn();
		home.clickOnManageLocationLink();
		location.createNewLocation();
	}
	
	@Test(groups="regression")
	public void verifySearchLocation() {
		login = new LoginPage(driver);
		login.logIn();
		home = new HomePage(driver);
		home.clickOnManageLocationLink();
		location = new ManageLocationPage(driver);
		location.searchAddedLocation("United Kingdom", "Antarctica");
		String exp_result = "Antarctica";
		String act_result = location.searchLocationResult();
		System.out.println(act_result);
		Assert.assertEquals(act_result, exp_result);
		
	}
}
