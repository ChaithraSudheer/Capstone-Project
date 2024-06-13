package scenario1_LoginModule;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import helper.utility;

public class Login_LogoutTest {

	public WebDriver driver;

	@Test(priority = 1, dataProvider = "ExcelData", dataProviderClass = Customedata.class)
	public void loginTest(String un, String psw) throws InterruptedException {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		Assert.assertTrue(driver.getCurrentUrl().contains("orangehrmlive"), 
				"Url is not matched");
		System.out.println("Url is matched");

		System.out.println("Title of the page is: " + driver.getTitle());

		Assert.assertTrue(driver.getTitle().contains("HRM"), "Title is nor matched");
		System.out.println("Title is matched");

		driver.findElement(By.name("username")).sendKeys(un);
		driver.findElement(By.name("password")).sendKeys(psw);
		driver.findElement(By.className("orangehrm-login-button")).click();

		Thread.sleep(2000);

		utility.captureScreenshot(driver);

		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), 
				"Login is unsuccessfull");
		System.out.println("Login is successfull");

	}

	@Test(priority = 2, dependsOnMethods = "loginTest")
	public void logoutTest() throws InterruptedException {
		// driver.findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill
		// oxd-userdropdown-icon']")).click();

		List<WebElement> dd = driver.findElements(By.xpath("//ul[@class='oxd-dropdown-menu']//li//a"));
		System.out.println("Total options in the dropdown are: " + dd.size());

		for (WebElement i : dd) {
			System.out.println(i.getText());
			if (i.getText().contains("Logout")) {
				i.click();
				break;
			}
		}
	}
}
