@safetycube
@global
@loginin

Feature: Login in as..

  @logincube
  Scenario: Login to the cube
    Given I am logging in to the cube
    And I close the webdriver

  @loginadmin
  Scenario: Login to the admin
    Given I am logging in to the admin
    And I close the webdriver

  @loginportal
  Scenario: Login to the portal
    Given I am logging in to the portal
    And I close the webdriver

  @loginqa
  Scenario: Login to the qademo
    Given I am logging in to the qademo
    And I close the webdriver