@Netflix
Feature: Netflix
  I as a user
  I want to go www.netflix.com/co

  Scenario: Validate netflix
    Given that a user enters Netflix
    When the user validates the page title
    Then the system must be on netflix