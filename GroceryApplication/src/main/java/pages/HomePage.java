package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category']")
	WebElement subcategorylink;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact']")
	WebElement managecontactlink;
	@FindBy(xpath = "//a[@href=\"https://groceryapp.uniqassosiates.com/admin/list-news\"]")
	WebElement managenewslink;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and text()='More info ']")
	WebElement adminuserslink;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']")
	WebElement managecategorylink;

	public SubCategoryPage clickOnSubCategory() {
		subcategorylink.click();
		return new SubCategoryPage(driver);
	}

	public ManageContact clickOnManageContact() {
		managecontactlink.click();
		return new ManageContact(driver);
	}

	public ManageNewsPage clickOnManageNews() {
		managenewslink.click();
		return new ManageNewsPage(driver);
	}

	public AdminUserPage clickOnAdminUsers() {

		adminuserslink.click();
		return new AdminUserPage(driver);
	}

	public ManageCategory clickOnManageCategory() {
		managecategorylink.click();
		return new ManageCategory(driver);
	}
}
