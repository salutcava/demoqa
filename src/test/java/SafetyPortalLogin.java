import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;

public class SafetyPortalLogin {
    private WebDriver browser;

    @Before
    public void SafetyPortalBefore() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Olivier\\Downloads\\chromedriver_win32\\chromedriver.exe");
        browser = new ChromeDriver();
        browser.get("http://192.168.31.77/QA-SAFETYCUBE-MASTER/#/login");
        //throw new PendingException();
    }

    @After
    public void SafetyPortalAfter() {
        System.out.println("The end is near..");
        //browser.quit();
    }

    @Given("^I enter my username '(.*?)'$")
    public void i_enter_my_username(String username) {
        System.out.println("i_enter_my_username");

        browser.findElement(By.id("username")).sendKeys(username);
        //throw new PendingException();
    }

    @And("^I enter my password '(.*?)'$")
    public void i_enter_my_password(String password) {
        System.out.println("i_enter_my_password");

        browser.findElement(By.id("password")).sendKeys(password);
        //throw new PendingException();
    }

    @Then("^I click on the login button$")
    public void i_click_on_the_login_button() {
        System.out.println("i_click_on_the_login_button");

        browser.findElement(By.id("btnLogin")).click();
        //throw new PendingException();
    }
}
