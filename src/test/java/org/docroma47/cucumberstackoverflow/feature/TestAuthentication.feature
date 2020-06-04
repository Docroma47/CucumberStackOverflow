#Feature: Authentication
#
#  @LogoutRequired
#  Scenario Outline: User full name check
#    Given I am logged in as a "<userType>" user
#    When I navigate to the user profile page
#    And I scroll to the bottom
#    Then current full name is "<fullName>"
#
#    Examples:
#      | userType | fullName |
#      | regular  | Regular  |
#      | admin    | Admin    |
