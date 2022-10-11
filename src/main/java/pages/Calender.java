package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Calender extends TestBase{
	
	
	//Objects Repository
	
	@FindBy(xpath="//span[@class='rbc-toolbar-label']")
	WebElement currentMonthYear;
	
	@FindBy(xpath="//i[@class='chevron right icon']")
	WebElement backButtonCalender;
	
	
	
	
	//Initialization of the page elements
	public Calender() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions in Calender.
	
	public String currentMonthYear() {
		return currentMonthYear.getText();
	}
	
	public void clickBackButton() {
		backButtonCalender.click();
	}

}