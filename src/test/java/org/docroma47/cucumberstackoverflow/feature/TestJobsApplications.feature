Feature: Jobs Applications.

  Scenario: Navigate to the 'Jobs Applications' page.
    Given I am logged in as a "regular" user.
    When I navigate to the 'Jobs Applications' page.
    Then current page is 'Jobs Applications' page.

