Feature: Jobs Saved job searches.

  Scenario: Navigate to the 'Jobs' 'Saved Jobs Searches' page.
    Given I am logged in as a "regular" user.
    And I navigate to the 'Jobs' 'Saved Jobs Searches' page.
    Then current page is 'Jobs' 'Saved Jobs Searches' page.
