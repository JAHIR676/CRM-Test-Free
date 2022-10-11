package testFreeCRM;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import base.TestBase;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginTitleTest() {
		String title = loginpage.title();
		Assert.assertEquals(title, "Free CRM");
	}
	
	@Test(priority=3)
	public void loginFunTest() {
		homePage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=3)
	public void allLinkTest() {
		loginpage.linkInPage();
	}
	

	@AfterMethod
	public void broswrclose() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}
