import cucumber.api.Scenario;
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
    private static WebDriver driver;
    private Scenario scenario;

    @Given("^I enter my username '(.*?)' in portal$")
    public void i_enter_my_username(String username, Scenario scenario) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Olivier\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://192.168.31.77/QA-SAFETYCUBE-MASTER/");
        this.scenario = scenario;
        System.out.println(this.scenario);

        System.out.println("i_enter_my_username");

        driver.findElement(By.id("username")).sendKeys(username);

        SaveScreenshot.capture(scenario.getId(), driver);
    }

    @And("^I enter my password '(.*?)' in portal$")
    public void i_enter_my_password(String password) {
        System.out.println("i_enter_my_password");

        driver.findElement(By.id("password")).sendKeys(password);

        SaveScreenshot.capture(scenario.getId(), driver);
    }

    @Then("^I click on the login button in portal$")
    public void i_click_on_the_login_button() {
        System.out.println("i_click_on_the_login_button");

        driver.findElement(By.id("btnLogin")).click();
    }

    @And("^I check the page in portal$")
    public void i_check_the_page() {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("logo-content")));

        Assert.assertTrue("Nous sommes bien sur la bonne page",driver.getCurrentUrl().contains("home"));

        SaveScreenshot.capture("i-check-the-url", driver);
    }
}
