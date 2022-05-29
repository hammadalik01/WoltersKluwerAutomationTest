Feature: Verify all positive and negative scenerio on home page

@PositiveTest
Scenario: The user is on correct page Title

Given User launch application and on home page
Then The heading of page is "todos"

@PositiveTest
Scenario: Verify single record delete successfully

Given User launch application and on home page
When User enter text in input field 
And press Enter key of keyboard 
And delete a single record by click on delete button 
Then single record delete from list successfully

@PositiveTest
Scenario: Verify all list record deleted successfully

Given User launch application and on home page
When User add multiple item
And select all items in list and clear the list  
Then All record deleted successfully

@PositiveTest
Scenario: Verify correct counter number show as items left

Given User launch application and on home page
When User add multiple item
And select all items in list
Then count of item left is correct

@PositiveTest
Scenario: Verify single record Edit successfully

Given User launch application and on home page
When User enter text in input field 
And press Enter key of keyboard 
And edit a single record
Then single record edit successfully



@NegativeTest
Scenario: Verify when user enter nothing in Text field

Given User launch application and on home page
When User enter blank space into input field 
And press Enter key of keyboard 
Then nothing is happen no record enter


@NegativeTest
Scenario: Verify the character limit in Text field

Given User launch application and on home page
When User enter unlimited charcater in input field 
And press Enter key of keyboard 
Then record add in list without any error

@NegativeTest
Scenario: Verify the Text field accept different language text as input

Given User launch application and on home page
When User enter text in different language in input field 
And press Enter key of keyboard 
Then record add in list without any error

@NegativeTest
Scenario: Verify code not break when user try to enter sql injection in input field

Given User launch application and on home page
When User enter SQL injection in input field 
And press Enter key of keyboard 
Then record add in list without break a code

