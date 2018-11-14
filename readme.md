# Automated test for Safety Cube

**Scenario with examples :**

Do not forget to use "Scenario Outline" instead of simply "Scenario

**Launch tests cli**

mvn clean test -Dcucumber.options="--tags @XXXX" 
nb : *replace XXXX by the test scenario tag. The tags are available in src/test/resources/*