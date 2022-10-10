package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.TestUtilities;
import utilities.WebEventListner;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	@SuppressWarnings("deprecation")
	public static EventFiringWebDriver eventDriver;
	public static WebEventListner eventListener;
	

	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream file = new FileInputStream("C:\\Users\\testi\\OneDrive\\Desktop\\Java Testing\\"
					+ "testFreeCRM\\src\\main\\java\\configFiles\\config.properties");
			prop.load(file);
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void initialization() {
		String browser = prop.getProperty("browsername");
		String url = prop.getProperty("url");
		if (browser.equals("chrome")) {
			driver = WebDriverManager.chromedriver().create();
		} else if (browser.equals("Firefox")) {
			driver = WebDriverManager.firefoxdriver().create();
		} else if (browser.equals("Edge")) {
			driver = WebDriverManager.edgedriver().create();
		}
		
		eventDriver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListner();
		eventDriver.register(eventListener);
		driver = eventDriver;
		

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtilities.imilicitlyTimeOuts));
		driver.get(url);
	}
}