import com.cucumber.listener.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;

public class Modules {

    static WebDriver driver;
    static WebDriverWait wait;

    static void openMenu() throws InterruptedException {
        System.out.println("I open the menu");
        Reporter.addStepLog("I open the menu");

        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"panel-btn\"]")));

        WebElement BurgerMenu = driver.findElement(By.xpath("//*[@id=\"panel-btn\"]"));

        App.highlight(driver,BurgerMenu);
        BurgerMenu.click();
    }

    static void openModule(WebDriver driver, String module) throws InterruptedException, IOException {
        String moduleName = module.replace("-"," ");

        System.out.println("Accessing to " + moduleName);
        Reporter.addStepLog("Accessing to " + moduleName);

        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("panel-btn")));

        WebElement Module = driver.findElement(By.xpath("//*[@id=\""+module+"\"]"));
        App.scrollTo(driver,Module);
        App.highlight(driver,Module);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\""+module+"\"]")));

        Module.click();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(".loading-anim")));

        SaveScreenshot.screenshot(driver, module);
    }
}
