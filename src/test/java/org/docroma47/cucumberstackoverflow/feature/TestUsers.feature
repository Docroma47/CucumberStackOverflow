Feature: Users.

  Scenario: Navigate to the 'Users' page.
    Given I am logged in as a "regular" user.
    And I navigate to the 'Users' page.
    Then current page is 'Users' page.
