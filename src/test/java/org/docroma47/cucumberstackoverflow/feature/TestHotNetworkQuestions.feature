Feature: Show/hide hot network questions

  Scenario: Hot network questions changes from show to hide
    Given I am logged in as a "regular" user
    And I navigate to the user preferences page
    When I enable 'Hide hot network questions'
    And I navigate to the main page
    Then 'Hot Network Questions' is hidden

  Scenario: Hot network questions changes from hide to show
    Given I am logged in as a "regular" user
    And I navigate to the user preferences page
    When I diasble 'Hide hot network questions'
    And I navigate to the main page
    Then 'Hot Network Questions' is not hidden
