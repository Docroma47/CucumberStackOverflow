Feature: Saved job searches.

  Scenario: Navigate to the 'Saved Jobs Searches'.
    Given I am logged in as a "regular" user.
    And I navigate to the 'Saved Jobs Searches'.
    Then current page is 'Saved Jobs Searches'.
