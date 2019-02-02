import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class SaveScreenshot {

    private static WebDriver driver;

    public static void screenshot(WebDriver driver, String filename, WebElement element) throws InterruptedException {
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