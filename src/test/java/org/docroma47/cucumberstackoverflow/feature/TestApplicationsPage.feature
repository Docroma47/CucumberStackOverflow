Feature: Applications page.

  Scenario: Navigate to the applications page.
    Given I am logged in as a "regular" user.
    When I navigate to the applications page.
    Then current page is applications page.

