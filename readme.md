
# Automated test for Safety Cube

**Scenario with examples :**
Do not forget to use "Scenario Outline" instead of simply "Scenario"

**To run scenarios with @test1 and @test2:**
`mvn test -Dcucumber.options="--tags @test1 --tags @test2"`

**To run scenarios with @test1 or @test2:**
`mvn test -Dcucumber.options="--tags @test1,@test2"`


**nb** : *replace test1/test2 by the test scenario tag. The tags are available in .feature files at > **src/test/resources/***


| # | Name | Tag | Cli | Description |
| -- | -- | -- | -- | -- |
| 1 | Safety Portal Login | @successfulportallogin | mvn test -Dcucumber.options="--tags @successfulportallogin" | Login to portal as Safety-Line |
| 2 | Safety Cube Login | @successfulcubelogin | mvn test -Dcucumber.options="--tags @successfulcubelogin" | Login to cube as Safety-Line |
| 3 | Portal KNE ASR Form filling | @formportalkneasrfill| mvn test -Dcucumber.options="--tags @formportalkneasrfill" | Portal KNE ASR Form filling. Must be exectuted before @cubekneasrcheck|
| 4 | Cube KNE ASR Form checking | @formcubekneasrcheck| mvn test -Dcucumber.options="--tags @cubekneasrcheck" | Cube KNE ASR Form checking. Must be exectuted after @formportalkneasrfill|

**Extent report**
Config file is at **`./config/extent-config.xml`**
From this file, you can customize the report, with javascript and css

###Screenshots
---
