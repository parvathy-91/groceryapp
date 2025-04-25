package testscripts;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import constants.Constants;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseClass {
	LoginPage login;
	HomePage home;

	@Test
	public void verifyUserLoginWithCorrectCredentials() throws IOException {

		login = new LoginPage(driver);
		login.loginByUsingExcelData();

		boolean isHomepageLoaded = login.iconText();
		Assert.assertTrue(isHomepageLoaded, Constants.LP_VERIFYLOGINWITHVALIDCREDENTIALS);

	}

	@Test
	public void verifyUserLoginWithValidUsernameAndIncorrectPassword() throws IOException {
		
		login = new LoginPage(driver);
		login.enterUsernameOnUsernameField("carol").enterPasswordOnPasswordField("admin").signIn();
		
		boolean alertmessageshown = login.alertshown();
		Assert.assertTrue(alertmessageshown, Constants.LP_ALERTMESSAGE);
	}

	@Test
	public void verifyUserLoginWithInvalidUsernameAndCorrectPassword() {
		
		login = new LoginPage(driver);
		login.enterUsernameOnUsernameField("carol").enterPasswordOnPasswordField("admin").signIn();
		
		boolean alertmessageshown = login.alertshown();
		Assert.assertTrue(alertmessageshown, Constants.LP_ALERTMESSAGE);
	}

	@Test(dataProvider = "inputCombinations")
	public void verifyUserLoginWithInvalidUsernameAndInvalidPassword(String username, String password) {
		
		login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).signIn();
		
		boolean alertmessageshown = login.alertshown();
		Assert.assertTrue(alertmessageshown, Constants.LP_ALERTMESSAGE);
	}

	@DataProvider
	public Object[][] inputCombinations() {
		return new Object[][] { { "ADMIN", "Admin" }, { "admin@", "admin78@" }, { "Qwerty", "1q2w3e" } };
	}
}