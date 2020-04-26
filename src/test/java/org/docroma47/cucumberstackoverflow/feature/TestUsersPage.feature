Feature: Users page.

  Scenario: Navigate to the users page.
    Given I am logged in as a "regular" user.
    And I navigate to the users page.
    Then current page is users page.
