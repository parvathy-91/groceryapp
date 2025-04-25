package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {

	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class=\"btn btn-rounded btn-danger\"]")
	WebElement newButton;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement updateManageNews;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveManageNews;
	@FindBy(xpath = "//i[@class='icon fas fa-check']")
	WebElement alertmessage;
	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement editManageNews;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement enterNewNews;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement updatebutton;

	public ManageNewsPage clickOnNewButtonInManageNews() {
		newButton.click();
		return this;
	}

	public ManageNewsPage enterNewsOnManageNews(String news) {
		updateManageNews.sendKeys(news);
		return this;
	}

	public ManageNewsPage clickSaveOnManageNews() {
		saveManageNews.click();
		return this;
	}

	public boolean isAlertShowingOnSavingNews() {
		return alertmessage.isDisplayed();
	}

	public ManageNewsPage editManageNews() {
		editManageNews.click();
		return this;
	}

	public ManageNewsPage editNewsOnManageNews(String editednews) {
		enterNewNews.clear();
		enterNewNews.sendKeys(editednews);
		return this;
	}

	public ManageNewsPage clickOnUpdateButton() {
		updatebutton.click();
		return this;
	}
}
