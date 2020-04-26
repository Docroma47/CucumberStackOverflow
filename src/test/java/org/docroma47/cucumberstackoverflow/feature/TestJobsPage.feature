Feature: Jobs page.

  Scenario: Navigate to the jobs page.
    Given I am logged in as a "regular" user.
    And I navigate to the jobs page.
    Then current page is jobs page.
