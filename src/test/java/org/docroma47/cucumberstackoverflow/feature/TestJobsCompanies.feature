Feature: Jobs Companies.

  Scenario: Navigate to the 'Jobs Companies' page.
    Given I am logged in as a "regular" user.
    And I navigate to the 'Jobs Companies' page.
    Then current page is 'Jobs Companies' page.
