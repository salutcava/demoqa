import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class App {

    public static WebDriver driver;
    private static JavascriptExecutor js;

    /**
     * Return timestamp : yyyyMMddHHmmss
     * @return Returns timestamp
     */
    public static String timestamp() {
        // Timestamp to make each screenshot name unique
        return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    }

    /**
     * Returns the date. Format : yyyyMMdd
     * @return returns the date
     */
    public static String date() {
        // Timestamp to make each screenshot name unique
        return new SimpleDateFormat("yyyyMMdd").format(new Date());
    }

    /**
     * Scroll to an element, used for screenshot, element should be verticaly centered
     * @param driver Webdriver
     * @param element Element where to scroll to
     */
    static void scrollTo(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: \"center\"});", element);
    }

    /**
     * Add a css class
     * @param driver Webdriver
     * @param element Element to add css class
     * @param css Css class
     * @throws InterruptedException
     */
    static void addClass(WebDriver driver, String css, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].classList.add('"+ css +"');",element);
    }

    /**
     * Remove a css class
     * @param driver Webdriver
     * @param element Element to remove css class
     * @param css Css class
     * @throws InterruptedException
     */
    static void removeClass(WebDriver driver, String css, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].classList.remove('"+ css +"');",element);
    }

    /**
     * Set an attribute
     * @param driver Webdriver
     * @param element Element to remove css class
     * @param attribute Html attribute
     * @throws InterruptedException
     */
    static void setAttribute(WebDriver driver, String attribute, String value, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('"+ attribute +"','"+ value +"');",element);
    }

    /**
     * Remove an attribute
     * @param driver Webdriver
     * @param element Element to remove css class
     * @param attribute Html attribute
     * @throws InterruptedException
     */
    static void removeAttribute(WebDriver driver, String attribute, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].removeAttribute('"+ attribute +"');",element);
    }

    /**
     * Highlight an element, used for screenshot elements recognition
     * @param driver Webdriver
     * @param element Element to add selenium-highlight class
     * @throws InterruptedException
     */
    static void highlight(WebDriver driver, Object element) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].classList.add('selenium-highlight');",element);

        //TimeUnit.MILLISECONDS.sleep(10000);
<<<<<<< HEAD
=======

>>>>>>> adc9b32090620aacfd6d515e8617d5a5be4ce52e
        //rmhighlight(driver,element);
    }

    /**
     * Complementary to highlight(), removes css class
     * @param driver Webdriver
     * @param element Element to remove selenium-highlight class
     */
    static void rmhighlight(WebDriver driver, Object element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].classList.remove('selenium-highlight');",element);
    }

    /**
     * Close the navigator and kills the processus
     * @param driver Webdriver used for the test
     */
    static void close(WebDriver driver){
        //driver.close();
        driver.quit();
    }

    /**
     * @return Add passed status icon
     */
    static String testPassed(){
        String imgSrc = "<img src=\"../media/img/icons/passed.png\"/> ";
        return imgSrc;
    }

    /**
     * @return Add failed status icon
     */
    static String testFailed(){
        String imgSrc = "<img src=\"../media/img/icons/alien.png\"/> ";
        return imgSrc;
    }

    /**
     * Get xpath of an element, used when the element is located by text or something else than xpath
     * @param childElement Element to get xpath
     * @param current Should be left empty
     * @return
     */
    static String generateXPATH(WebElement childElement, String current) {
        String childTag = childElement.getTagName();
        if(childTag.equals("html")) {
            return "/html[1]"+current;
        }
        WebElement parentElement = childElement.findElement(By.xpath(".."));
        List<WebElement> childrenElements = parentElement.findElements(By.xpath("*"));
        int count = 0;
        for(int i=0;i<childrenElements.size(); i++) {
            WebElement childrenElement = childrenElements.get(i);
            String childrenElementTag = childrenElement.getTagName();
            if(childTag.equals(childrenElementTag)) {
                count++;
            }
            if(childElement.equals(childrenElement)) {
                return generateXPATH(parentElement, "/" + childTag + "[" + count + "]"+current);
            }
        }
        return null;
    }
}