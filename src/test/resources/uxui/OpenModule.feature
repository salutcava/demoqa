@global
@openmenu

Feature: Opening module from the menu

  @opensafetyoccurrence
  Scenario: Opening safety occurrence module
    Given I am logging in to the cube
    Then I open the menu
    And I select safety-occurrence-module
    And I close the window

  @openactionfollowup
  Scenario: Opening action followup module
    Given I am logging in to the cube
    Then I open the menu
    And I select action-followup-module
    And I close the window

  @openfinding
  Scenario: Opening finding module
    Given I am logging in to the cube
    Then I open the menu
    And I select finding-module
    And I close the window

  @openauditmanagement
  Scenario: Opening audit management module
    Given I am logging in to the cube
    Then I open the menu
    And I select audit-management-module
    And I close the window

  @openimpact
  Scenario: Opening impactmodule
    Given I am logging in to the cube
    Then I open the menu
    And I select impact-module
    And I close the window

  @openrisk-assessment
  Scenario: Opening risk assessment module
    Given I am logging in to the cube
    Then I open the menu
    And I select risk-assessment-module
    And I close the window

  @openpublication
  Scenario: Opening publication module
    Given I am logging in to the cube
    Then I open the menu
    And I select publication-module
    And I close the window

  @openstandard
  Scenario: Opening standard module
    Given I am logging in to the cube
    Then I open the menu
    And I select standard-module
    And I close the window

  @opentaxonomy
  Scenario: Opening taxonomy module
    Given I am logging in to the cube
    Then I open the menu
    And I select taxonomy-module
    And I close the window

  @opendashboard
  Scenario: Opening dashboard module
    Given I am logging in to the cube
    Then I open the menu
    And I select dashboard-module
    And I close the window

  @opendocumentmanagement
  Scenario: Opening document management module
    Given I am logging in to the cube
    Then I open the menu
    And I select document-management-module
    And I close the window

  @openindicatorslist
  Scenario: Opening indicators list module
    Given I am logging in to the cube
    Then I open the menu
    And I select indicators-list-module
    And I close the window

#  Examples:
#    | Module |
#    | safety-occurrence |
#    | action-followup |
#    | finding |
#    | audit-management |
#    | impact |
#    | risk-assessment |
#    | publication |
#    | standard |
#    | taxonomy |
#    | dashboard |
#    | document-management |
#    | indicators-list |