# Automated test for Safety Cube

**Scenario with examples :**

Do not forget to use "Scenario Outline" instead of simply "Scenario"

**Launch tests cli**

mvn clean test -Dcucumber.options="--tags @XXXX" 
nb : *replace XXXX by the test scenario tag. The tags are available in src/test/resources/*


| # | Name | Tag | Cli | Description |
| -- | -- | -- | -- | -- |
| [1](http://192.168.31.22:9090/olivierlam/SafetyCube/issues/1) | Safety Portal Login | @successfulportallogin | mvn test -Dcucumber.options="--tags @successfulportallogin" | Login to portal as Safety-Line |
| [2](http://192.168.31.22:9090/olivierlam/SafetyCube/issues/2) | Safety Cube Login | @successfulcubelogin | mvn test -Dcucumber.options="--tags @successfulcubelogin" | Login to cube as Safety-Line |
| [6](http://192.168.31.22:9090/olivierlam/SafetyCube/issues/6) | Portal KNE ASR Form filling | @portalkneasrfill | mvn test -Dcucumber.options="--tags @portalkneasrfill" | Portal KNE ASR Form filling. Must be exectuted after @cubekneasrcheck |
| [7](http://192.168.31.22:9090/olivierlam/SafetyCube/issues/7) | Cube KNE ASR Form checking | @cubekneasrcheck | mvn test -Dcucumber.options="--tags @cubekneasrcheck" | Cube KNE ASR Form checking. Must be exectuted before @portalkneasrfill |

**Extent report**


**Custom JUnit report**
In pom.xml at <junitreport>
In the <report> tag, add : styledir="[dir/to/custom/xls/file]"
> \<report styledir="src/etc" format="noframes" todir="report"/>