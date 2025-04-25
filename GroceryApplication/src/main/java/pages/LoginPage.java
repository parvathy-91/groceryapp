
package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ExcelUtility;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {// constructor should be declared in all pages
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement usernamefield;
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordfield;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement signinbutton;
	@FindBy(xpath = "//span[text()='7rmart supermarket']")
	WebElement icontext;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible' ]")
	WebElement alertmessage;

	public LoginPage enterUsernameOnUsernameField(String username) {
		usernamefield.sendKeys(username);
		return this;
	}

	public LoginPage enterPasswordOnPasswordField(String password) {
		passwordfield.sendKeys(password);
		return this;
	}

	public HomePage signIn() {
		signinbutton.click();
		return new HomePage(driver);
	}

	public boolean iconText() {
		return icontext.isDisplayed();
	}

	public boolean alertshown() {
		return alertmessage.isDisplayed();
	}

	public HomePage loginByUsingExcelData() throws IOException {
		String username = ExcelUtility.getStringdata(1, 0, "login");
		String password = ExcelUtility.getStringdata(1, 1, "login");
		usernamefield.sendKeys(username);
		passwordfield.sendKeys(password);
		signinbutton.click();
		return new HomePage(driver);

	}
}
