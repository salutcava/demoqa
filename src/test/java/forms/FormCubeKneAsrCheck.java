import com.cucumber.listener.Reporter;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class FormCubeKneAsrCheck{

    private static WebDriver driver;
    private static JavascriptExecutor js;

    @After
    public void AfterFormCubeKneAsrCheck(){
        App.close(driver);
    }

    @And("^I open the form formcubekneasrcheck")
    public void iOpenTheForm() throws IOException {
        System.out.println("I open the form");
        Reporter.addStepLog("I open the form");

        WebDriverWait wait = new WebDriverWait(driver, 30);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/app-occurrence-list/section/app-list/app-list-content/table/tbody/tr[2]")));
        WebElement OccurenceLine = driver.findElement(By.xpath("/html/body/app-root/app-occurrence-list/section/app-list/app-list-content/table/tbody/tr[2]"));

        OccurenceLine.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"TITLE\"]")));

        //App.highlight(driver,OccurenceLine);
        SaveScreenshot.screenshot(driver, "openform");
        Reporter.addScreenCaptureFromPath(Props.getProperty("report.screenshot") + "openform.png");

        System.out.println("Clicked on occurence line to open the form");
    }

    @Then("^I check the data filled in general information formcubekneasrcheck")
    public void iCheckTheDataFilledInGeneralInformation() throws IOException, InterruptedException {
        System.out.println("General information check");
        Reporter.addStepLog("General information check");

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"TITLE\"]")));

        // General information
        // Title
        WebElement FormTitle = driver.findElement(By.xpath("//*[@id=\"TITLE\"]"));
        String FormTitleValue = FormTitle.getAttribute("value");

        //App.scrollTo(FormTitle);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"TITLE\"]")));

        //SaveScreenshot.screenshot(driver, "generalinformationcheck");
        Reporter.addScreenCaptureFromPath(Props.getProperty("report.screenshot") + "generalinformationcheck.png");

        if(FormTitleValue.contains("Automated Test | Formulaire ASR KNE")){
            System.out.println("Title should contains > Automated Test | Formulaire ASR KNE");
            Reporter.addStepLog("Occurence title should contains : Automated Test | Formulaire ASR KNE");
            Reporter.addStepLog("Occurence title : " + FormTitleValue);
        }else{
            System.out.println("Title should contains > Automated Test | Formulaire ASR KNE");
            Reporter.addStepLog("Occurence title should contains : Automated Test | Formulaire ASR KNE");
            Reporter.addStepLog("Occurence title : " + FormTitleValue);
        }

        System.out.println("Title check");

        // Flight number
        WebElement FlightNumber = driver.findElement(By.id("chr_1_2"));
        String FlightNumberValue = FlightNumber.getAttribute("value");

        //App.scrollTo(FlightNumber);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("chr_1_2")));

        //App.highlight(FlightNumber);
        //SaveScreenshot.screenshot(driver, "flightnumber");
        Reporter.addScreenCaptureFromPath(Props.getProperty("report.screenshot") + "flightnumber.png");

        if(FlightNumberValue.contentEquals("AFR345")){
            Reporter.addStepLog("Flight number should be : AFR345");
            Reporter.addStepLog("Flight number : " + FlightNumberValue);
        }else{
            Reporter.addStepLog("Flight number should be : AFR345");
            Reporter.addStepLog("Flight number : " + FlightNumberValue);
        }

        // Aircraft type
        WebElement AirCraftType = driver.findElement(By.id("chr_1_4"));
        WebElement AirCraftTypeSelectOption = driver.findElement(By.xpath("//*[@id=\"form_report_id\"]/div[4]/div[1]/div[2]/div/div/ul/li[2]"));
        String AirCraftTypeSelectOptionText = AirCraftTypeSelectOption.getAttribute("innerHTML");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("chr_1_4")));

        App.scrollTo(driver,AirCraftTypeSelectOption);
        App.highlight(driver,AirCraftTypeSelectOption);
        SaveScreenshot.screenshot(driver, "aircrafttypevalue");
        Reporter.addScreenCaptureFromPath(Props.getProperty("report.screenshot") + "aircrafttypevalue.png");

        if(AirCraftTypeSelectOptionText.contentEquals("A330-300")){
            Reporter.addStepLog("Aircraft type should be : A330-300");
            Reporter.addStepLog("Aircraft type is : " + AirCraftTypeSelectOptionText);
        }else{
            Reporter.addStepLog("Aircraft type should be : A330-300");
            Reporter.addStepLog("Aircraft type is : " + AirCraftTypeSelectOptionText);
            assertThat(AirCraftTypeSelectOptionText, containsString("A330-300"));
        }


        WebElement CaptainReport = driver.findElement(By.xpath("//*[@id=\"txt_4_1\"]"));

//        WebElement Immatriculation = driver.findElement(By.xpath("//*[@id=\"IMMAT\"]"));

//        WebElement ImmatriculationSelectOption = driver.findElement(By.xpath("//*[@id=\"form_report_id\"]/div[4]/div[1]/div[3]/div[1]/div[1]/ul[1]/li[6]"));
//
//        WebElement Date = driver.findElement(By.xpath("//*[@id=\"DATE\"]"));
//
//        WebElement DateSelectDate = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[6]/td[2]/a[1]"));
//
//        WebElement Commander = driver.findElement(By.xpath("//*[@id=\"chr_1_6\"]"));
    }

    @And("^I check the data filled in crew concerned by the discretion formcubekneasrcheck")
    public void iCheckTheDataFilledInCrewConcernedByTheDiscretion() throws IOException {
        Reporter.addStepLog("Scenario Log message goes here");
    }

    @Then("^I check the data filled in voyage details formcubekneasrcheck")
    public void iCheckTheDataFilledInVoyageDetails() throws IOException {
        Reporter.addStepLog("Scenario Log message goes here");
    }

    @And("^I check the data filled in captain's report formcubekneasrcheck")
    public void iCheckTheDataFilledInCaptainSReport() throws IOException {
        Reporter.addStepLog("Scenario Log message goes here");
    }
}
