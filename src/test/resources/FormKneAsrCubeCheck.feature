Feature: KNE_ASR Form

  @cubekneasrcheck

  Scenario: Check KNE ASR form from cube
    Given I am logged in for checking the form
    And I open the menu
    Then I open safety occurence
    And I open the form
    Then I check the data filled
