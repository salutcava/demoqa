Feature: KNE_ASR Form
  @portalkneasrfill
  Scenario: Fill KNE_ASR form
    Given i am logged in for filling the form
    Then open filled form
    And the user fills the form
    Then the user posts the form