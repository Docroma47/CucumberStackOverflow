Feature: Applications.

  Scenario: Navigate to the 'Applications'.
    Given I am logged in as a "regular" user.
    When I navigate to the 'Applications'.
    Then current page is 'Applications'.

