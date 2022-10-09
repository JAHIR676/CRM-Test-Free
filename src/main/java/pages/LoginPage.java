package pages;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class LoginPage extends TestBase {

	List<String> urlList = new ArrayList<String>();

	// Object repository of the page (OR).
	@FindBy(xpath = "//input[@name='email']")
	WebElement emailF;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordF;
	
	@FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
	WebElement loginB;
	
	@FindBy(xpath = "//a[contains(text(), 'Forgot your password?')]")
	WebElement forgotP;
	
	@FindBy(xpath = "//a[contains(text(), 'Classic CRM')]")
	WebElement classicCRM;

	// Initialization of objects using constructor and LoginPage class.
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions to perform on the page.

	// Title of the page.
	public String title() {
		return driver.getTitle();

	}

	// Get Links of the page and check they working.
	public void linkInPage() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for (WebElement link : links) {
			String url = link.getAttribute("href");
			urlList.add(url);

		}

		long startTime = System.currentTimeMillis();
		urlList.parallelStream().forEach(e -> checkBrokenLink(e));
		long endTime = System.currentTimeMillis();
		System.out.println("Total time taken : " + (endTime - startTime));
	}

	public HomePage login(String userName, String password) {
		emailF.sendKeys(userName);
		passwordF.sendKeys(password);
		loginB.click();
		return new HomePage();

	}

	public void checkBrokenLink(String urlConn) {
		try {
			URL connection = new URL(urlConn);
			HttpURLConnection http = (HttpURLConnection) connection.openConnection();
			http.setConnectTimeout(5000);
			http.connect();

			if (http.getResponseCode() >= 400) {
				System.out.println(http.getResponseMessage() + "This is bad Link");
			}

			else {
				System.out.println(http.getResponseMessage() + "This link is working");
			}
		} catch (Exception e) {

		}

	}

}
