@safetycube

Feature: KNE_ASR Form filling in portal as 'safety-line'

  @formportalkneasrfill

  Scenario: Fill KNE_ASR form
    Given I am logging in to the portal
    Then I open the form formportalkneasrfill
    And I fill the form formportalkneasrfill
    Then I post the form formportalkneasrfill
    And I close the webdriver