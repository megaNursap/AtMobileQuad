Feature: Login In Page Appen Mobile

  @android @sign-in
  Scenario: Login Page | Check invalid email & password
    Given I open Appen App
    Then I login in into Appen App using invalid email and password

  @android @sign-in
  Scenario: Login Page | Check valid email & password
    Given I open Appen App
    Then I successfully login in into Appen App with email "ptuser0100_appen@yopmail.com" using password "Appen@1234"


  @android @sign-in
  Scenario: Login Page | Login using different account and check if loads different screen
    Given I open Appen App
    When I successfully login in into Appen App with email "alpacaph02appen@yopmail.com" using password "*Appen123*"
    And I can verify this is account with email "alpacaph02appen@yopmail.com"
    Then I can logout from Appen App
    And I successfully login in into Appen App with email "ptuser0100_appen@yopmail.com" using password "Appen@1234"
    Then I can verify this is account with email "ptuser0100_appen@yopmail.com"


