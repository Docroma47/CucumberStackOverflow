Feature: Jobs Saved jobs.

  Scenario: Navigate to the 'Jobs' 'Saved Jobs' page.
    Given I am logged in as a "regular" user.
    And I navigate to the 'Jobs' 'Saved Jobs' page.
    Then current page is 'Jobs' 'Saved Jobs' page.
