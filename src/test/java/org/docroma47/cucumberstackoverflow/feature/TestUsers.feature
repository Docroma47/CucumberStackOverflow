Feature: Users.

  Scenario: Navigate to the users.
    Given I am logged in as a "regular" user.
    And I navigate to the users.
    Then current page is users.
