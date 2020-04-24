Feature: Usernames check

  @out
  Scenario Outline: Usernames check.
    Given I am logged in as a "<username>" user.
    When I navigate to the user profile page.
    And I scroll to the bottom.
    Then current username is "<username>".

    Examples:
      | username |
      | regular  |
      | admin    |
