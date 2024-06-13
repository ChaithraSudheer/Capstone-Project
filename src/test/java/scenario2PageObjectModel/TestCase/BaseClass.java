package scenario2PageObjectModel.TestCase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import scenario2PageObjectModel.Pages.AdminPage;
import scenario2PageObjectModel.Pages.LoginPage;

public class BaseClass {
	public WebDriver driver;
	public LoginPage lp;
	public AdminPage ap;

	@BeforeTest
	public void setupBrowser() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		lp = new LoginPage(driver);
		ap = new AdminPage(driver);
	}

}
