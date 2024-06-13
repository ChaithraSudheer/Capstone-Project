package scenario2PageObjectModel.TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {
	@Test(priority = 1)
	public void verifyUrl() {
		String cuurl = lp.getUrl();
		Assert.assertTrue(cuurl.contains("login"), "Fail:Url is not matched");
		System.out.println("Pass:Url is matched :" + cuurl);
	}

	@Test(priority = 2)
	public void verifyTitle() {
		String title = lp.getTitle();
		Assert.assertTrue(title.contains("Orange"), "Fail:Title is not matched");
		System.out.println("Title is matched: " + title);
	}

	@Test(priority = 3)
	public void verifyLogin() {
		String curl = lp.doLogin("Admin", "admin123");
		Assert.assertTrue(curl.contains("dashboard"), "Login is failed");
		System.out.println("Login is successful");
	}
}
