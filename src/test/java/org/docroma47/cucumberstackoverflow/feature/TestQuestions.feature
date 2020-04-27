Feature: Questions.

  Scenario: Navigate to the questions.
    Given I am logged in as a "regular" user.
    And I navigate to the questions.
    Then current page is questions.
