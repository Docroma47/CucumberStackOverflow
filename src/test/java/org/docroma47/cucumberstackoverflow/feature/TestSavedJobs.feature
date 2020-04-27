Feature: Saved jobs.

  Scenario: Navigate to the 'Saved Jobs'.
    Given I am logged in as a "regular" user.
    And I navigate to the 'Saved Jobs'.
    Then current page is 'Saved Jobs'.
