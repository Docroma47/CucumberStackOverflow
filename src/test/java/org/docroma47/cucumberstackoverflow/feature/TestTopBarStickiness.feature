Feature: Enable/Disable top bar stickiness

  Scenario: Top bar stickiness changes from enabled to disabled
    Given I am logged in as a "regular" user
    And I navigate to the user preferences page
    When I enable top bar stickiness
    And I scroll to the bottom
    Then Top bar is not fixed

  Scenario: Top bar stickiness changes from disabled to enabled
    Given I am logged in as a "regular" user
    And I navigate to the user preferences page
    When I disable top bar stickiness
    And I scroll to the bottom
    Then Top bar is fixed
