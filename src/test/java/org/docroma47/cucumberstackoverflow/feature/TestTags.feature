Feature: Tags.

  Scenario: Navigate to the 'Tags'.
    Given I am logged in as a "regular" user.
    And I navigate to the 'Tags'.
    Then current page is 'Tags'.
