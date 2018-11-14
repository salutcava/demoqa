import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import java.io.File;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import java.text.SimpleDateFormat;
import java.util.Date;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;


public class FirstTest {
    private WebDriver browser;

    @Before
    public void setUp() throws Throwable{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Olivier\\Downloads\\chromedriver_win32\\chromedriver.exe");
    }

    @Test
    @When("^I have (\\d+) file in queue$")
    public void i_have_file_in_queue(int arg1) throws Throwable {
        System.out.println("Failed test here " + arg1);
        browser = new ChromeDriver();
        browser.get("https://www.safety-line.fr/");
        WebElement header = browser.findElement(By.id("heaader"));
        assertTrue((header.isDisplayed()));
        browser.close();

    }

    @Given("^I wait (\\d+) hour$")
    public void i_wait_hour(int arg1) throws Throwable {
        System.out.println("Successful test here " + arg1);
        browser = new ChromeDriver();
        browser.get("https://www.safety-line.fr/");
        WebElement header = browser.findElement(By.id("header"));
        assertTrue((header.isDisplayed()));
        browser.close();

    }

    @Then("^The download is done$")
    public void the_download_is_done() throws Throwable {
        System.out.println("The download is done ! Taking a screenshot here !");
        TakeScreenshot.capture("bonjour", browser);
    }
}
