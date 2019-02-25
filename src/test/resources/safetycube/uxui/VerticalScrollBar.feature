@safetycube
Feature: Does the vertical scrollbar exists ?
  http://192.168.31.77/QA-SAFETYCUBE-MASTER/cube/#/dashboard

  @verticalscrollbar
  Scenario: Does the vertical scrollbar exists
    Given I am logged in verticalscrollbar
    Then I check if the vertical scrollbar exists
    And I close the window
