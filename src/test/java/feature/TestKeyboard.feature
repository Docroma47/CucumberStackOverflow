Feature: Enable keyboard shortcuts.
  User is logged in profile.

  Scenario: If keyboard shortcuts are enabled, then I can navigate to home page using a shortcut ("G" + "H").
    Given I navigate to the user preferences page.
    When I enable keyboard shortcuts.
    Then current page is changed to home page.
