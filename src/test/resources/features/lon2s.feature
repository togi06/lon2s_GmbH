@smoke
Feature:Homepage functionality
  As an user, visit the web page and apply for a job

  Background: User visit the homepage
    Given User go to home page
@wip1
Scenario: User open the Homepage
  When User scrolls down
  #And User chooses Thema
  And User selects title
  And User writes Name
  And User writes Email
  And User writes Message
  And User clicks Kontaktaufnehmen
 Then verify the danger



  @wip2
  Scenario: User open the Homepage
    When User checks the  page
   And User scrolls up
    And User clicks Kontakt
    ##And User chooses Thema
    And User writes Name
    And User writes Email
    And User clicks Telefon
    And User writes Telefonnummer
    And User clicks Nachmittag
    And User clicks Email
    And User writes Message
    And User clicks Kontakt Aufnehmen
    Then verify the warning



