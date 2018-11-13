@Belly
Feature: First Tests
  Draft of tests for safety line

  @Test1
  Scenario: A successful test
      When I wait 1 hour
      Then The download is done

  @Test2
  Scenario: A failed test
      Given I have 0 file in queue
      Then The download is done