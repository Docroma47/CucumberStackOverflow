Feature: Save ad about job.

  Scenario: A job ad saves and delete.
    Given I am logged in as a "regular" user.
    And I navigate to the 'Jobs' page.
    When I input "Java" on the search field.
    And I select a job ad with index number "3".
    And I add the selected job ad to the saved jobs.
    And I navigate to the 'Saved Jobs' page.
    And I delete the selected job ad.
    Then the selected job ad is deleted.
