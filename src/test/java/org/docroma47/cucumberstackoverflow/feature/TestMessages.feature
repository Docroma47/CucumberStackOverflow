Feature: Messages.

  Scenario: Navigate to the jobs.
    Given I am logged in as a "regular" user.
    And I navigate to the messages.
    Then current page is messages.
