@global
@openmenu

Feature: Opening module from the menu

  @opensafetyoccurrence
  Scenario: Opening safety occurrence module
    Given I am logging in
    Then I open the menu
    And I select safety-occurrence-module

  @openactionfollowup
  Scenario: Opening action followup module
    Given I am logging in
    Then I open the menu
    And I select action-followup-module

  @openfinding
  Scenario: Opening finding module
    Given I am logging in
    Then I open the menu
    And I select finding-module

  @openauditmanagement
  Scenario: Opening audit management module
    Given I am logging in
    Then I open the menu
    And I select audit-management-module

  @openimpact
  Scenario: Opening impactmodule
    Given I am logging in
    Then I open the menu
    And I select impact-module

  @openrisk-assessment
  Scenario: Opening risk assessment module
    Given I am logging in
    Then I open the menu
    And I select risk-assessment-module

  @openpublication
  Scenario: Opening publication module
    Given I am logging in
    Then I open the menu
    And I select publication-module

  @openstandard
  Scenario: Opening standard module
    Given I am logging in
    Then I open the menu
    And I select standard-module

  @opentaxonomy
  Scenario: Opening taxonomy module
    Given I am logging in
    Then I open the menu
    And I select taxonomy-module

  @opendashboard
  Scenario: Opening dashboard module
    Given I am logging in
    Then I open the menu
    And I select dashboard-module

  @opendocumentmanagement
  Scenario: Opening document management module
    Given I am logging in
    Then I open the menu
    And I select document-management-module

  @openindicatorslist
  Scenario: Opening indicators list module
    Given I am logging in
    Then I open the menu
    And I select indicators-list-module

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