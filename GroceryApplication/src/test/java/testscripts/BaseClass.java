package testscripts;

import constants.Constants;
import utilities.ScreenshotUtility;
import utilities.WaitUtility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseClass {
	FileInputStream fileinput;
	Properties properties;

	WaitUtility wait = new WaitUtility();

	public WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void initializeBrowserMethod(String browser) throws Exception {
		properties = new Properties();
		fileinput = new FileInputStream(Constants.CONFIGFILE);
		properties.load(fileinput);// reads the config file and loads its properties
		if (browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {

			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {

			driver = new FirefoxDriver();
		} else {
			throw new Exception("Invalid Browser");
		}
		driver.get(properties.getProperty("url"));

		driver.manage().window().maximize();
		wait.implicitWait(driver);

	}

	@AfterMethod(alwaysRun = true)
	public void driverQuit(ITestResult itestresult) throws IOException {
		if (itestresult.getStatus() == ITestResult.FAILURE) {
			ScreenshotUtility screenshot = new ScreenshotUtility();
			screenshot.getScreenshot(driver, itestresult.getName());
		}
		 driver.quit();
	}

}
