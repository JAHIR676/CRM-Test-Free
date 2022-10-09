package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CalenderForm extends TestBase{
	
	@FindBy(xpath= "//input[@name='title']")
	WebElement title;
	
	@FindBy(xpath = "//div[@name='category']")WebElement catagories;
	
	
	public CalenderForm() {
		PageFactory.initElements(driver, this);
	}
	
	
	

}
