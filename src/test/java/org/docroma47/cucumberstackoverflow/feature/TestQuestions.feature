Feature: Questions.

  Scenario: Navigate to the 'Questions.
    Given I am logged in as a "regular" user.
    And I navigate to the 'Questions'.
    Then current page is 'Questions'.
