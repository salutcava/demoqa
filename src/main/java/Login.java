import com.cucumber.listener.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class Login{
    static WebDriver driver;
    static WebDriverWait wait;

    static void open_browser(){
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        System.setProperty("webdriver.chrome.driver", Props.getProperty("driver"));
        driver = new ChromeDriver(capabilities);
        wait = new WebDriverWait(driver, 60);

        Login.driver.manage().window().maximize();
    }

    static void login_cube() throws IOException {
        open_browser();

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        System.setProperty("webdriver.chrome.driver", Props.getProperty("driver"));
        WebDriver driver = new ChromeDriver(capabilities);

        Login.driver.manage().window().maximize();

        Login.driver.get(Props.getProperty("server.safetycube.cube"));

        Login.driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/form/input[1]")).sendKeys("safety-line");
        Login.driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/form/input[2]")).sendKeys("Telemark_64");

        WebElement LoginButton = Login.driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/form/button"));
        SaveScreenshot.screenshot(driver, "loginpagecube");

        System.out.println("Click on the login button");
        Reporter.addStepLog("Click on the login button");
        LoginButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/app-banner/span/header/nav/div/a/span/img")));

        System.out.println("Landing to page : " + Login.driver.getCurrentUrl());
        Reporter.addStepLog("Landing to page : " + Login.driver.getCurrentUrl());

        SaveScreenshot.screenshot(driver, "landingtocube");

        driver.navigate().refresh();
    }

    static void login_admin() throws IOException {
        open_browser();

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

        driver.navigate().refresh();
    }

    static void login_portal() throws IOException {
        open_browser();

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

        driver.navigate().refresh();
    }

    static void qademo() throws IOException {
        open_browser();

        Login.driver.get("http://qa:8080");

        Login.driver.findElement(By.xpath("/html/body/div/div/div/form/input[1]")).sendKeys(Keys.CONTROL + "a");
        Login.driver.findElement(By.xpath("/html/body/div/div/div/form/input[1]")).sendKeys(Keys.DELETE);
        Login.driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]")).sendKeys(Keys.CONTROL + "a");
        Login.driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]")).sendKeys(Keys.DELETE);

        Login.driver.findElement(By.xpath("/html/body/div/div/div/form/input[1]")).sendKeys("safety-line");
        Login.driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]")).sendKeys("Telemark_64");

        WebElement LoginButton = Login.driver.findElement(By.xpath("/html/body/div/div/div/form/button"));
        SaveScreenshot.screenshot(driver, "loginpagecusbe");

        System.out.println("Click on the login button");
        Reporter.addStepLog("Click on the login button");
        LoginButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/app-banner/span/header/nav/div/a/span/img")));

        System.out.println("Landing to page : " + Login.driver.getCurrentUrl());
        Reporter.addStepLog("Landing to page : " + Login.driver.getCurrentUrl());

        SaveScreenshot.screenshot(driver, "landingtocube");

        driver.navigate().refresh();
    }
}
