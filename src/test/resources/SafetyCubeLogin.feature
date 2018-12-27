@safetycube
Feature: Login test in QA Safety Cube Master
  http://192.168.31.77/QA-SAFETYCUBE-MASTER/cube/#/dashboard

  @successfulcubelogin
  Scenario Outline: A successful cube login
      Given I enter my username '<username>' in cube
      And I enter my password '<password>' in cube
      Then I click on the login button in cube
      And I check the page in cube

  Examples:
  |   username  |   password  |
  | safety-line | Telemark_64 |