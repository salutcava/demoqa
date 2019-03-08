import com.cucumber.listener.Reporter;
import cucumber.api.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;

public class Login{
    static WebDriver driver;
    static WebDriverWait wait;

    static void login_cube() throws IOException {
        System.setProperty("webdriver.chrome.driver", Props.getProperty("driver"));

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);

        Login.driver.manage().window().maximize();

        Login.driver.get(Props.getProperty("server.safetycube.cube"));

        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/app-login/div/div/div/form/input[1]")));

        Login.driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/form/input[1]")).sendKeys("safety-line");
        Login.driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/form/input[2]")).sendKeys("Telemark_64");

        //Login.driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/form/input[1]")).sendKeys("safety-line-eric");
        //Login.driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/form/input[2]")).sendKeys("Lesneven29");

        WebElement LoginButton = Login.driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/form/button"));
        SaveScreenshot.screenshot(driver, "loginpagecube");

        System.out.println("Click on the login button");
        Reporter.addStepLog("Click on the login button");
        LoginButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/app-banner/span/header/nav/div/a/span/img")));

        System.out.println("Landing to page : " + Login.driver.getCurrentUrl());
        Reporter.addStepLog("Landing to page : " + Login.driver.getCurrentUrl());

        SaveScreenshot.screenshot(driver, "landingtocube");
    }

    static void login_admin() throws IOException {
        System.setProperty("webdriver.chrome.driver", Props.getProperty("driver"));

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);

        Login.driver.manage().window().maximize();

        Login.driver.get(Props.getProperty("server.safetycube.admin"));
        System.out.println("Exec a wait");

        // admin
        Login.driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("safety-line");
        Login.driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Telemark_64");
        WebElement LoginButton = Login.driver.findElement(By.xpath("//*[@id=\"form\"]/button"));
        SaveScreenshot.screenshot(driver, "loginpageadmin");

        System.out.println("Click on the login button");
        Reporter.addStepLog("Click on the login button");
        LoginButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/ng-component/app-home/main/app-header/header/div/img")));

        System.out.println("Landing to page : " + Login.driver.getCurrentUrl());
        Reporter.addStepLog("Landing to page : " + Login.driver.getCurrentUrl());

        // admin
        SaveScreenshot.screenshot(driver, "landingtoadmin");
    }

    static void login_portal() throws IOException {
        System.setProperty("webdriver.chrome.driver", Props.getProperty("driver"));

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);

        Login.driver.manage().window().maximize();

        Login.driver.get(Props.getProperty("server.safetycube.portal"));
        System.out.println("Exec a wait");

        // portal
        Login.driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("safety-line");
        Login.driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Telemark_64");
        WebElement LoginButton = Login.driver.findElement(By.xpath("//*[@id=\"btnLogin\"]"));
        SaveScreenshot.screenshot(driver, "loginpageportal");

        System.out.println("Click on the login button");
        Reporter.addStepLog("Click on the login button");
        LoginButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/ng-component/app-report-create/main/app-header/header/div/a/img")));

        System.out.println("Landing to page : " + Login.driver.getCurrentUrl());
        Reporter.addStepLog("Landing to page : " + Login.driver.getCurrentUrl());

        // portal
        SaveScreenshot.screenshot(driver, "landingtoportal");
    }
}
