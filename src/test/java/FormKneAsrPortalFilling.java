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

public class FormKneAsrPortalFilling {
    public static WebDriver driver;

    @Given("^i am logged in for filling the form$")
    public void i_am_logged_in_for_filling_the_form() {
        // a voir comment factoriser ce bout là..
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Olivier\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://192.168.31.77/QA-SAFETYCUBE-MASTER/");

        System.out.println("Exec a wait");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"form\"]/img[1]")));
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("form#form > img")));

        driver.findElement(By.id("username")).sendKeys("safety-line");
        driver.findElement(By.id("password")).sendKeys("Telemark_64");
        System.out.println("i_click_on_the_login_button");
        driver.findElement(By.id("btnLogin")).click();

        if(driver.getCurrentUrl().contains("home")){
            Assert.assertTrue("Nous sommes bien sur la bonne page",driver.getCurrentUrl().contains("cube"));
            driver.get("http://192.168.31.77/QA-SAFETYCUBE-MASTER/");
        }
        SaveScreenshot.capture("i-check-the-url", driver);
    }

    @Then("^open filled form$")
    public void openForm() {
        System.out.println("Click on the form we are testing : ASR");

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("form_52")));
        driver.findElement(By.xpath("//*[@id=\"form_52\"]")).click();
    }

    @And("^the user fills the form$")
    public void fill_form_filling() {
        System.out.println("Filling the data");

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("chr_1_2")));

        WebElement FormTitle = driver.findElement(By.xpath("//*[@id=\"TITLE\"]"));
        WebElement FlightNumber = driver.findElement(By.id("chr_1_2"));
        WebElement AirCraftType = driver.findElement(By.id("chr_1_4"));
        WebElement AirCraftTypeElement = driver.findElement(By.xpath("//*[@id=\"form_report_id\"]/div[4]/div[1]/div[2]/div/div/ul/li[2]"));
        WebElement DatePicker = driver.findElement(By.xpath("//*[@id=\"DATE\"]"));
        WebElement ScheduleUTC = driver.findElement(By.xpath("//*[@id=\"chr_3_2\"]"));
        WebElement ActualUTC = driver.findElement(By.xpath("//*[@id=\"chr_3_19\"]"));
        WebElement MaxFdp = driver.findElement(By.xpath("//*[@id=\"max_fdp\"]"));
        WebElement SaveSend = driver.findElement(By.xpath("/html/body/app-root/ng-component/app-report-create/main/section/div/div/button[3]"));
        WebElement OkPreSend = driver.findElement(By.xpath("//*[@id=\"confirmpresend\"]/div[1]/div[1]/div[3]/button[2]"));
        //WebElement OkConfirm = driver.findElement(By.xpath("//*[@id=\\\"confirmsavesend\\\"]/div/div/div[3]/button"));

        FormTitle.sendKeys("Automated Test | Formulaire ASR KNE");
        FlightNumber.sendKeys("AFR345");
        AirCraftType.click();
        AirCraftTypeElement.click();
        DatePicker.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("DATE")));
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[6]/td[2]/a[1]")).click();

        ScheduleUTC.sendKeys("1011");
        ActualUTC.sendKeys("1011");
        MaxFdp.sendKeys("1011");
        SaveSend.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"confirmpresend\"]/div[1]/div[1]/div[3]/button[2]")));
        OkPreSend.click();

        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"confirmsavesend\"]/div/div/div[3]/button")));
        //OkConfirm.click();

    }

    @Then("^the user posts the form$")
    public void post_form_filling() {
        System.out.println("Sendind the form");
    }
}
