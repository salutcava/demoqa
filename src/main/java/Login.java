import com.cucumber.listener.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;

public class Login{
    static WebDriver driver;
    static WebDriverWait wait;

    private static void login(String env, String username, String password) throws IOException {
        System.setProperty("webdriver.chrome.driver", Props.getProperty("driver"));

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);

        Login.driver.manage().window().maximize();

        Login.driver.get(Props.getProperty("server.safetycube." + env));
        System.out.println("Exec a wait");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("html > body > app-root > app-login > div > div > div > img")));

        if(env.equals("admin")) {
            // admin
            Login.driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(username);
            Login.driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
        }else if(env.equals("cube")) {
            // cube
            Login.driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/form/input[1]")).sendKeys(username);
            Login.driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/form/input[2]")).sendKeys(password);
        }else {
            // portal
            Login.driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(username);
            Login.driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);
        }

        System.out.println("Click on the login button");
        Reporter.addStepLog("Click on the login button");

        Login.driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/form/button[1]")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/app-banner/span/header/nav/div/a/span/img")));


        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body/app-root[1]/app-dashboard[1]/section[1]/div[1]/div[2]/div[1]/div[1]")));
        if(Login.driver.getCurrentUrl().contains("dashboard")){
            Reporter.addStepLog("The URL should contain : \"dashboard\".");
            Reporter.addStepLog("The URL is : " + Login.driver.getCurrentUrl());

            SaveScreenshot.screenshot(driver, "loggedin");
            Reporter.addScreenCaptureFromPath(Props.getProperty("report.screenshot") + "loggedin.png");
        }else{
            Reporter.addStepLog("The URL should contain : \"dashboard\".");
            Reporter.addStepLog("The URL is : " + Login.driver.getCurrentUrl());

            SaveScreenshot.screenshot(driver, "notloggedin");
            Reporter.addScreenCaptureFromPath(Props.getProperty("report.screenshot") + "notloggedin.png");
        }
    }

    static void login_cube() throws IOException {
        login("cube","safety-line","Telemark_64");
    }

    static void login_admin() throws IOException {
        login("admin","safety-line","Telemark_64");
    }

    static void login_portal() throws IOException {
        login("portal", "safety-line", "Telemark_64");
    }
}
