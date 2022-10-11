package testFreeCRM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Calender;
import pages.CalenderForm;
import pages.HomePage;
import pages.LoginPage;

public class CalenderTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	Calender calenderPage;
	CalenderForm calenderform;

	public CalenderTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		calenderPage = new Calender();
		calenderPage = homepage.movingToCalender();
	}

	@Test
	public void clickOnDate() {
		while (true) {
			String monthYear = calenderPage.currentMonthYear();
			String month = monthYear.split(" ")[0].trim();
			System.out.println(month);
			String year = monthYear.split(" ")[1].trim();
			System.out.println(year);
			if (prop.getProperty("month").equalsIgnoreCase(month) && prop.getProperty("year").equals(year)) {
				break;
			} else {
				calenderPage.clickBackButton();
			}

		}

		List<WebElement> alldates = driver.findElements(By.xpath("//div[@class='rbc-day-bg']"));
		for (WebElement ele : alldates) {
			String dt= ele.getText();
			if (prop.getProperty("date").equalsIgnoreCase(dt)) {
				ele.click();
				break;
			}
		}

		Assert.assertEquals(calenderform, "This Test failed");
		
		

	}
	
	@Test
	public void getCalenderPageTitle() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Free CRM");
	}
	

	@AfterMethod
	public void closeBrowser() {

		driver.quit();
	}

}
