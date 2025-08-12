Feature: Profile Functionalities test
  Background:
    When Click on the login link
    When User enter valid username
    And Click on the Continue Button
    When User enter valid password
    And Click on the Continue Button

  Scenario: Profile information successfully updated
    When Click on the Profile icon
    Then All the menu is available
