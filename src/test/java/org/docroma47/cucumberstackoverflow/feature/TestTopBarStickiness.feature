Feature: Enable/Disable top bar stickiness.

  Scenario: 'Disable top bar stickiness' changes from enabled to disabled.
    Given I am logged in as a "regular" user.
    And I navigate to the user preferences page.
    When I enable 'Disable top bar stickiness'.
    And I scroll to the bottom.
    Then 'Top bar' is not fixed.

  Scenario: Top bar stickiness changes from disabled to enabled.
    Given I am logged in as a "regular" user.
    And I navigate to the user preferences page.
    When I disable 'Disable top bar stickiness'.
    And I scroll to the bottom.
    Then 'Top bar' is fixed.
