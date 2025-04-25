package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.PageUtility;

public class ManageNewsTest extends BaseClass {
	LoginPage login;
	HomePage home;
	ManageNewsPage news;
	PageUtility page=new PageUtility();

	@Test
	public void verifyAddNewsOnManageNews() throws IOException {

		login = new LoginPage(driver);
		home = login.loginByUsingExcelData();

		news = home.clickOnManageNews().clickOnNewButtonInManageNews()
				.editNewsOnManageNews("SUMMER CARNIVAL OFFER:50% OFF ON ALL ITEMS "+page.generateCurrentDateAndTime()).clickSaveOnManageNews();

		boolean alertOnSavingNews = news.isAlertShowingOnSavingNews();
		Assert.assertTrue(alertOnSavingNews, Constants.MN_ALERTMESSAGE);

	}

	@Test
	public void verifyEditNewsOnManageNews() throws IOException {

		login = new LoginPage(driver);
		home = login.loginByUsingExcelData();

		news = home.clickOnManageNews().editManageNews().editNewsOnManageNews("OFFERS ENDS SOON:GRAB YOURS"+page.generateCurrentDateAndTime())
				.clickOnUpdateButton();

		boolean alertOnSavingNews = news.isAlertShowingOnSavingNews();
		Assert.assertTrue(alertOnSavingNews, Constants.MN_ALERTMESSAGE);

	}
}
