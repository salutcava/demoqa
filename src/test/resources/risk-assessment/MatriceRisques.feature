@safetycube
Feature: Matrice des risques
  http://192.168.31.77/QA-SAFETYCUBE-MASTER/cube/#/dashboard

  @matricerisques
  Scenario: Verifier la coherence du nombre d'evenements et des filtres appliques

    Given I am logging in
    And I open the menu for risk assessment
    Then I open risk assessment module
    And I select matrice de risques tab
    Then I select a non empty event box
    And I open the filter panel
    And I compare the probability values from the filters
    Then I compare the severity values from the table
    And I compare the severity values from the filters
