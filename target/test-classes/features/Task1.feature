Feature: Testing

  Scenario Outline:  Testing errorcases
    Given I am on number page
    When I enter number: "<number>"
    And I click submit number
    Then I see my message: "<Message>"
    Examples:
      |number   | Message               |
      |abc      | Please enter a number |
      |15       | Number is too small   |
      |160      | Number is too big     |

  Scenario:  Testing correct cases
    Given I am on number page
    When I enter number: "60"
    And I click submit number
    Then I see my second message "Square root of 60 is 7.75"
