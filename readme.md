# Automated test for Safety Cube

**Tests are made for french language**

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

**Screenshot**

``SaveScreenshot.screenshot(WebDriver driver, WebElement Element);``

This function is saving a screenshot, and it also calls reporter's function ``Reporter.addScreenCaptureFromPath()`` to link the screenshot to the StepLog

##Project structure


├── config                  #<br>
├── etc                     #<br>
├── media                   #<br>
├── report                  #<br>
├── src                     #<br>
│   ├── main                #<br>
│   │   ├── java            #<br>
│   │   └── resources       #<br>
│   ├── test                #<br>
│   │   ├── java            #<br>       
│   │   └── resources       #<br>
│   └── test                #<br>


## Logs and Reporter logs

When writting logs, in the console and in the reporter.

Use these two functions : 

``
System.out.println("Events counts do not matche");
Reporter.addStepLog("Events counts do not matche"); 
``

The second one, will write logs in the reporter file.


## Useful functions
read the [function.md](function.md) file
