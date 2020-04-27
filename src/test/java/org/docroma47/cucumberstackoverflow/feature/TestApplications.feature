Feature: Applications.

  Scenario: Navigate to the applications.
    Given I am logged in as a "regular" user.
    When I navigate to the applications.
    Then current page is applications.

