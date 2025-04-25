package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.AdminUserPage;
import pages.HomePage;
import pages.LoginPage;

public class AdminUserTest extends BaseClass {
	LoginPage login;
	HomePage home;
	AdminUserPage adminuser;

	@Test
	public void verifySucessUserCreation() throws IOException {

		login = new LoginPage(driver);
		home = login.loginByUsingExcelData();

		adminuser = home.clickOnAdminUsers().clickOnNewButton().enterNameOnUsernameField()
				.enterPasswordOnPasswordField().selectUserType().saveNewUser();

		boolean sucessAlert = adminuser.isSucessAlertDisplayed();
		Assert.assertTrue(sucessAlert, Constants.ADDUSER_ALERTMESSAGE);
	}

	@Test(priority = 1)
	public void verifySearchingExistingUser() throws IOException {
		login = new LoginPage(driver);
		home = login.loginByUsingExcelData();

		adminuser = home.clickOnAdminUsers().searchUser().searchUserName("support").searchUsertype("staff")
				.finalSearchButton();

		boolean userExists = adminuser.verifySearchedUserExists("support");
		Assert.assertTrue(userExists, Constants.SEARCHUSER_ALERTMESSAGE);

	}
}
