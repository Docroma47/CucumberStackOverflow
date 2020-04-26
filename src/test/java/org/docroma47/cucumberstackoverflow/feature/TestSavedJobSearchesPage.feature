Feature: Saved job searches page.

  Scenario: Navigate to the saved job searches page.
    Given I am logged in as a "regular" user.
    And I navigate to the saved job searches page.
    Then current page is saved job searches page.
