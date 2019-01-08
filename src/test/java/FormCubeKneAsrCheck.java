import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cucumber.listener.Reporter;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class FormCubeKneAsrCheck{

    private static WebDriver driver;
    private static ExtentHtmlReporter htmlReports;
    private static ExtentReports extent;
    private static ExtentTest test;

    Properties prop = new Properties();
    OutputStream output = null;

    @Given("^I am logged in formcubekneasrcheck")
    public void kne_cube() throws IOException {
        // a voir comment factoriser ce bout là..
        System.setProperty("webdriver.chrome.driver", Props.getProperty("driver"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(Props.getProperty("server.safetycube.cube"));

        System.out.println("Exec a wait");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root[1]/app-login[1]/div[1]/div[1]/div[1]/img[1]")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("html > body > app-root > app-login > div > div > div > img")));

        driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/form/input[1]")).sendKeys("safety-line");
        driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/form/input[2]")).sendKeys("Telemark_64");

        System.out.println("Click on the login button");
        Reporter.addStepLog("Click on the login button");

        driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/form/button[1]")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/app-banner/span/header/nav/div/a/span/img")));


        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body/app-root[1]/app-dashboard[1]/section[1]/div[1]/div[2]/div[1]/div[1]")));
        if(driver.getCurrentUrl().contains("dashboard")){
            Reporter.addStepLog("The URL should contain : \"dashboard\".");
            Reporter.addStepLog("The URL is : " +driver.getCurrentUrl());

            SaveScreenshot.screenshot(driver, "loggedin");
            Reporter.addScreenCaptureFromPath(Props.getProperty("report.screenshot") + "loggedin.png");
        }else{
            Reporter.addStepLog("The URL should contain : \"dashboard\".");
            Reporter.addStepLog("The URL is : " +driver.getCurrentUrl());

            SaveScreenshot.screenshot(driver, "notloggedin");
            Reporter.addScreenCaptureFromPath(Props.getProperty("report.screenshot") + "notloggedin.png");
        }
    }

    @And("^I open the menu formcubekneasrcheck")
    public void iOpenTheMenu() throws IOException  {
        System.out.println("Opening Menu");
        Reporter.addStepLog("Opening Menu");

        WebDriverWait wait = new WebDriverWait(driver, 30);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("panel-btn")));
        WebElement BurgerMenu = driver.findElement(By.xpath("//*[@id=\"panel-btn\"]"));

        BurgerMenu.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"safety-occurrence-module\"]")));

        SaveScreenshot.screenshot(driver, "openmenu");
        Reporter.addScreenCaptureFromPath(Props.getProperty("report.screenshot") + "openmenu.png");
    }

    @Then("^I open safety occurence formcubekneasrcheck")
    public void iOpenSafetyOccurence() throws IOException  {
        System.out.println("Opening Safety Occurence!");
        Reporter.addStepLog("Opening Safety Occurence");

        WebElement SafetyOccurence = driver.findElement(By.xpath("//*[@id=\"safety-occurrence-module\"]"));

        SafetyOccurence.click();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/app-occurrence-list/section/app-list/app-list-content/table/tbody/tr[2]")));

        SaveScreenshot.screenshot(driver, "opensafetyoccurence");
        Reporter.addScreenCaptureFromPath(Props.getProperty("report.screenshot") + "opensafetyoccurence.png");
    }

    @And("^I open the form formcubekneasrcheck")
    public void iOpenTheForm() throws IOException  {
        System.out.println("I open the form");
        Reporter.addStepLog("I open the form");

        WebDriverWait wait = new WebDriverWait(driver, 30);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/app-occurrence-list/section/app-list/app-list-content/table/tbody/tr[2]")));
        WebElement OccurenceLine = driver.findElement(By.xpath("/html/body/app-root/app-occurrence-list/section/app-list/app-list-content/table/tbody/tr[2]"));

        OccurenceLine.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"TITLE\"]")));
        SaveScreenshot.screenshot(driver, "openform");
        Reporter.addScreenCaptureFromPath(Props.getProperty("report.screenshot") + "openform.png");

        System.out.println("Clicked on occurence line to open the form");
    }

    @Then("^I check the data filled in general information formcubekneasrcheck")
    public void iCheckTheDataFilledInGeneralInformation() throws IOException {
        System.out.println("General information check");
        Reporter.addStepLog("General information check");

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"TITLE\"]")));

        SaveScreenshot.screenshot(driver, "generalinformationcheck");
        Reporter.addScreenCaptureFromPath(Props.getProperty("report.screenshot") + "generalinformationcheck.png");

        // General information
        WebElement FormTitle = driver.findElement(By.xpath("//*[@id=\"TITLE\"]"));
        String FormTitleText = FormTitle.getAttribute("value");

        if(FormTitleText.contains("Automated Test | Formulaire ASR KNE")){
            System.out.println("FormTitleText.contains > Automated Test | Formulaire ASR KNE");
            Reporter.addStepLog("Occurence title should contains : Automated Test | Formulaire ASR KNE");
            Reporter.addStepLog("Occurence title : " + FormTitleText);
        }else{
            System.out.println("FormTitleText.contains > Automated Test | Formulaire ASR KNE");
            Reporter.addStepLog("Occurence title should contains : Automated Test | Formulaire ASR KNE");
            Reporter.addStepLog("Occurence title : " + FormTitleText);
        }

        System.out.println(FormTitleText);

//        Reporter.addStepLog("This is not the right form");
//        WebElement FlightNumber = driver.findElement(By.id("chr_1_2"));
//
//        WebElement AirCraftType = driver.findElement(By.id("chr_1_4"));
//
//        WebElement AirCraftTypeSelectOption = driver.findElement(By.xpath("//*[@id=\"form_report_id\"]/div[4]/div[1]/div[2]/div/div/ul/li[2]"));
//
//        WebElement Immatriculation = driver.findElement(By.xpath("//*[@id=\"IMMAT\"]"));
//
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

    @After
    public void FormKneAsrCubeCheckAfter() {
        driver.close();
        System.out.println("the end");
    }
}
