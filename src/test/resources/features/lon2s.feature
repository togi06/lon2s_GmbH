@smoke
Feature:Homepage functionality
  As an user, visit the web page and apply for a job

  Scenario: User open the Homepage
    Given User go to home page
    When User checks the  page
    And User scrolls up
    And User clicks Kontakt
    And User writes Name
    And User writes Email
    And User clicks Email
    And User writes Message
    And User clicks Kontakt Aufnehmen
  Then verify the warning


