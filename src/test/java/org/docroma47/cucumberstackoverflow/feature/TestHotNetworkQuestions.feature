Feature: Show/hide hot network questions.

  Scenario: Hot network questions changes from show to hide.
    Given I am logged in as a "regular" user.
    And I navigate to the user preferences page.
    When I enable hide hot network questions.
    And I navigate to the main page.
    And I scroll to the middle page.
    Then hot network questions is hidden.

  Scenario: Hot network questions changes from hide to show.
    Given I am logged in as a "regular" user.
    And I navigate to the user preferences page.
    When I diasble hide hot network questions.
    And I navigate to the main page.
    And I scroll to the middle page.
    Then hot network questions is shown.
