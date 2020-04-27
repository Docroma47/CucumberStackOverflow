Feature: Saved jobs.

  Scenario: Navigate to the saved jobs.
    Given I am logged in as a "regular" user.
    And I navigate to the saved jobs.
    Then current page is saved jobs.
