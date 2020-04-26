Feature: Messages page.

  Scenario: Navigate to the jobs page.
    Given I am logged in as a "regular" user.
    And I navigate to the messages page.
    Then current page is messages page.
