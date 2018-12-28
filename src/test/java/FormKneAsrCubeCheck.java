import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormKneAsrCubeCheck {
    private static WebDriver driver;

    @Given("^I am logged in for checking the form$")
    public void kne_cube() {
        // a voir comment factoriser ce bout là..
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Olivier\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://192.168.31.77/QA-SAFETYCUBE-MASTER/cube/");

        System.out.println("Exec a wait");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root[1]/app-login[1]/div[1]/div[1]/div[1]/img[1]")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("html > body > app-root > app-login > div > div > div > img")));

        driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/form/input[1]")).sendKeys("safety-line");
        driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/form/input[2]")).sendKeys("Telemark_64");
        System.out.println("i_click_on_the_login_button");
        driver.findElement(By.xpath("/html/body/app-root/app-login/div/div/div/form/button[1]")).click();

        if(driver.getCurrentUrl().contains("home")){
             Assert.assertTrue("Nous sommes bien sur la bonne page",driver.getCurrentUrl().contains("home"));
            driver.get("http://192.168.31.77/QA-SAFETYCUBE-MASTER/cube/");
        }
        SaveScreenshot.capture("i-check-the-url", driver);
    }

    @And("^I open the menu$")
    public void iOpenTheMenu() {
        System.out.println("Opening Menu");

        WebDriverWait wait = new WebDriverWait(driver, 30);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("panel-btn")));
        WebElement BurgerMenu = driver.findElement(By.xpath("//*[@id=\"panel-btn\"]"));
        BurgerMenu.click();

        System.out.println("clicked on Burger Menu");
    }

    @Then("^I open safety occurence$")
    public void iOpenSafetyOccurence() {
        System.out.println("Opening Safety Occurence!");

        WebDriverWait wait = new WebDriverWait(driver, 30);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"safety-occurrence-module\"]")));
        WebElement SafetyOccurence = driver.findElement(By.xpath("//*[@id=\"safety-occurrence-module\"]"));
        SafetyOccurence.click();

        System.out.println("Clicked on Safety Occurence");
    }

    @And("^I open the form$")
    public void iOpenTheForm() {
        System.out.println("I open the form");

        WebDriverWait wait = new WebDriverWait(driver, 30);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/app-occurrence-list/section/app-list/app-list-content/table/tbody/tr[2]")));
        WebElement OccurenceLine = driver.findElement(By.xpath("/html/body/app-root/app-occurrence-list/section/app-list/app-list-content/table/tbody/tr[2]"));

        OccurenceLine.click();

        System.out.println("Clicked on occurence line to open the form");
    }

    @Then("^I check the data filled$")
    public void iCheckTheDataFilled() {
        System.out.println("I check the data");

        WebDriverWait wait = new WebDriverWait(driver, 30);
    }

    @After
    public void FormKneAsrCubeCheckAfter(){
        //driver.close);
        System.out.println("the end");
    }

}
