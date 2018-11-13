@safetycube @login @qa @master
Feature: Login test in QA Safety Cube Master
  http://192.168.31.77/QA-SAFETYCUBE-MASTER/cube/#/dashboard

  @successfullogin
  Scenario: A successful login
      When I enter my username <username>
      And My password <password>
      Then I click on the login button

  Examples:
  |   username  |   password  |
  | safety-line | Telemark_64 |
  | safety-lina | Télémark_64 |
  | safety-line | Télémark_65 |
  | safety-line | Télémark_65 |
