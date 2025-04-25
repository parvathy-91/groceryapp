package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public WebDriver driver;

	public String selectDropdownWithValue(WebElement element, String value) {
		Select object = new Select(element);
		object.selectByValue(value);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}

	public String selectDropdownWithIndex(WebElement element, int value) {
		Select object = new Select(element);
		object.selectByIndex(value);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}

	public String selectDropdownWithVisibleText(WebElement element, String text) {
		Select object = new Select(element);
		object.selectByVisibleText(text);
		WebElement selectedElement = object.getFirstSelectedOption();
		return selectedElement.getText();
	}

	public void clickJavaScriptExecutor(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	public void scrollDownJavaScriptExecutor(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}

	public void scrollUntilElementIsViewable(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void rightClick(WebElement element, WebDriver driver) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	public void doubleClick(WebElement element, WebDriver driver) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	public void dragAndDrop(WebElement source, WebElement target, WebDriver driver) {
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).perform();
	}

	public void simpleAlert(WebElement element) {
		element.click();
		driver.switchTo().alert().accept();
	}

	public void confirmationAlert(WebElement element) {
		element.click();
		driver.switchTo().alert().accept();
	}

	public void promptAlert(WebElement element, String inputtext) {
		element.click();
		driver.switchTo().alert().sendKeys(inputtext);
		driver.switchTo().alert().accept();
	}

	public String generateCurrentDateAndTime() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyhhmmss");
		return formatter.format(date);
	}
}
