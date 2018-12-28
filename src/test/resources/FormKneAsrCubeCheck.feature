Feature: KNE_ASR Form

  @cubekneasrcheck

  Scenario: Check KNE ASR form from cube
    Given I am logged in cubekneasrcheck
    And I open the menu cubekneasrcheck
    Then I open safety occurence cubekneasrcheck
    And I open the form cubekneasrcheck
    Then I check the data filled in general information cubekneasrcheck
    And I check the data filled in crew concerned by the discretion cubekneasrcheck
    Then I check the data filled in voyage details cubekneasrcheck
    And I check the data filled in captain's report cubekneasrcheck
