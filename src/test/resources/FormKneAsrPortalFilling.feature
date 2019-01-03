Feature: KNE_ASR Form filling in portal as 'safety-line'

  @kneasrfill

  Scenario: Fill KNE_ASR form
    Given I am logged in portalkneasrfill
    Then I open the form portalkneasrfill
    And I fill the form portalkneasrfill
    Then I post the form portalkneasrfill