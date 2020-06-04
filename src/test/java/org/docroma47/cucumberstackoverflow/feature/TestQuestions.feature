Feature: Questions

  Scenario: Navigate to the 'Questions' page
    Given I am logged in as a "regular" user
    And I navigate to the 'Questions' page
    Then current page is 'Questions' page