Feature: Enable/Disable keyboard shortcuts.

  Scenario: If 'Enable keyboard shortcuts' are enabled, then I can navigate to home page using a shortcut ("G" + "H").
    Given I am logged in as a "regular" user.
    And I navigate to the 'Preferences' page.
    When I enable 'Enable keyboard shortcuts'.
    And I press hot keys 'G' and 'H'.
    Then current page is changed to 'Home' page.

  Scenario: If 'Enable keyboard shortcuts' are disabled, then I cannot navigate to home page using a shortcut ("G" + "H").
    Given I am logged in as a "regular" user.
    And I navigate to the 'Preferences' page.
    When I disable 'Enable keyboard shortcuts'.
    And I refresh page.
    And I press hot keys 'G' and 'H'.
    Then current page is 'Preferences' page.
