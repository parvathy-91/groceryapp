package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FakerUtility;
import utilities.PageUtility;

public class ManageContact {

	public WebDriver driver;

	public ManageContact(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	FakerUtility faker = new FakerUtility();
	PageUtility page = new PageUtility();

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/contact/edit_contact?edit=1']")
	WebElement editContactbutton;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement updatePhoneField;
	@FindBy(xpath = "//input[@id='email']")
	WebElement updateEmailField;
	@FindBy(xpath = "//textarea[@name='address']")
	WebElement updateAddressField;
	@FindBy(xpath = "//textarea[@name='del_time']")
	WebElement updateDeliveryTimeField;
	@FindBy(xpath = "//input[@name='del_limit']")
	WebElement updateDeliveryChargeLimitField;
	@FindBy(xpath = "//button[@name='Update']")
	WebElement updateButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement sucessAlert;

	public ManageContact clickOnEditInManageContacts() {
		editContactbutton.click();
		return this;
	}

	public ManageContact updateOnPhoneField() {
		updatePhoneField.clear();
		updatePhoneField.sendKeys(faker.generatePhone());
		return this;

	}

	public ManageContact updateOnEmailField() {
		updateEmailField.clear();
		updateEmailField.sendKeys(faker.generateEmail());
		return this;
	}

	public ManageContact updateOnAddressField() {
		updateAddressField.clear();
		updateAddressField.sendKeys(faker.generateAddress());
		return this;
	}

	public ManageContact updateOnDeliveryTimeField() {
		updateDeliveryTimeField.clear();
		updateDeliveryTimeField.sendKeys("5");
		return this;
	}

	public ManageContact updateOnDeliveryChargeLimitField() {
		updateDeliveryChargeLimitField.clear();
		updateDeliveryChargeLimitField.sendKeys("200");
		return this;
	}

	public ManageContact updateButtonOnManageContacts() {
		page.clickJavaScriptExecutor(updateButton, driver);
	
		return this;
	}

	public boolean isAlertDisplayed() {
		return sucessAlert.isDisplayed();
	}
}
