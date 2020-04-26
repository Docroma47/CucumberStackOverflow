Feature: Tags page.

  Scenario: Navigate to the tags page.
    Given I am logged in as a "regular" user.
    And I navigate to the tags page.
    Then current page is tags page.
