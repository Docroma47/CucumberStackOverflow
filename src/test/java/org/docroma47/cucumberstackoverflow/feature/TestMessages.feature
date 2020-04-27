Feature: Messages.

  Scenario: Navigate to the 'Messages'.
    Given I am logged in as a "regular" user.
    And I navigate to the 'Messages'.
    Then current page is 'Messages'.
