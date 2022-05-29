package com.bddcucumberframework.pagesObject;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	WebDriver driver;
	public HelperPage helperPage;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.helperPage = new HelperPage(driver);		
	}
	
	
	//Element 
	By Heading = By.cssSelector("header[class='header'] h1");
	By inputTextField = By.xpath("//header/input[1]");
	By todoList = By.xpath("//ul[@class='todo-list']//li");
	By list= By.xpath("//div[@class='view']");
	By deleteButton =By.xpath("//button[@class='destroy']");
	By listRadioButton = By.xpath("//input[@class='toggle']");
	By itemCount = By.xpath("//span[@class='todo-count']");
	By clearButton= By.xpath("//button[normalize-space()='Clear completed']");

	
	public String getUrlOfPage() {		
		return driver.getCurrentUrl();		
	}
	
	
   public String headingOfHomePage(){
	        //return driver.getTitle();
	    	String Title = driver.findElement(Heading).getText();
	    	return Title;
   }
   
   
   public void enterTextInInputField(String Text) {
	   
	   WebElement inputField = driver.findElement(inputTextField);		
	   inputField.sendKeys(Text);	   
   }
   
  public void PressEnter() {	   
	   WebElement inputField = driver.findElement(inputTextField);	
	   inputField.sendKeys(Keys.ENTER);	   
   }
  
  public void deleteSingleRecord() throws Exception {
	    
		WebElement ListRecord = driver.findElement(list);		
		helperPage.actionMoveAndHover(ListRecord);				
		WebElement singledeleteButton = driver.findElement(deleteButton);		
		singledeleteButton.click();
	
  }
  
  
  
  public int getListOnHamePage() {
	  
	  List<WebElement> m= driver.findElements(todoList);
	   int sizeOfToDoList = m.size();
	   return sizeOfToDoList;
  
  }
  
  public void editSingleRecord() {
	  
		Actions act = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//div[@class='view']")); 
		act.doubleClick(ele).perform();		
		driver.findElement(By.xpath("//li[@class='editing']")).click();
	    driver.findElement(By.cssSelector("input.edit")).sendKeys(" edit");
	    driver.findElement(By.cssSelector("input.edit")).sendKeys(Keys.ENTER);	
  }
  
  
  
  public String getListLable() {	 
	  
	  String result = driver.findElement(list).getText();
	  return result;
	  
  }
  
  public void addMultipleItems() {
	  
		WebElement inputField = driver.findElement(inputTextField);		
		
		for (int i = 0; i < 3; i++) {
		    
			inputField.sendKeys("Add Record"+i);
			inputField.sendKeys(Keys.ENTER);
		}	
		
	  
  }
  
  public void SelectCheckBoxesOfAllitems() {	  
		
		List<WebElement> els = driver.findElements(listRadioButton);
		for ( WebElement el : els ) {
		    if ( !el.isSelected() ) {
		        el.click();
		    }
		}	
	  
	  
  }
  
  public int getCountItemsLeft() {
	  
		String itemsleft = driver.findElement(itemCount).getText();		
		String[] parts = itemsleft.split(" ");
	    String ExpectedItem = parts[0].trim();
	    int leftitem = Integer.parseInt(ExpectedItem);
	    //System.out.println("Expected count of"+" "+ leftitem);
	    return leftitem;
	    
	    
	  
  }
  
  public void clearList() {
	  
	  driver.findElement(clearButton).click();
  }
  
  
  
  
   
   
   
   
	
	

	
		

	
	
	
	
	


	
}
