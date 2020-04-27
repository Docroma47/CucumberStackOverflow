Feature: Companies.

  Scenario: Navigate to the companies.
    Given I am logged in as a "regular" user.
    And I navigate to the companies.
    Then current page is companies.
