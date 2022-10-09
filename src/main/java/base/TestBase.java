package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.TestUtilities;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;

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

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtilities.imilicitlyTimeOuts));
		driver.get(url);
	}
}