package rough;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class First2 {

	public static void main(String[] args) throws InterruptedException {
		
		//WebElement element = driver.findElement(By.id("id"));
		
		System.setProperty("webdriver.chrome.driver" , "C:\\WebProject\\CucumberFramework\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://todomvc.com/examples/angular2/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		 
		WebElement inputField = driver.findElement(By.xpath("//header/input[1]"));		
		for (int i = 0; i < 3; i++) {
		    
			inputField.sendKeys("Add Record"+i);
			inputField.sendKeys(Keys.ENTER);
		}	
		
		//By.xpath("//input[@class='toggle']")
		
		List<WebElement> els = driver.findElements(By.xpath("//input[@class='toggle']"));
		for ( WebElement el : els ) {
		    if ( !el.isSelected() ) {
		        el.click();
		    }
		}	
		
		
		
		String itemsleft = driver.findElement(By.xpath("//span[@class='todo-count']")).getText();		
		String[] parts = itemsleft.split(" ");
	    String ExpectedItem = parts[0].trim();
	    int i=Integer.parseInt(ExpectedItem); 
	    System.out.println("Expected count of"+" "+ i);
	    
	    driver.findElement(By.xpath("//button[normalize-space()='Clear completed']")).click();
		
		
		
		
		
	
		
        
		
		
		
		//ele.sendKeys("Edit");
		//driver.findElement(By.xpath("//button[@class='destroy']")).click();
		//List<WebElement> m= driver.findElements(By.xpath("//ul[@class='todo-list']//li"));
		//if ( m.size() > 0){
	        //System.out.println("Text: is present.");
	    //}
	    //else{
	         //System.out.println("Text: is not present.");
	    //}
		 
		 
	 
	}

}
