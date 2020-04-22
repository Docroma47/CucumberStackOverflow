Feature: Disable top bar stickiness.

  Scenario: Top bar stickiness changes from enabled to disabled.
    Given I am logged in as a regular user.
    And I navigate to the user preferences page.
    When I enable Top bar stickiness.
    And I scroll to the bottom.
    Then Top bar is not shown.
