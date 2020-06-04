Feature: Jobs

  Scenario: Navigate to the 'Jobs' page
    Given I am logged in as a "regular" user
    And I navigate to the 'Jobs' page
    Then current page is 'Jobs' page
