package scenario2PageObjectModel.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminPage {
	// declare driver as private
	private WebDriver driver;

	// initialize driver
	public AdminPage(WebDriver driver) {
		this.driver = driver;
	}

	// locators
	// menu list
	private By menu = By.xpath("//ul[@class='oxd-main-menu']//li");
	// user name text box
	private By username = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
	// search button
	private By serachbutton = By.xpath("//button[@type='submit']");
	// result
	private By result = By.xpath("(//div//span[@class='oxd-text oxd-text--span'])[1]");
	// user name record
	private By record = By.xpath("//div[@class='oxd-table-card']");
	// role drop down
	private By userroledd = By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]");
	// user role options
	private By userroleoptions = By.xpath("//div[@role='listbox']");
	// status drop down
	private By userstatus = By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]");
	// status options
	private By statusoptions = By.xpath("//div[@class='oxd-select-dropdown --positon-bottom']");

	// user role record
	// private By
	// rolerecord=By.xpath("//div[@class='orangehrm-container']//div[@class='oxd-table-card']");
	// User status records
	// private By
	// enableresult=By.xpath("//div[@class='oxd-table-body']//div[@class='oxd-table-card']");

	// Methods
	public void getmenu() {
		System.out.println("****** Menu List ************");
		List<WebElement> mn = driver.findElements(menu);

		System.out.println("Total options in the menu are: " + mn.size());

		for (WebElement i : mn) {
			System.out.println("Options in the menu are: " + i.getText());
			if (i.getText().contains("Admin")) {
				i.click();
				break;
			}
		}
	}

	public void existingEmpSearchbyUsername(String un) {
		System.out.println("************Employee Search By UserName*************");
		driver.findElement(username).sendKeys(un);
		driver.findElement(serachbutton).click();
		System.out.println("Total Records found for Username is: " 
		    + driver.findElement(result).getText());
		String resultdata = driver.findElement(record).getText();
		System.out.println("Result data of Username Admin is:" + resultdata);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.navigate().refresh();
	}

	public void existingEmployeeSearchByUserRole() {
		System.out.println("***********Employee Search By User Role**********");
		driver.findElement(userroledd).click();
		List<WebElement> ddoptions = driver.findElements(userroleoptions);
		for (WebElement i : ddoptions) {
			System.out.println("Options in dropdown:" + i.getText());
			if (i.getText().contains("Admin")) {
				i.click();
				break;
			}
		}
		driver.findElement(serachbutton).click();
		System.out.println("Total Records found for UserRole is: " 
		       + driver.findElement(result).getText());

		/*
		 * List<WebElement> roleresult=driver.findElements(rolerecord); for(WebElement
		 * i:roleresult) {
		 * System.out.println("Result data of User Role Admin is: "+i.getText()); }
		 */

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.navigate().refresh();
	}

	public void existingEmpSearchByUserStatus() {
		System.out.println("************Employee Search By User Status************");
		driver.findElement(userstatus).click();
		List<WebElement> status = driver.findElements(statusoptions);
		for (WebElement i : status) {
			System.out.println("User status options are: " + i.getText());
			if (i.getText().contains("Enabled")) {
				i.click();
				break;
			}
		}
		driver.findElement(serachbutton).click();
		System.out.println("Total Records found for User Status is: " 
		    + driver.findElement(result).getText());

		/*
		 * List<WebElement> statusdisplay=driver.findElements(enableresult);
		 * for(WebElement i:statusdisplay) { System.out.println(i.getText()); }
		 */
	}

}
