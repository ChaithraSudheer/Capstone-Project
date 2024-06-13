package scenario2PageObjectModel.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	// declare driver as private
	// Encapsulation=data(Private)+Method(Public)
	private WebDriver driver;

	// initialize driver
	public LoginPage(WebDriver driver)// Base Class
	{
		this.driver = driver;
	}

	// locators-declaration
	// user name
	private By username = By.name("username");
	// password
	private By password = By.name("password");
	// login button
	private By loginbtn = By.xpath("//button[@type='submit']");

	// Methods-Public
	public String getUrl() {
		return driver.getCurrentUrl();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String doLogin(String un, String psw) {
		driver.findElement(username).sendKeys(un);
		driver.findElement(password).sendKeys(psw);
		driver.findElement(loginbtn).click();
		String curl = driver.getCurrentUrl();
		return curl;
	}
}
