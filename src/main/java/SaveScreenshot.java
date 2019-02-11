import com.cucumber.listener.Reporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class SaveScreenshot {

    public static WebDriver driver;
    public static JavascriptExecutor js;

    static void screenshot(WebDriver driver, String filename) throws IOException {
        //Reporter.addScreenCaptureFromPath(Props.getProperty("report.screenshot") + ".png");
        Reporter.addScreenCaptureFromPath(Props.getProperty("report.screenshot") + filename + ".png");
        // Cast driver object to TakesScreenshot
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        // Get the screenshot as an image File
        File src = screenshot.getScreenshotAs(OutputType.FILE);

        try {
            // Specify the destination where the image will be saved
            File dest = new File("./report/screenshot/" + filename +".png");
            // Copy the screenshot to destination
            FileUtils.copyFile(src, dest);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}