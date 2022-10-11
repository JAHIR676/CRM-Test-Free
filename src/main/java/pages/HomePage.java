package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HomePage extends TestBase {
	
	//To handle mouse event
	Actions action = new Actions(driver);

	// Object repository of the page (OR).

	// Header Sections Objects.
	@FindBy(xpath = "//div[@class='header item']")
	WebElement logo;

	@FindBy(xpath = "//b[normalize-space()='BASSETTI INDIA PVT LTD']")
	WebElement companyName;

	@FindBy(xpath = "//span[@class='user-display']")
	WebElement userName;

	@FindBy(xpath = "//a[normalize-space()='Free account']")
	WebElement freeAccount;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchBox;

	@FindBy(xpath = "//div[@role='listbox']")
	WebElement settings;

	@FindBy(xpath = "//div[@class='ui buttons']//a[1]")
	WebElement settingsinsideSettings;

	@FindBy(xpath = "//span[normalize-space()='Products']")
	WebElement products;

	// Side bar objects.

	@FindBy(xpath = "//a[@href='/home']")
	WebElement home;

	@FindBy(xpath = "//div[contains(text(),'Contacts activity stream')]")
	WebElement contactActivity;

	@FindBy(xpath = "//span[normalize-space()='Calendar']")
	WebElement calender;

	@FindBy(xpath = "//span[normalize-space()='Contacts']")
	WebElement contacts;

	@FindBy(xpath = "//span[normalize-space()='Companies']")
	WebElement companies;

	@FindBy(xpath = "//div[normalize-space()='Trial']")
	WebElement currentPlan;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions of Homepage.

	public String title() {
		return driver.getTitle();
	}

	public boolean logo() {
		return logo.isDisplayed();
	}

	public String companyName() {
		return companyName.getText();
	}

	public String userName() {
		return userName.getText();
	}

	public void freeAccount() {
		freeAccount.click();
	}

	public boolean currentPlan() {
		return currentPlan.isDisplayed();
	}

	public void movingToHome() {
		Actions action = new Actions(driver);
		action.moveToElement(home).build().perform();
		home.click();
	}

	public Calender movingToCalender() {
		action.moveToElement(calender).build().perform();
		calender.click();
		return new Calender();

	}

}
