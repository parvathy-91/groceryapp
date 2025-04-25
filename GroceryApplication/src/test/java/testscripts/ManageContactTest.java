package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContact;

public class ManageContactTest extends BaseClass {
	LoginPage login;
	HomePage home;
	ManageContact contact;

	@Test
	public void verifyUserCanUpdateContactsOnManageContacts() throws IOException {
		login = new LoginPage(driver);
		home = login.loginByUsingExcelData();

		contact = home.clickOnManageContact().clickOnEditInManageContacts().updateOnPhoneField().updateOnEmailField()
				.updateOnAddressField().updateOnDeliveryTimeField().updateOnDeliveryChargeLimitField()
				.updateButtonOnManageContacts();

		boolean alertMessage = contact.isAlertDisplayed();
		Assert.assertTrue(alertMessage, Constants.MC_ALERTMESSAGE);

	}
}
