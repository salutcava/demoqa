import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.AfterClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SafetyCubeLogin {
    private static WebDriver driver;
    private Scenario scenario;

    @Given("^I enter my username '(.*?)' in cube$")
    public void i_enter_my_username_cube(String username, Scenario scenario) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Olivier\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://192.168.31.77/QA-SAFETYCUBE-MASTER/cube/");
        this.scenario = scenario;


        driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/form/input[1]")).sendKeys(username);

        SaveScreenshot.capture(scenario.getId(), driver);
    }

    @And("^I enter my password '(.*?)' in cube$")
    public void _cube(String password) {
        System.out.println("i_enter_my_password");

        driver.findElement(By.xpath("/html/body/app-root[1]/app-login[1]/div[1]/div[1]/div[1]/form[1]/input[2]")).sendKeys(password);

        SaveScreenshot.capture(scenario.getId(), driver);
    }

    @Then("^I click on the login button in cube$")
    public void i_click_on_the_login_button_cube() {
        System.out.println("i_click_on_the_login_button");

        driver.findElement(By.xpath("/html/body/app-root[1]/app-login[1]/div[1]/div[1]/div[1]/form[1]/button[1]")).click();
    }

    @And("^I check the page in cube$")
    public void i_check_the_page_cube() {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"logo\"]/img")));

        Assert.assertTrue("Nous sommes bien sur la bonne page",driver.getCurrentUrl().contains("cube"));

        SaveScreenshot.capture("i-check-the-url", driver);
    }

    @AfterClass
    public void SafetyCubeLoginAfter() {
        System.out.println("The end is near..");
    }
}
