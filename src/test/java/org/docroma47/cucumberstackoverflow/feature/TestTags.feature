Feature: Tags.

  Scenario: Navigate to the tags.
    Given I am logged in as a "regular" user.
    And I navigate to the tags.
    Then current page is tags.
