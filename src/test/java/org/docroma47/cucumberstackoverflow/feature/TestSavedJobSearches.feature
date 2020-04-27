Feature: Saved job searches.

  Scenario: Navigate to the saved job searches.
    Given I am logged in as a "regular" user.
    And I navigate to the saved job searches.
    Then current page is saved job searches.
