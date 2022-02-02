Feature: Twitter functionality

  Background: 
    Given user is on twitter login page

  Scenario: Login with valid username and password
    When user logs in with following credentials
      | username | password |
      | @Indrase62452060 | Indrasen@1204 |
    Then user expect to be navigated to home page

  Scenario: Upload profile picture and update profile details
    When user logs in with following credentials
      | username | password |
      | @Indrase62452060 | Indrasen@1204 |
    And user navigates to profile page to upload a profile picture
    And user update following details in profile section
      | bio      | Selenium Automation Expert1 |
      | location | Pune1                       |
      | website  | twitter123.com              |
    Then user expect following details updated in profile section
      | bio      | Selenium Automation Expert1 |
      | location | Pune1                       |
      | website  | http://twitter123.com       |

  Scenario: Retrieve the tweets
    When user logs in with following credentials
      | username | password |
      | @Indrase62452060 | Indrasen@1204 |
    Then user retrieves the tweets for the twitter page of "The Times Of India"
