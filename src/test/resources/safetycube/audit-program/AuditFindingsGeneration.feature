@safetycube
@auditprogram
@cube
@auditfindinggeneration

Feature: Verifier la generation des ecarts si des actions sont ouvertes quand on ferme un audit
  http://192.168.31.77/QA-SAFETYCUBE-MASTER/cube/#/dashboard

  Scenario: I open an audit

    Given I am logging in to the cube
    And I open the menu
    Then I select audit-management-module
    And I open an audit

  Scenario: I edit the audit
    Given I edit the audit
    And I add a checklist
    Then I edit the checklist
    And I add a non conformity
    Given I edit the audit
    Then I change the status
    And I compare non compliances and findings
    And I close the webdriver

