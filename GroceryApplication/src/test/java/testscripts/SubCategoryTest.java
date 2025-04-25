package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.SubCategoryPage;

public class SubCategoryTest extends BaseClass {
	LoginPage login;
	HomePage home;
	SubCategoryPage subcategory;

	@Test(priority = 1, groups = "smoke")
	public void verifyAddNewSubcategoryWithValidDetails() throws IOException {
		login = new LoginPage(driver);
		home = login.loginByUsingExcelData();

		subcategory = home.clickOnSubCategory().clickOnNewButton().selectCategory().enterSubCategory().uploadImage()
				.clickOnSaveButton();

		boolean isAlertDisplayed = subcategory.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayed, Constants.SCADD_ALERTMESSAGE);

	}

	@Test(priority = 2)
	public void VerifyEditSubcategoryWithNewData() throws IOException {
		login = new LoginPage(driver);
		home = login.loginByUsingExcelData();

		subcategory = home.clickOnSubCategory().clickOnEditButton().editSubcategoryfield().updateOnCategory();

		boolean isAlertDisplayedOnUpdating = subcategory.isAlertDisplayed();
		Assert.assertTrue(isAlertDisplayedOnUpdating, Constants.SCEDIT_ALERTMESSAGE);

	}

	@Test(priority = 3, groups = "smoke")
	public void VerifyDeleteSubCategory() throws IOException {
		login = new LoginPage(driver);
		home = login.loginByUsingExcelData();

		subcategory = home.clickOnSubCategory().clickOnDeleteButton();

		boolean isAlertDisplayedOnDeleting = subcategory.isAlertDisplayedOnDeleting();
		Assert.assertTrue(isAlertDisplayedOnDeleting, Constants.SCDEL_ALERTMESSAGE);

	}

	@Test(priority = 4)
	public void verifySearchSubcategory() {
		login = new LoginPage(driver);
		home = login.enterUsernameOnUsernameField("admin").enterPasswordOnPasswordField("admin").signIn();

		subcategory = home.clickOnSubCategory().clickOnSearchButton().selectCategoryToBeSearched()
				.enterSubcategoryToBeSearched().clickOnFinalSearchButton();

		boolean testResults = subcategory.verifySearchResults();
		Assert.assertTrue(testResults, Constants.SCSEARCH_ALERTMESSAGE);

	}

}
