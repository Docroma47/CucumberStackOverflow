Feature: Changing theme.

  Scenario: Theme changes from Light to Dark.
    Given I am logged in as a "regular" user.
    And I navigate to the user preferences page.
    When I switch Theme to Dark.
    Then current theme is changed to Dark theme.

  Scenario: Theme changes from Dark to Light.
    Given I am logged in as a "regular" user.
    And I navigate to the user preferences page.
    When I switch Theme to Light.
    Then current theme is changed to Light theme.
