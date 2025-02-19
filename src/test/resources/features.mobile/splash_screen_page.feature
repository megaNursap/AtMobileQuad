Feature: Splash Screen Page Appen Mobile

  @android @splashscreen
  Scenario: Splash Screen | Check `Welcome to the official data collection tool of Appen` link
    Given I open Appen App
    Then I can click link and verify the URL is "crowdgen.com"

  @android @splashscreen
  Scenario: Splash Screen | Check `our website` web page
    Given I open Appen App
    Then I can click link and verify the our website URL is "staging-app.crowdgen.com"


