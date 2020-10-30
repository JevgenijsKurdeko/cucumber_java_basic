#add a new person
#edit a person
#remove a person
#reset original list after:
  #adding a person
  #editing a person
  #removing a person
#check that clear button on adding a user works correctly

Feature: Testing 2

  Scenario:  Testing People with jobs
    Given I am on People with jobs
    And I am click on Add Person button
    Then Fill Name "Jevgenijs" and job "Pit-Boss"
    And I click on button Add
    Then I click on button edit a person
    And Change person name to "Elvis"
    And I click on button Edit
    Then I click on the button Remove first person
    And I click on the button Reset
    Then I check that clear button work correctly

