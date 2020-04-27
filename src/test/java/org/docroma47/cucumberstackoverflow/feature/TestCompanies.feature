Feature: Companies.

  Scenario: Navigate to the 'Companies'.
    Given I am logged in as a "regular" user.
    And I navigate to the 'Companies'.
    Then current page is 'Companies'.
