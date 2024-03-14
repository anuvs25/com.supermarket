package com.sevenrmartsupermaket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermaket.bases.Base;
import com.sevenrmartsupermaket.pages.HomePage;
import com.sevenrmartsupermaket.pages.LoginPage;
import com.sevenrmartsupermaket.utilities.GeneralUtility;
import com.sevenrmartsupermaket.utilities.ScreenShot;

public class LoginTest extends Base {
	LoginPage login;
	HomePage homepage;

	@Test(groups = "smoke")
	public void verifyLogin() {
		login = new LoginPage(driver);
		homepage = new HomePage(driver);
		login.logIn("abcd563814", "qwerty24");
		String expectedProfileName = "Abcd563814";
		String actualProfileName = homepage.getProfileName();
		// System.out.println(GeneralUtility.getRandomFirstName());
		//ScreenShot.takeScreenShot(driver, "Test");
		Assert.assertEquals(actualProfileName, expectedProfileName);
	}

	//@Test(retryAnalyzer = com.sevenrmartsupermaket.listeners.RetryAnalyzer.class)
	@Test
	public void verifyErrorMessageWithInvalidCredentials() {
		login = new LoginPage(driver);
		login.logIn("abcd563814", "123456");
		String expectedErrorMssg = "×\nAlert!\nInvalid Username/Password";
		String actualErrorMssg = login.displayErrorMessage();
		//System.out.println(actualErrorMssg.trim());
		Assert.assertEquals(actualErrorMssg, expectedErrorMssg);
	}

}
