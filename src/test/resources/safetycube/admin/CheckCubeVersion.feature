@safetycube
@admin
@cube
@checkcubeversion

Feature: Verifier la version deployee du Cube

  Scenario: I open the admin panel

    Given I am logging in to the admin
    And I go to the others advanced page
    Then I get the version number
    And I get the customer
    And I close the webdriver