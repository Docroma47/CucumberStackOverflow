Feature: Enable/Disable keyboard shortcuts.

  Scenario: If keyboard shortcuts are enabled, then I can navigate to home page using a shortcut ("G" + "H").
    Given I am logged in as a regular user.
    And I navigate to the user preferences page.
    When I enable keyboard shortcuts.
    And I press hot keys G and H.
    Then current page is changed to home page.

  Scenario: If keyboard shortcuts are disabled, then I cannot navigate to home page using a shortcut ("G" + "H").
    Given I am logged in as a regular user.
    And I navigate to the user preferences page.
    When I disable keyboard shortcuts.
    And I refresh page.
    And I press hot keys G and H.
    Then current page is preferences page.
