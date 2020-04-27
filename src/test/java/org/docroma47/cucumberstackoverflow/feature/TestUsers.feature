Feature: Users.

  Scenario: Navigate to the 'Users'.
    Given I am logged in as a "regular" user.
    And I navigate to the 'Users'.
    Then current page is 'Users'.
