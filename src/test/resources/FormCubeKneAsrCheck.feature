Feature: [KNE] ASR occurence check in cube as 'safety-line'

        @formcubekneasrcheck

  Scenario: Check KNE ASR form from Cube
    Given I am logged in formcubekneasrcheck
    And I open the menu formcubekneasrcheck
    Then I open safety occurence formcubekneasrcheck
    And I open the form formcubekneasrcheck
    Then I check the data filled in general information formcubekneasrcheck
    And I check the data filled in crew concerned by the discretion formcubekneasrcheck
    Then I check the data filled in voyage details formcubekneasrcheck
    And I check the data filled in captain's report formcubekneasrcheck
