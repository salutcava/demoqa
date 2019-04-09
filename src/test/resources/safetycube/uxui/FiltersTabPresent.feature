@safetycube
@filterstab

Feature: This test, will check the presence of the filters panel

  @filterstabsafetyoccurrence
  Scenario: Checking the presence of the filters panel in safety occurrence module
    Given I am logging in to the cube
    And I open the menu
    Then I select safety-occurrence-module
    And I check that the filters panel exists
    And I close the webdriver

  @filterstabactionfollowup
  Scenario: Checking the presence of the filters panel in action followup module
    Given I am logging in to the cube
    And I open the menu
    Then I select action-followup-module
    And I check that the filters panel exists
    And I close the webdriver

  @filterstabfinding
  Scenario: Checking the presence of the filters panel in finding module
    Given I am logging in to the cube
    And I open the menu
    Then I select finding-module
    And I check that the filters panel exists
    And I close the webdriver

  @filterstabauditmanagement
  Scenario: Checking the presence of the filters panel in audit management module
    Given I am logging in to the cube
    And I open the menu
    Then I select audit-management-module
    And I check that the filters panel exists
    And I close the webdriver

  @filterstabimpact
  Scenario: Checking the presence of the filters panel in impact module
    Given I am logging in to the cube
    And I open the menu
    Then I select impact-module
    And I check that the filters panel exists
    And I close the webdriver

  @filterstabriskassessment
  Scenario: Checking the presence of the filters panel in risk assessment module
    Given I am logging in to the cube
    And I open the menu
    Then I select risk-assessment-module
    And I check that the filters panel exists
    And I close the webdriver

  @filterstabpublication
  Scenario: Checking the presence of the filters panel in publication module
    Given I am logging in to the cube
    And I open the menu
    Then I select publication-module
    And I check that the filters panel exists
    And I close the webdriver

  @filterstabstandard
  Scenario: Checking the ABSENCE of the filters panel in standard module
    Given I am logging in to the cube
    And I open the menu
    Then I select standard-module
    And I check that the filters panel does not exist
    And I close the webdriver

  @filterstabtaxonomy
  Scenario: Checking the presence of the filters panel in taxonomy module
    Given I am logging in to the cube
    And I open the menu
    Then I select taxonomy-module
    And I check that the filters panel exists
    And I close the webdriver

#  @filterstabdashboard
#  Scenario: Checking the ABSENCE of the filters panel in dashboard module
#    Given I am logging in to the cube
#    And I open the menu
#    Then I select dashboard-module
#    And I check that the filters panel does not exist

  @filterstabdocumentmanagement
  Scenario: Checking the presence of the filters panel in document management module
    Given I am logging in to the cube
    And I open the menu
    Then I select document-management-module
    And I check that the filters panel exists
    And I close the webdriver

  @filterstabindicatorslist
  Scenario: Checking the ABSENCE of the filters panel in indicatorslist module
    Given I am logging in to the cube
    And I open the menu
    Then I select indicators-list-module
    And I check that the filters panel does not exist
    And I close the webdriver