package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageCategory;

public class ManageCategoryTest extends BaseClass {
	LoginPage login;
	HomePage home;
	ManageCategory category;

	@Test
	public void verifyAddNewCategory() {
		login = new LoginPage(driver);
		home = login.enterUsernameOnUsernameField("admin").enterPasswordOnPasswordField("admin").signIn();

		category = home.clickOnManageCategory().clickOnNewButton().enterCategoryOnCategoryField()
				.selectGroupofCategoryToBeAdded().uploadImageOfCategory().showOnTopMenuSelection()
				.showOnLeftMenuSelection().saveCategory();

		boolean alertshowed = category.alertShowingOnSaveCategory();
		Assert.assertTrue(alertshowed, Constants.CATADD_ALERTMESSAGE);
	}
}
