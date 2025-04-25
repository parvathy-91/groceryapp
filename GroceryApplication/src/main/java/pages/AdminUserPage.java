package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ExcelUtility;
import utilities.PageUtility;

public class AdminUserPage {

	public WebDriver driver;
	PageUtility page = new PageUtility();

	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newbutton;
	@FindBy(xpath = "//input[@id='username']")
	WebElement username;
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement usertype;
	@FindBy(xpath = "//i[@class='fa fa-save']")
	WebElement savebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement sucessalert;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchbutton;
	@FindBy(xpath = "//input[@id='un']")
	WebElement searchusername;
	@FindBy(xpath = "//select[@id='ut']")
	WebElement searchusertype;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> search;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement finalsearchbutton;

	public AdminUserPage clickOnNewButton() {
		newbutton.click();
		return this;
	}

	public AdminUserPage enterNameOnUsernameField() throws IOException {

		String uname = ExcelUtility.getStringdata(1, 0, "adminuser");
		username.sendKeys(uname + "_" + System.currentTimeMillis());
		return this;
	}

	public AdminUserPage enterPasswordOnPasswordField() throws IOException {
		String passkey = ExcelUtility.getStringdata(1, 1, "adminuser");
		password.sendKeys(passkey);
		return this;
	}

	public AdminUserPage selectUserType() {
		page.selectDropdownWithValue(usertype, "db");
		return this;
	}

	public AdminUserPage saveNewUser() {
		savebutton.click();
		return this;
	}

	public boolean isSucessAlertDisplayed() {
		return sucessalert.isDisplayed();
	}

	public AdminUserPage searchUser() {
		searchbutton.click();
		return this;
	}

	public AdminUserPage searchUserName(String username) {
		searchusername.sendKeys(username);
		return this;
	}

	public AdminUserPage searchUsertype(String usertype) {
		page.selectDropdownWithValue(searchusertype, usertype);
		return this;
	}

	public AdminUserPage finalSearchButton() {
		finalsearchbutton.click();
		return this;
	}

	public boolean verifySearchedUserExists(String input) {

		for (WebElement finalsearch : search) {
			if (finalsearch.getText().equals(input)) {
				System.out.println("Element found:" + finalsearch.getText());
				return true;
			}
		}
		System.out.println("No match found");
		return false;
	}
}
