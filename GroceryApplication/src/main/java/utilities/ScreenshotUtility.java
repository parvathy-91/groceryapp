package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

//Takes the screenshot automatically when the testcase failed
public class ScreenshotUtility {

	public void getScreenshot(WebDriver driver, String failedtestcase) throws IOException {// the name of the testcase
																							// that failed
		TakesScreenshot scrShot = (TakesScreenshot) driver; // TakesScreenshot-interface in selenium to take screenshot
															// and typecasting driver
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE); // captured screenshot will get saved in a temp path
																	// in a file format,getSCreenshot is a method in the
																	// interface
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());// to generate current date
																							// and time to make the
																							// screenshot unique
		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot"); // to get the project directory and
																					// create a folder outputscreenshot
																					// for saving screenshot

		if (!f1.exists()) {// to avoid generation of outputscreenshot folder multiple times
			f1.mkdirs(); // mkdir -->if folder not exists it will create folder using java
		}
		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedtestcase + timeStamp
				+ ".png";// constructs the full path for screenshot file
		File finalDestination = new File(destination);// Creates a new File object representing the final location where
														// the screenshot will be saved.

		FileHandler.copy(screenShot, finalDestination); // copy screenshot from temporary folder to project folder

	}
}
