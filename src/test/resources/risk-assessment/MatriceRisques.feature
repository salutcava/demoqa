@safetycube
@riskassessment
@cube

Feature: Matrice des risques
  http://192.168.31.77/QA-SAFETYCUBE-MASTER/cube/#/dashboard

  @matricerisques
  Scenario: Verifier la coherence du nombre d'evenements et des filtres appliques

    Given I am logging in to the cube
    And I open the menu
    Then I select risk-assessment-module
    And I select matrice de risques tab
    Then I select a non empty event box
    And I open the filter panel
    And I compare the probability values from the filters
    Then I compare the severity values from the table
    And I compare the severity values from the filters
    And I close the window
