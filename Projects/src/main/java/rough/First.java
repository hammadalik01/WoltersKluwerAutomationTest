package rough;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class First {

	public static void main(String[] args) throws InterruptedException {
		
		//WebElement element = driver.findElement(By.id("id"));
		
		System.setProperty("webdriver.chrome.driver" , "C:\\WebProject\\CucumberFramework\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://todomvc.com/examples/angular2/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		//Get title of page and Url 
		 String Title = driver.findElement(By.cssSelector("header[class='header'] h1")).getText();
		 System.out.println(Title);
		 System.out.println(driver.getCurrentUrl());
		 
		 
		 //
		 WebElement inputField = driver.findElement(By.xpath("//header/input[1]"));
		 inputField.sendKeys(" ");
		 inputField.sendKeys(Keys.ENTER);
	
		 
		 List<WebElement> m= driver.findElements(By.xpath("//ul[@class='todo-list']//li"));
		 
		 
		 if ( m.size() > 0){
	         System.out.println("Text: is present.");
	      }
	      else{
	         System.out.println("Text: is not present.");
	      }
		
		 //System.out.println(list.getSize());
		 
		 
	 
	}

}
