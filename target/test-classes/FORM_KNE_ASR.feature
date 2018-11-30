@safetycube
  @form
    @kne
      @kneform
Feature: KNE_ASR Form

  Background: A successful login
    Given I enter my username 'safety-line-olivier'
    And I enter my password 'Bonjour123'
    Then I click on the login button
    And I check the page
    And click action

  Scenario: Fill KNE_ASR form
      Given the web browser is at the KNE_ASR form
      And the user fills the form
      Then the user posts the form

#  Examples:
#  |   username  |   password  |
#  | safety-line | Telemark_64 |