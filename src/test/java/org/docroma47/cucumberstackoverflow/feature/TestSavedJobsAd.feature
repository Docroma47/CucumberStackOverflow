Feature: Saved jobs ad.

  Scenario: The selected job ad is saved and deleted.
    Given I am logged in as a "regular" user.
    And I navigate to the 'Jobs' page.
    When I input "Java" on the search field and click search button.
    And I select a job ad with index number "1".
    And I add the selected job ad to the saved jobs.
    And I navigate to the 'Saved Jobs' page.
    And I delete the selected job ad.
    Then the selected job ad is deleted.
