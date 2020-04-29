Feature: Tags.

  Scenario: Navigate to the 'Tags' page.
    Given I am logged in as a "regular" user.
    And I navigate to the 'Tags' page.
    Then current page is 'Tags' page.
