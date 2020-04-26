Feature: Saved jobs page.

  Scenario: Navigate to the saved jobs page.
    Given I am logged in as a "regular" user.
    And I navigate to the saved jobs page.
    Then current page is saved jobs page.
