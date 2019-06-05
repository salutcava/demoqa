import com.cucumber.listener.Reporter;
import cucumber.api.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class qa extends Login {

    @And("^I open every modules")
    public void i_open_every_modules() throws IOException, InterruptedException {
        System.out.println("I catch every modules anchor");
        Reporter.addStepLog("I catch every module anchor");

        //List<WebElement> ModulesAnchor = driver.findElements(By.cssSelector(" div.panel-menu-category div.panel-heading > h4 > a"));
        List<WebElement> ModulesAnchor = driver.findElements(By.cssSelector(" div.panel-menu-category div.panel-group > div.panel.panel-default div.panel-heading > h4 > a"));

        System.out.println(ModulesAnchor.size());

        for(int i = 0;i < ModulesAnchor.size();i++){
            System.out.println("I catch every modules anchor");
            Reporter.addStepLog("I catch every module anchor");
            System.out.println(i + " : " + ModulesAnchor.get(i));
            App.highlight(driver,ModulesAnchor.get(i));
            ModulesAnchor.get(i).click();

            SaveScreenshot.screenshot(driver, "menu " + i);
        }
    }
}