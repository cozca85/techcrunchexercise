package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	public static WebDriver open(String browserType)
	{
		if (browserType.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\cano\\Desktop\\QA test\\software\\geckodriver.exe");
			return new FirefoxDriver();
		}
		else 
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\cano\\Desktop\\QA test\\software\\chromedriver.exe");
			return new ChromeDriver();
		}
	}

}
