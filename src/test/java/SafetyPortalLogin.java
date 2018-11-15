import org.junit.Assert;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SafetyPortalLogin {
    private WebDriver browser;
    private Scenario scenario;

    @Before
    public void SafetyPortalBefore(Scenario scenario) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Olivier\\Downloads\\chromedriver_win32\\chromedriver.exe");
        browser = new ChromeDriver();
        browser.get("http://192.168.31.77/QA-SAFETYCUBE-MASTER/#/login");
        this.scenario = scenario;
    }

    @After
    public void SafetyPortalAfter() {
        System.out.println("The end is near..");
        browser.quit();
    }

    @Given("^I enter my username '(.*?)'$")
    public void i_enter_my_username(String username) {
        System.out.println("i_enter_my_username");

        browser.findElement(By.id("username")).sendKeys(username);

        SaveScreenshot.capture("Login", browser);
    }

    @And("^I enter my password '(.*?)'$")
    public void i_enter_my_password(String password) {
        System.out.println("i_enter_my_password");

        browser.findElement(By.id("password")).sendKeys(password);

        SaveScreenshot.capture("Password", browser);
    }

    @Then("^I click on the login button$")
    public void i_click_on_the_login_button() {
        System.out.println("i_click_on_the_login_button");

        browser.findElement(By.id("btnLogin")).click();
    }

    @And("^I check the url$")
    public void i_check_the_url() {
        System.out.println("i_check_the_url");

        WebDriverWait wait = new WebDriverWait(browser, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("logo-content")));

        String currentUrl = browser.getCurrentUrl();
        System.out.println(currentUrl);

        Assert.assertTrue(currentUrl.contains("home"));
        scenario.write("Hello World !");

        SaveScreenshot.capture("i-check-the-url", browser);
    }
}
