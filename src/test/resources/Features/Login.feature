Feature: Login feature

  #This won't get executed/ this is a comment
  Scenario: Login Success
    Given I open Login Page
    When I enter email "demo@class.com"
    And I enter password "te$t$tudent"
    And I submit
    Then I should get logged in


