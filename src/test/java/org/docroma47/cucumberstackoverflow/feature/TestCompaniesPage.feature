Feature: Companies page.

  Scenario: Navigate to the companies page.
    Given I am logged in as a "regular" user.
    And I navigate to the companies page.
    Then current page is companies page.
