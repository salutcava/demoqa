@safetycube
@portal
@portallogoredirect

Feature: Le logo doit rediriger vers la page d'accueil quand on clic dessus

  Scenario: I click on the portal logo

    Given I am logging in to the portal
    And I click on the header logo
    And I close the webdriver