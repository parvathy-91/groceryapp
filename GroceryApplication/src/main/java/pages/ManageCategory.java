package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageCategory {

	public WebDriver driver;

	public ManageCategory(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	FileUploadUtility upload = new FileUploadUtility();
	PageUtility page = new PageUtility();
	WaitUtility wait = new WaitUtility();

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newbutton;
	@FindBy(xpath = "//input[@id='category']")
	WebElement categorybutton;
	@FindBy(xpath = "//li[@id='134-selectable']")
	WebElement selectgroup;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement imageupload;
	@FindBy(xpath = "//input[@name='top_menu'and @value='no']")
	WebElement showtopmenu;
	@FindBy(xpath = "//input[@name='show_home'and @value='no']")
	WebElement showleftmenu;
	@FindBy(xpath = "//button[@name='create']")
	WebElement createcategory;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement sucessalert;
	@FindBy(xpath = "//label[text()='Show On Top Menu']")
	WebElement showtitle;

	public ManageCategory clickOnNewButton() {
		newbutton.click();
		return this;
	}

	public ManageCategory enterCategoryOnCategoryField() {
		categorybutton.sendKeys("Hair Fashions" + page.generateCurrentDateAndTime());
		return this;
	}

	public ManageCategory selectGroupofCategoryToBeAdded() {
		selectgroup.click();
		return this;
	}

	public ManageCategory uploadImageOfCategory() {
		wait.waitUntilElementIsVisible(driver, imageupload);
		String filepath = Constants.CATEGORYIMAGE;
		upload.fileUploadSendkeys(imageupload, filepath);
		return this;

	}

	public ManageCategory showOnTopMenuSelection() {
		page.scrollDownJavaScriptExecutor(driver);
		page.clickJavaScriptExecutor(showtopmenu, driver);

		if (!showtopmenu.isSelected()) {
			showtopmenu.click();
		}
		return this;
	}

	public ManageCategory showOnLeftMenuSelection() {
		if (showleftmenu.isSelected()) {
			showleftmenu.click();
		}
		return this;
	}

	public ManageCategory saveCategory() {
		page.clickJavaScriptExecutor(createcategory, driver);
		return this;

	}

	public boolean alertShowingOnSaveCategory() {
		return sucessalert.isDisplayed();
	}
}
