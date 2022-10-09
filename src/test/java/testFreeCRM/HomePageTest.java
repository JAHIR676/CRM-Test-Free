package testFreeCRM;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Calender;
import pages.HomePage;
import pages.LoginPage;

public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;

	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void titleTest() {
		String title = homepage.title();
		System.out.println(title);
		Assert.assertEquals(title, "Free CRM");
	}

	@Test(priority = 2)
	public void logoTest() {
		boolean logoStatus = homepage.logo();
		Assert.assertTrue(logoStatus);
	}

	@Test(priority = 3)
	public void companyNameTest() {
		String companyName = homepage.companyName();
		Assert.assertEquals(companyName, prop.getProperty("companyName"));
	}

	@Test(priority = 4)
	public void homeMoveTest() {
		homepage.movingToHome();
	}

	@Test(priority = 5)
	public Calender calenderMoveTest() {
		return homepage.movingToCalender();
	}

	@AfterMethod
	public void browserclosed() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}
