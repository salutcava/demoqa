import com.cucumber.listener.Reporter;
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

public class VerticalScrollBar {

    private static WebDriver driver;

    @Given("^I am logged in verticalscrollbar")
    public void i_am_logged_in_verticalscrollbar() throws IOException{
        {
            // a voir comment factoriser ce bout là.
            System.setProperty("webdriver.chrome.driver", Props.getProperty("driver"));
            driver = new ChromeDriver();
            driver.manage().window().maximize();

            driver.get(Props.getProperty("server.safetycube.cube"));
            System.out.println("Exec a wait");

            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("html > body > app-root > app-login > div > div > div > img")));

            WebElement logo = driver.findElement(By.cssSelector("html > body > app-root > app-login > div > div > div > img"));

            driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/form/input[1]")).sendKeys("safety-line");
            driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/form/input[2]")).sendKeys("Telemark_64");

            System.out.println("Click on the login button");
            Reporter.addStepLog("Click on the login button");

            driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/form/button[1]")).click();

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/app-banner/span/header/nav/div/a/span/img")));


            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body/app-root[1]/app-dashboard[1]/section[1]/div[1]/div[2]/div[1]/div[1]")));
            if(driver.getCurrentUrl().contains("dashboard")){
                Reporter.addStepLog("The URL should contain : \"dashboard\".");
                Reporter.addStepLog("The URL is : " + driver.getCurrentUrl());

                //SaveScreenshot.screenshot(driver, "loggedin");
                Reporter.addScreenCaptureFromPath(Props.getProperty("report.screenshot") + "loggedin.png");
            }else{
                Reporter.addStepLog("The URL should contain : \"dashboard\".");
                Reporter.addStepLog("The URL is : " + driver.getCurrentUrl());

                //SaveScreenshot.screenshot(driver, "notloggedin");
                Reporter.addScreenCaptureFromPath(Props.getProperty("report.screenshot") + "notloggedin.png");
            }
        }
    }

    @Then("^I check if the vertical scrollbar exists")
    public void i_check_if_the_vertical_scrollbar_exists(){
        String execScript = "return document.documentElement.scrollHeight>document.documentElement.clientHeight;";
        JavascriptExecutor scrollBarPresent = (JavascriptExecutor) driver;
        Boolean test = (Boolean) (scrollBarPresent.executeScript(execScript));

        if (test) {
            System.out.print("Scrollbar is present.");
        }else{
            System.out.print("Scrollbar is not present.");
        }
    }

}