package com.bddcucumberframework.stepDefinations;
import io.cucumber.java.After;
import utils.TestContextSetup;

public class Hooks {
	
	//public Webdriver driver;
	public TestContextSetup testContextSetup;
	
	public Hooks(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}
	
	@After
	public void AfterScenario() {
		testContextSetup.testBase.driver.quit();
	}
	
	
	



}
