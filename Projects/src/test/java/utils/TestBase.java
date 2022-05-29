package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public WebDriver driver;
	public Properties pro;
	
	public WebDriver webDriverManager() throws IOException {
		
		if (driver == null)
		{
			
			Properties pro = new Properties();
			//FileOutputStream  fs = new FileOutputStream(+"\\resources\\config.properties");
			FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
			pro.load(file);
			
			String URL = pro.getProperty("url");			
			String browser = pro.getProperty("browser");
			
			if (browser.equalsIgnoreCase("chrome")) {				
			   System.setProperty("webdriver.chrome.driver" , System.getProperty("user.dir") +"\\drivers\\chromedriver.exe");
			   driver = new ChromeDriver();    }
			
			else if (browser.equalsIgnoreCase("firefox")) {				
		       System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +"\\drivers\\geckodriver.exe");
		       driver = new FirefoxDriver();       		       
			}
			
			driver.get(URL);
			driver.manage().window().maximize();		
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(pro.getProperty("implicit.wait")),TimeUnit.SECONDS);
		

		}
		
		return driver;
		
	}

}
