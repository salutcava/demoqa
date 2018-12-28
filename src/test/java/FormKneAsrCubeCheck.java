import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormKneAsrCubeCheck {
    private static WebDriver driver;

    @Given("^I am logged in cubekneasrcheck$")
    public void kne_cube() {
        // a voir comment factoriser ce bout là..
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Olivier\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://192.168.31.77/QA-SAFETYCUBE-MASTER/cube/");

        System.out.println("Exec a wait");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root[1]/app-login[1]/div[1]/div[1]/div[1]/img[1]")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("html > body > app-root > app-login > div > div > div > img")));

        driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/form/input[1]")).sendKeys("safety-line");
        driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/form/input[2]")).sendKeys("Telemark_64");
        System.out.println("i_click_on_the_login_button");
        driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/form/button[1]")).click();

        if(driver.getCurrentUrl().contains("home")){
             Assert.assertTrue("Nous sommes bien sur la bonne page",driver.getCurrentUrl().contains("home"));
            driver.get("http://192.168.31.77/QA-SAFETYCUBE-MASTER/cube/");
        }
        SaveScreenshot.capture("i-check-the-url", driver);
    }

    @And("^I open the menu cubekneasrcheck$")
    public void iOpenTheMenu() {
        System.out.println("Opening Menu");

        WebDriverWait wait = new WebDriverWait(driver, 30);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("panel-btn")));
        WebElement BurgerMenu = driver.findElement(By.xpath("//*[@id=\"panel-btn\"]"));
        BurgerMenu.click();

        System.out.println("clicked on Burger Menu");
    }

    @Then("^I open safety occurence cubekneasrcheck$")
    public void iOpenSafetyOccurence() {
        System.out.println("Opening Safety Occurence!");

        WebDriverWait wait = new WebDriverWait(driver, 30);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"safety-occurrence-module\"]")));
        WebElement SafetyOccurence = driver.findElement(By.xpath("//*[@id=\"safety-occurrence-module\"]"));
        SafetyOccurence.click();

        System.out.println("Clicked on Safety Occurence");
    }

    @And("^I open the form cubekneasrcheck$")
    public void iOpenTheForm() {
        System.out.println("I open the form");

        WebDriverWait wait = new WebDriverWait(driver, 30);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/app-occurrence-list/section/app-list/app-list-content/table/tbody/tr[2]")));
        WebElement OccurenceLine = driver.findElement(By.xpath("/html/body/app-root/app-occurrence-list/section/app-list/app-list-content/table/tbody/tr[2]"));

        OccurenceLine.click();

        System.out.println("Clicked on occurence line to open the form");
    }

    @Then("^I check the data filled in general information cubekneasrcheck$")
    public void iCheckTheDataFilledInGeneralInformation(){

        System.out.println("I check the data filled in general information");

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"TITLE\"]")));

        // General information
        WebElement FormTitle = driver.findElement(By.xpath("//*[@id=\"TITLE\"]"));
        String FormTitleText = FormTitle.getAttribute("value");

        if(FormTitleText.contains("Automated Test | Formulaire ASR KNE")){
            System.out.println("FormTitleText.contains > Automated Test | Formulaire ASR KNE");
        }else{
            System.out.println("nothing to do here..");
        }

        System.out.println(FormTitleText);

        SaveScreenshot.capture("FormTitle", driver);

        /*WebElement FlightNumber = driver.findElement(By.id("chr_1_2"));

        WebElement AirCraftType = driver.findElement(By.id("chr_1_4"));

        WebElement AirCraftTypeSelectOption = driver.findElement(By.xpath("//*[@id=\"form_report_id\"]/div[4]/div[1]/div[2]/div/div/ul/li[2]"));

        WebElement Immatriculation = driver.findElement(By.xpath("//*[@id=\"IMMAT\"]"));

        WebElement ImmatriculationSelectOption = driver.findElement(By.xpath("//*[@id=\"form_report_id\"]/div[4]/div[1]/div[3]/div[1]/div[1]/ul[1]/li[6]"));

        WebElement Date = driver.findElement(By.xpath("//*[@id=\"DATE\"]"));

        WebElement DateSelectDate = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[6]/td[2]/a[1]"));

        WebElement Commander = driver.findElement(By.xpath("//*[@id=\"chr_1_6\"]"));*/
    }

    @And("^I check the data filled in crew concerned by the discretion cubekneasrcheck$")
    public void iCheckTheDataFilledInCrewConcernedByTheDiscretion(){

    }

    @Then("^I check the data filled in voyage details cubekneasrcheck$")
    public void iCheckTheDataFilledInVoyageDetails(){

    }

    @And("^I check the data filled in captain's report cubekneasrcheck$")
    public void iCheckTheDataFilledInCaptainSReport(){

    }

    @After
    public void FormKneAsrCubeCheckAfter(){
        //driver.close);
        System.out.println("the end");
    }
}
