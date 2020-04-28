Feature: Jobs Messages.

  Scenario: Navigate to the 'Jobs' 'Messages' page.
    Given I am logged in as a "regular" user.
    And I navigate to the 'Jobs' 'Messages' page.
    Then current page is 'Jobs' 'Messages' page.
