Feature: Project Screen Page Appen Mobile

  @android @projectscreenpage
  Scenario: Project Page | Check `our website` page when no project available
    Given I open Appen App
    When I successfully login in into Appen App with email "alpacaph02appen@yopmail.com" using password "*Appen123*"
    And I can click by using coordinate 780 and 1158
    Then I verify the website URLs is "crowdgen.com"

  @android @projectscreenpage
  Scenario: Project Screen | Check `our website` web page
    Given I open Appen App
    Then I can click link and verify the our website URL is "crowdgen.com"

  @android @projectscreenpage
  Scenario: Project Page | Select Project and press `Start working` button
    Given I open Appen App
    Then I successfully login in into Appen App with email "ptuser0100_appen@yopmail.com" using password "Appen@1234"
    And I can click by using coordinate 520 and 580
    Then I verify the job page



