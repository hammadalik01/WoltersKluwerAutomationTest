package com.bddcucumberframework.pagesObject;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	public WebDriver driver;
	public HomePage homepage;
	
	public PageObjectManager(WebDriver driver) {			
		
		this.driver = driver;		
	}
		
	public HomePage getHomePage() {
		homepage = new HomePage(driver);
		return homepage;
	}
	


}
