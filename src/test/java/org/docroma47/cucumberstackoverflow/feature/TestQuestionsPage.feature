Feature: Questions page.

  Scenario: Navigate to the questions page.
    Given I am logged in as a "regular" user.
    And I navigate to the questions page.
    Then current page is questions page.
