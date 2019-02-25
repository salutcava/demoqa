@global
@loginin

Feature: Login in as..

  @logincube
  Scenario: Login to the cube
    Given I am logging in to the cube
    And I close the window

  @loginadmin
  Scenario: Login to the admin
    Given I am logging in to the admin
    And I close the window

  @loginportal
  Scenario: Login to the portal
    Given I am logging in to the portal
    And I close the window