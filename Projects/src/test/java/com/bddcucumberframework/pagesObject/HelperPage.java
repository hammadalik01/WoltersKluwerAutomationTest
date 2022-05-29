package com.bddcucumberframework.pagesObject;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class HelperPage {

    WebDriver driver;
    protected WebDriverWait wait;

    public HelperPage(WebDriver driver){

        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);

    }



    /**********************************************************************************
     **WAIT METHODS
     **********************************************************************************/
    public boolean WaitUntilWebElementIsVisible(WebElement element) {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(element));
            System.out.println("WebElement is visible using locator: " + "<" + element.toString() + ">");
            return true;
        } catch (Exception e) {
            System.out.println("WebElement is NOT visible, using locator: " + "<" + element.toString() + ">");
            Assert.fail("WebElement is NOT visible, Exception: " + e.getMessage());
            return false;
        }
    }
    
    
    
    //Hover
    public void actionMoveAndHover(WebElement element) throws Exception {
        //WebElement User = new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOfElementLocated(By.id("menu_admin_viewSystemUsers")));
        Actions ob = new Actions(driver);
        try {
            this.wait.until(ExpectedConditions.visibilityOf(element)).isEnabled();
            ob.moveToElement(element).build().perform();
            System.out.println("Successfully Action Moved and hover on the WebElement, using locator: " + "<" + element.toString() + ">");
        } catch (StaleElementReferenceException elementUpdated) {
            WebElement elementToHover = element;
            Boolean elementPresent = wait.until(ExpectedConditions.visibilityOfElementLocated((By) elementToHover)).isEnabled();
            if (elementPresent == true) {
                ob.moveToElement(elementToHover).build().perform();
                System.out.println("(Stale Exception) - Successfully Action Moved and Clicked on the WebElement, using locator: " + "<" + element.toString() + ">");
            }
        } catch (Exception e) {
            System.out.println("Unable to Action Move and Click on the WebElement, using locator: " + "<" + element.toString() + ">");
            Assert.fail("Unable to Action Move and Hover on the WebElement, Exception: " + e.getMessage());
        }
    }
    
    
    
    
    
    
    
    
    
    
}




