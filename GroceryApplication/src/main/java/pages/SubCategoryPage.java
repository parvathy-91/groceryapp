package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import constants.Constants;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class SubCategoryPage {

	public WebDriver driver;
	PageUtility page = new PageUtility();
	FileUploadUtility upload = new FileUploadUtility();
	WaitUtility wait=new WaitUtility();
	

	public SubCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newbutton;
	@FindBy(xpath = "//select[@class='form-control selectpicker']")
	WebElement categorydropdown;
	@FindBy(xpath = "//input[@id='subcategory']")
	WebElement subcategoryfield;
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement choosefile;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement savebutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement sucessAlert;
	
	
	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-primary btncss']")
	WebElement edit;
	@FindBy(xpath = "//button[@name='update']")
	WebElement update;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[1]")
	WebElement categoryName;
	@FindBy(xpath ="//a[@class='btn btn-sm btn btn-danger btncss']")
	WebElement delete;
	@FindBy(xpath = "//i[@class=' fa fa-search']")
	WebElement search;
	
	@FindBy(xpath = "//input[@class='form-control']")
	WebElement searchSubCategoryfield;
	@FindBy(xpath ="//button[@class='btn btn-danger btn-fix']")
	WebElement searchsubcategorybutton;
   @FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")List<WebElement> searchfield ;

	// methods for Adding new subcategory

	public SubCategoryPage clickOnNewButton() {
		newbutton.click();
		return this;
	}

	public SubCategoryPage selectCategory() {
		page.selectDropdownWithVisibleText(categorydropdown, "Electronics");	
		return this;
	}

	public SubCategoryPage enterSubCategory() {
		subcategoryfield.sendKeys("LASER PRINTER" + page.generateCurrentDateAndTime());
		return this;
	}

	public SubCategoryPage uploadImage() {
		String filepath = Constants.SUBCATEGIMAGE;
		upload.fileUploadSendkeys(choosefile, filepath);
		return this;
	}

	public SubCategoryPage clickOnSaveButton() {
		savebutton.click();
		return this;
	}
	
	public boolean isAlertDisplayed() {
		return sucessAlert.isDisplayed();
	}

	
	// Methods for edit the subcategory

	public SubCategoryPage clickOnEditButton() {
		edit.click();
		return this;
	}

	public SubCategoryPage editSubcategoryfield() {
		subcategoryfield.clear();
		subcategoryfield.sendKeys("PRINTER-HP" + page.generateCurrentDateAndTime());
		return this;
	}

	public SubCategoryPage updateOnCategory() {
		update.click();
		return this;
	}

	public boolean isAlertDisplayedOnUpdating() {
		return sucessAlert.isDisplayed();

	}
	// Methods for deleting the subcategory

	public SubCategoryPage clickOnDeleteButton() {
				
		delete.click();
		driver.switchTo().alert().accept();
		return this;
	}
	public boolean isAlertDisplayedOnDeleting() {
		return sucessAlert.isDisplayed();

	}
	// Methods for Search Subcategoryu]p

	public SubCategoryPage clickOnSearchButton() {
		search.click();
		return this;
	}

	public SubCategoryPage selectCategoryToBeSearched() {
		page.selectDropdownWithVisibleText(categorydropdown, "Electronics");
		return this;
	}

	public SubCategoryPage enterSubcategoryToBeSearched() {
		searchSubCategoryfield.sendKeys("PRINTER-HP220425021335");
		return this;
	}

	public SubCategoryPage clickOnFinalSearchButton() {
		searchsubcategorybutton.click();
		return this;
	}

	public boolean verifySearchResults() {
		String input = "PRINTER-HP220425021335";

		for (WebElement searchresult : searchfield) {
			if (searchresult.getText().equals(input)) {
				System.out.println("Element found:" + searchresult.getText());
				return true;
			}

		}
		System.out.println("No match found");
		return false;

	}

}
