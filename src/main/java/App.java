import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class App {

    private static WebDriver driver;

    public static String timestamp() {
        // Timestamp to make each screenshot name unique
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    }

    public static String date() {
        // Timestamp to make each screenshot name unique
        return new SimpleDateFormat("yyyyMMdd").format(new Date());
    }

    public static void highlight(WebDriver driver, WebElement element) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].classList.add('selenium-highlight');",element);

        TimeUnit.SECONDS.sleep(0);

        rmhighlight(driver,element);
    }

    public static void rmhighlight(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].classList.remove('selenium-highlight');",element);
    }
}