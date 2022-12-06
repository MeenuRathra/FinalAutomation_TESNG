package bowserFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Init {
	
	static WebDriver driver;
	static String browser="chrome";
	

	public static WebDriver init() {

		if(browser.equalsIgnoreCase("Firefox"))
				{System.setProperty("webdriver.gecko.driver", "geckodriver\\geckodriver.exe");
		driver= new FirefoxDriver();}
		else if(browser.equalsIgnoreCase("chrome")) {System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver= new ChromeDriver();
		}
		driver.manage().deleteAllCookies();
		driver.get(" http://techfios.com/test/101/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		return driver;
		
	}

	public static void tearDown() {
		driver.close();
		driver.quit();
	}

}
    
	





