package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebElement;

public class FileUploadUtility {

	public void fileUploadSendkeys(WebElement element, String filepath) {

		element.sendKeys(filepath);
	}

	public void fileuploadrobotclass(WebElement element, String filepath) throws AWTException {

		element.click();
		StringSelection selection = new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);// copy the path to system clip
																						// board
		Robot robo = new Robot();
		robo.delay(500);
		robo.keyPress(KeyEvent.VK_CONTROL);// Press the control key
		robo.keyPress(KeyEvent.VK_V);// press the v key to paste
		robo.delay(500);
		robo.keyRelease(KeyEvent.VK_CONTROL);// Release the control key
		robo.keyRelease(KeyEvent.VK_V);// Release the V key
		robo.delay(500);
		robo.keyPress(KeyEvent.VK_ENTER);// Press the enter key
		robo.keyRelease(KeyEvent.VK_ENTER);// Release the enter key

	}

}
