import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class SaveScreenshot {
    public static void capture(String testCaseName, WebDriver driver) {
        // Cast driver object to TakesScreenshot
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        // Get the screenshot as an image File
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        String filenamea = testCaseName.toLowerCase();
        String filename = filenamea.replace(' ','-');
        try {
            // Specify the destination where the image will be saved
            File dest = new File("report/screenshot/"+ date() + "/" + timestamp() + "-" + filename +".jpg");
            // Copy the screenshot to destination
            FileUtils.copyFile(src, dest);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static String timestamp() {
        // Timestamp to make each screenshot name unique
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    }

    public static String date() {
        // Timestamp to make each screenshot name unique
        return new SimpleDateFormat("yyyyMMdd").format(new Date());
    }
}