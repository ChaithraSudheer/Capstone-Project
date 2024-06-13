package scenario2PageObjectModel.TestCase;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

public class AdminTest extends BaseClass {

	@BeforeClass
	public void pagesetup() {
		System.out.println("**********Login Page***********");
		System.out.println("Url:" + lp.getUrl());
		System.out.println("Title is :" + lp.getTitle());
		lp.doLogin("Admin", "admin123");
	}

	@Test(priority = 1)
	public void verifymenu() {
		ap.getmenu();
		System.out.println("Admin Page is opened");
	}

	@Test(priority = 2)
	public void verifySearchByUserName() {
		ap.existingEmpSearchbyUsername("Admin");
	}

	@Test(priority = 3)
	public void verifySearchByUserRole() {
		ap.existingEmployeeSearchByUserRole();
	}

	@Test(priority = 4)
	public void verifySearchByUserStatus() {
		ap.existingEmpSearchByUserStatus();
	}
}
