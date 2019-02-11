@global
@openmenu

Feature: Opening module from the menu

  Scenario: Opening module from the menu
    Given I am logging in
    Then I open the menu
    And I select safety-occurrence-module

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