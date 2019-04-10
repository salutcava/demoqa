import com.cucumber.listener.Reporter;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class CheckCubeVersion extends Login {

    private String URL = driver.getCurrentUrl();

    @And("^I go to the others advanced page")
    public void igototheothersadvancedpage() throws IOException, InterruptedException {
        System.out.println("I go to the others advanced page");
        Reporter.addStepLog("I go to the others advanced page");

        driver.get(Props.getProperty("server.safetycube.admin.advanced.others"));

        SaveScreenshot.screenshot(driver, "igototheothersadvancedpage");
    }

    @Then("^I get the version number")
    public void igettheversionnumber() throws IOException, InterruptedException {
        System.out.println("I get the version number");
        Reporter.addStepLog("I get the version number");

        WebElement versionNumberWebElement = driver.findElement(By.xpath("/html/body/app-root/ng-component/app-advanced/app-others/main/section/div/div[1]/div[2]/div[1]/input"));
        App.highlight(driver,versionNumberWebElement);
        String versionNumberValue = versionNumberWebElement.getAttribute("value");

        System.out.println(versionNumberValue);
        Reporter.addStepLog(versionNumberValue);

        SaveScreenshot.screenshot(driver, "igettheversionnumber");
    }

    @And("^I get the customer")
    public void igetthecostumer() throws IOException, InterruptedException {
        System.out.println("I get the customer");
        Reporter.addStepLog("I get the customer");

        WebElement costumerWebElement = driver.findElement(By.xpath("/html/body/app-root/ng-component/app-advanced/app-others/main/section/div/div[1]/div[1]/div/input"));
        App.highlight(driver,costumerWebElement);
        String costumerValue = costumerWebElement.getAttribute("value");

        System.out.println(costumerValue);
        Reporter.addStepLog(costumerValue);

        SaveScreenshot.screenshot(driver, "igetthecostumer");
    }
}