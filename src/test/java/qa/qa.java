import com.cucumber.listener.Reporter;
import cucumber.api.java.en.And;
import org.openqa.selenium.By;

import java.io.IOException;
import java.util.List;

public class qa extends Login {

    @And("^I open every modules")
    public void i_open_every_modules() throws IOException, InterruptedException {
        System.out.println("I catch every modules anchor");
        Reporter.addStepLog("I catch every module anchor");

        List ModulesAnchor = driver.findElements(By.cssSelector(" div.panel-heading > h4 > a"));

//        ModulesAnchor.get(1);
        System.out.println(ModulesAnchor.size());
        //Reporter.addStepLog(ModulesAnchor.get(1));


        SaveScreenshot.screenshot(driver, "igototheothersadvancedpage");
    }
}