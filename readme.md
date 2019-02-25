# Automated test for Safety Cube

***Tests are made for french language***

 - [Installation](#installation)
 - [Environment setup](#environment-setup)
 - [Tests screnarios](#test-scenarios)
 - [Extent report](#extent-report)
 - [Screenshot](#screenshot)
 - [Project structure](#project-structure)
 - [Logs and reporter logs](#logs-and-reporter-logs)
 - [Useful functions](#useful-functions)
 
---

## Installation
Checkout the project by using git :

    git clone http://192.168.31.22:9090/olivierlam/SafetyCube.git

## Environment setup

IntelliJ IDEA is recommanded for the project. You wan download it on their website : https://www.jetbrains.com/idea/download/

| Tool | Description |
| -- | -- |
| [Install Apache Maven](http://192.168.31.22:9090/olivierlam/SafetyCube/blob/master/installmvn.md) | Maven is a build automation tool used primarily for Java projects |
| [Install Cucumber](https://www.jetbrains.com/help/idea/enabling-cucumber-support-in-project.html) | Cucumber runs automated acceptance tests written in a behavior-driven development (BDD) style. |

# Ready to go ?

## Test scenarios

| # | Name | Tag | Description |
| -- | -- | -- | -- |
| 1 | Safety Portal Login | @successfulportallogin | Login to portal as Safety-Line |
| 2 | Safety Cube Login | @successfulcubelogin | Login to cube as Safety-Line |
| 3 | Portal KNE ASR Form filling | @formportalkneasrfill| Portal KNE ASR Form filling. Must be exectuted before @cubekneasrcheck|
| 4 | Cube KNE ASR Form checking | @formcubekneasrcheck| Cube KNE ASR Form checking. Must be exectuted after @formportalkneasrfill|
| 5 | Cube Risks Matrix | @matricerisques | Checks if filters and values in the table results are matching. And also if the tab has changed. |

### How to launch the tests scenarios ?

**Scenario with examples :**

Do not forget to use "Scenario Outline" instead of simply "Scenario"

**To run scenarios @test1 :**

`mvn clean test -Dcucumber.options="--tags @test1"`

**To run scenarios @test1 and @test2 :**

`mvn clean test -Dcucumber.options="--tags @test1 --tags @test2"`

**To run scenario @test1 or @test2 :**

`mvn clean test -Dcucumber.options="--tags @test1,@test2"`

**N.B** : replace **test1**/**test2** by the test scenario tag. 

The tags are either available in the feature files at ``src/test/resources/`` or in the upper table

## Extent report
The projet uses the [Extent Report framework](http://extentreports.com/), friendlier.

Config file is at `./config/extent-config.xml`

From this file, you can customize the report, with javascript and css.

## Screenshot
The function is in ``./src/main/java/SaveScreenshot.java``

The function will generate a .png file, in ``./report/screenshot/``

**N.B** : The path ``./report/screenshot/`` can be called by using `Props.getProperty("report.screenshot")` 

To call the function ``SaveScreenshot.screenshot(driver, MyWebElement);``

This function is saving a screenshot, and also calls reporter's function ``Reporter.addScreenCaptureFromPath()`` to link the screenshot to the StepLog

**N.B** : If you want to use this image for another stop, don't use this function. Directly use `Reporter.addScreenCaptureFromPath(Props.getProperty("report.screenshot") + "filename.png");`


## Project structure
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

I like to use these two function to write in both the console and the report what is happening. So please use these two functions to write log.

``
System.out.println("Events counts do not matche");
``
``
Reporter.addStepLog("Events counts do not matche"); 
``


## Useful functions

Read the [function.md](function.md) file
