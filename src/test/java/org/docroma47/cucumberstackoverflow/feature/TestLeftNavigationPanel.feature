Feature: Show/hide left navigation panel.

  Scenario: Left navigation changes from show to hide.
    Given I am logged in as a "regular" user.
    And I navigate to the user preferences page.
    When I enable hide left navigation.
    Then left navigation is shown.

  Scenario: Left navigation changes from hide to show.
    Given I am logged in as a "regular" user.
    And I navigate to the user preferences page.
    When I diasble hide left navigation.
    Then left navigation is not shown.
