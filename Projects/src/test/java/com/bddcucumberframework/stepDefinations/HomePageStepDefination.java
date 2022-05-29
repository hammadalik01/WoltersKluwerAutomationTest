package com.bddcucumberframework.stepDefinations;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.bddcucumberframework.pagesObject.HomePage;
import com.bddcucumberframework.pagesObject.PageObjectManager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestContextSetup;

public class HomePageStepDefination {
	

	public WebDriver driver;
	public TestContextSetup textContextSetup;
	public PageObjectManager pageObjectManager;
	public HomePage homepage;

	

	public HomePageStepDefination(TestContextSetup textContextSetup) {		
		this.textContextSetup = textContextSetup;	
		this.homepage = textContextSetup.pageObjectManager.getHomePage();  
	}
	
	

     @Given("User launch application and on home page")
        public void user_launch_application_and_on_home_page() {
    	 
    	 String UrlOfPage = homepage.getUrlOfPage();
    	 Assert.assertEquals(UrlOfPage, "https://todomvc.com/examples/angular2/"); 
    	 //System.out.println(UrlOfPage);
    	 
     
     }
     
     
     
    @Then("The heading of page is {string}")
        public void the_heading_of_page_is(String expectedHeading) {    	
    	Assert.assertEquals(expectedHeading, homepage.headingOfHomePage()); 
    	//System.out.println(homepage.headingOfHomePage());
    }
    
    
    
    @When("User enter blank space into input field")
    public void user_enter_blank_space_into_input_field() {    	
    	homepage.enterTextInInputField(" ");   	          
    }
    
    
    
    
    @And("press Enter key of keyboard")
    public void press_enter_key_of_keyboard() { 
    	homepage.PressEnter(); 	
    }
    
    
    
    @Then("nothing is happen no record enter")
    public void nothing_is_happen_no_record_enter() {
    	//homepage.getListOnHamePage();
    	Assert.assertEquals(0, homepage.getListOnHamePage());	
    }
    
    @When("User enter unlimited charcater in input field")
    public void user_enter_blank_unlimited_charcater_in_input_field() {
    	
    	homepage.enterTextInInputField("asdhgagsh asghdhgasjdhjash asghdhasjdh ajsghdh asjghdhd ajsghdahsjdh ajgshdjahjdh asdhgashd asdhgashdj askdjhakjshdk asjkdhkjashkjd askjdhkajshd askjdhkjas askjdhkjas sajk asdhgagsh asghdhgasjdhjash asghdhasjdh ajsghdh asjghdhd ajsghdahsjdh ajgshdjah");  
    	
        
    }
    
    
    
    @Then("record add in list without any error")
    public void record_add_in_list_without_any_error() {

    	//homepage.getListOnHamePage();
    	Assert.assertEquals(1, homepage.getListOnHamePage());	
    	
    }
    
    
    @When("User enter text in different language in input field")
    public void user_enter_text_in_different_language_in_input_field() {    	
    	
    	homepage.enterTextInInputField("ردو میں ٹائپ کریں"); 
    	
    }
    
    
    @When("User enter SQL injection in input field")
    public void user_enter_sql_injection_in_input_field() {
    	
    	homepage.enterTextInInputField("105 OR 1=1"); 
   
    }
    
    
    @Then("record add in list without break a code")
    public void record_add_in_list_without_break_a_code() {    	
    	
    	Assert.assertEquals(1, homepage.getListOnHamePage());	
    	
    }
    
    
    
    //Delete Record drom list 
    
      @When("User enter text in input field")
        public void user_enter_text_in_input_field() {
    	  
    	  homepage.enterTextInInputField("Add in list for delete"); 
          
      }


      @When("delete a single record by click on delete button")
      public void delete_a_single_record_by_click_on_delete_button() throws Exception {    	  
    	  
    	  homepage.deleteSingleRecord(); 	    
      }



      @Then("single record delete from list successfully")
      public void single_record_delete_from_list_successfully() {
        	
    	  Assert.assertEquals(0, homepage.getListOnHamePage());
  
      }
            

      @When("edit a single record")
      public void edit_a_single_record() {      
    	  
    	  homepage.editSingleRecord();
         
      }
         
         
         
      @Then("single record edit successfully")
      public void single_record_edit_successfully() {
    	  
    	  Assert.assertTrue(homepage.getListLable().contains("edit"));
    
      }
      
      
      @When("User add multiple item")
      public void user_add_multiple_item() {
          
    	  homepage.addMultipleItems();
    	  
      }
      
      
      
      @When("select all items in list")
      public void select_all_items_in_list() {


    	  homepage.SelectCheckBoxesOfAllitems();
      }
      
      
      
      @Then("count of item left is correct")
      public void count_of_item_left_is_correct() {

    	  Assert.assertEquals(0, homepage.getCountItemsLeft());

      }
      
      
      
      @When("select all items in list and clear the list")
      public void select_all_items_in_list_and_clear_the_list() {
        
    	  homepage.SelectCheckBoxesOfAllitems();
    	  homepage.clearList();
    	  
    	  
      }
      
      
      
      @Then("All record deleted successfully")
      public void all_record_deleted_successfully() {
          
    	  Assert.assertEquals(0, homepage.getListOnHamePage());
    	  
      }


}
