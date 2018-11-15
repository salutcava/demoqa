@safetycube
Feature: Login test in QA Safety Cube Master
  http://192.168.31.77/QA-SAFETYCUBE-MASTER/cube/#/dashboard

  @successfullogin
  Scenario Outline: A successful login
      Given I enter my username '<username>'
      And I enter my password '<password>'
      Then I click on the login button
      And I check the url

  Examples:
  |   username  |   password  |
  | safety-line | Telemark_64 |
#  | safety-lina | Telemark_64 |
#  | safety-line | Telemark_65 |
#  | safety-line | Telemark_65 |
