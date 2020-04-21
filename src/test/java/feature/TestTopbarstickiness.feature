Feature: Disable top bar stickiness.
  The user is logged in on the site

  Scenario: Top bar stickiness changes from enabled to disabled.
    Given I navigate to the user preferences page.
    When I enable Top bar stickiness.
    And I scroll down.
    Then Top bar is not shown.
