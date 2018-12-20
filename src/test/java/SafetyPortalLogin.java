import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SafetyPortalLogin {
    public static WebDriver driver;
    private Scenario scenario;

    @Before
    private void SafetyPortalBefore(Scenario scenario) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Olivier\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://192.168.31.77/QA-SAFETYCUBE-MASTERwwwww/");
        this.scenario = scenario;
        System.out.println(this.scenario);
    }

    @After
    public void SafetyPortalAfter() {
        System.out.println("The end is near..");
        //driver.quit();
    }

    @Given("^I enter my username '(.*?)'$")
    public void i_enter_my_username(String username) {
        System.out.println("i_enter_my_username");

        driver.findElement(By.id("username")).sendKeys(username);

        SaveScreenshot.capture(scenario.getId(), driver);
    }

    @And("^I enter my password '(.*?)'$")
    public void i_enter_my_password(String password) {
        System.out.println("i_enter_my_password");

        driver.findElement(By.id("password")).sendKeys(password);

        SaveScreenshot.capture(scenario.getId(), driver);
    }

    @Then("^I click on the login button$")
    public void i_click_on_the_login_button() {
        System.out.println("i_click_on_the_login_button");

        driver.findElement(By.id("btnLogin")).click();
    }

    @And("^I check the page$")
    public void i_check_the_page() {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("logo-content")));

        Assert.assertTrue("Nous sommes bien sur la bonne page",driver.getCurrentUrl().contains("home"));

        SaveScreenshot.capture("i-check-the-url", driver);
    }

    @And("^click action")
    public void action_link(){
//        driver.findElement(By.xpath("//*[@id=\"form_52\"]")).click();
//        System.out.println("Filling the data");
//
//        WebDriverWait wait = new WebDriverWait(driver, 30);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("chr_1_2")));
//
//        driver.findElement(By.id("chr_1_2")).sendKeys("AFR345");
//
//        Select select = new Select(driver.findElement(By.id("chr_1_4")));
//        select.deselectAll();
//        select.selectByVisibleText("A330-200");
    }
}
