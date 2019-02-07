import com.cucumber.listener.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class Login {
    public static WebDriver driver;

    static void login_cube(WebDriver driver) throws IOException {
        driver.manage().window().maximize();

        driver.get(Props.getProperty("server.safetycube.cube"));
        System.out.println("Exec a wait");

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("html > body > app-root > app-login > div > div > div > img")));

        //WebElement logo = driver.findElement(By.cssSelector("html > body > app-root > app-login > div > div > div > img"));

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

    static void login_admin(WebDriver driver) throws IOException {
        driver.manage().window().maximize();

        driver.get(Props.getProperty("server.safetycube.cube"));
        System.out.println("Exec a wait");

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("html > body > app-root > app-login > div > div > div > img")));

        //WebElement logo = driver.findElement(By.cssSelector("html > body > app-root > app-login > div > div > div > img"));

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

    static void login_portal(WebDriver driver) throws IOException {
        driver.manage().window().maximize();

        driver.get(Props.getProperty("server.safetycube.cube"));
        System.out.println("Exec a wait");

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("html > body > app-root > app-login > div > div > div > img")));

        //WebElement logo = driver.findElement(By.cssSelector("html > body > app-root > app-login > div > div > div > img"));

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
