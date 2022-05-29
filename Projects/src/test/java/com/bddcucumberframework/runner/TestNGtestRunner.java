package com.bddcucumberframework.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src\\test\\java\\features",
glue ="com.bddcucumberframework.stepDefinations",
monochrome=true , tags="@PositiveTest or @NegativeTest")

//,dryRun = true
public class TestNGtestRunner extends AbstractTestNGCucumberTests{
		
	
}