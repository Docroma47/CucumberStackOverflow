Feature: Save ad about job.

  Scenario: Save and delete ad.
    Given I am logged in as a "regular" user.
    And I navigate to the 'Jobs' page.
    When I input 'Java' on the search field.
    And I click on the ad.
    And I press 'Save'.
    And I navigate to the 'Jobs Saved Jobs' page.
    And I delete new ad.
    Then new ad is deleted.
