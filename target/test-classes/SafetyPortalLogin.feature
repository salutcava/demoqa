@safetycube
Feature: Login test in QA Safety Cube Master
  http://192.168.31.77/QA-SAFETYCUBE-MASTER/

  @successfulportallogin
  Scenario Outline: A successful portal login
      Given I enter my username '<username>' in portal
      And I enter my password '<password>' in portal
      Then I click on the login button in portal
      And I check the page in portal

  Examples:
  |   username  |   password  |
  | safety-line | Telemark_64 |