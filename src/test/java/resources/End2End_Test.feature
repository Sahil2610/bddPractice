Feature: Automated End to End Tests
  Description: The purpose of this feature is to test End to End integration
  @e2e
  Scenario: User can navigate to rediffmail homepage
    Given user is on rediff homepage
    When user enters username and password and clicks submit button
    Then email page must be displayed
    And user can see logout link
    And when user clicks on logout option
    Then the user is logged out

  @sahil
  Scenario: User can navigate to rediffmail homepage
    Given user is on rediff homepage
    When user enters username and password and clicks submit button
    Then email page must be displayed
    And user can see logout link
    And when user clicks on logout option
    Then the user is logged out
