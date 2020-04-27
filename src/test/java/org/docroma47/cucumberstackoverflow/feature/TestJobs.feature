Feature: Jobs.

  Scenario: Navigate to the jobs.
    Given I am logged in as a "regular" user.
    And I navigate to the 'Jobs'.
    Then current page is 'Jobs'.
