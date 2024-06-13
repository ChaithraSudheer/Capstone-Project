package scenario1_LoginModule;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class ScreenShot {
	@Test
	public void CaptureScreenshot() throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		// create object using driver
		TakesScreenshot ts = (TakesScreenshot) driver;

		// takes screenshot
		File temp = ts.getScreenshotAs(OutputType.FILE);

		// location-path
		File dest = new File("./" + "\\screenshot\\login1.png");

		// temp-->dest
		FileHandler.copy(temp, dest);

	}
}
