package com.sevenrmartsupermaket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermaket.bases.Base;
import com.sevenrmartsupermaket.dataproviders.DataProviderClass;
import com.sevenrmartsupermaket.pages.AdminUsersPage;
import com.sevenrmartsupermaket.pages.HomePage;
import com.sevenrmartsupermaket.pages.LoginPage;

public class AdminUsersPageTest extends Base {
	LoginPage login;
	HomePage homepage;
	AdminUsersPage adminuser;

	@Test(dataProvider = "AdminUsers", dataProviderClass = DataProviderClass.class)
	public void createNewAdminUsersWithDataProvider(String newUserName, String newPassword, String newUserType) {
		login = new LoginPage(driver);
		login.logIn();
		homepage = new HomePage(driver);
		homepage.clickOnAdminUsersLink();
		adminuser = new AdminUsersPage(driver);
		adminuser.createNewAdminUser(newUserName, newPassword, newUserType);
	}

//	@Test(dataProvider ="AdminUsersFromExcel", dataProviderClass = DataProviderClass.class )
//	public void createNewAdminUsersWithDataProvider(String newUserName, String newPassword, String newUserType) {
//		login = new LoginPage(driver);
//		login.logIn();
//		homepage = new HomePage(driver);
//		homepage.clickOnAdminUsersLink();
//		adminuser = new AdminUsersPage(driver);
//		adminuser.createNewAdminUser(newUserName, newPassword, newUserType);
//	}
//	
	@Test
	public void verifyUserIsDeactivated() {
		login = new LoginPage(driver);
		login.logIn();
		homepage = new HomePage(driver);
		homepage.clickOnAdminUsersLink();
		adminuser = new AdminUsersPage(driver);
		String initialStatus = adminuser.initialUserStatus("Leona");
		if (initialStatus.equals("Inactive")) {
			System.out.println("User is already deactivated");
		} else {
			adminuser.deactivateAdminUsers("Leona");
			String exp_statusMessage = "×\nAlert!\nUser Status Changed Successfully";
			String act_statusMessage = adminuser.userStatusMessage();
			Assert.assertEquals(act_statusMessage, exp_statusMessage);
		}
	}

}
