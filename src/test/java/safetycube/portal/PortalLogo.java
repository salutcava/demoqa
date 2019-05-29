import com.cucumber.listener.Reporter;
import cucumber.api.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class PortalLogo extends Login {

    @And("^I click on the header logo")
    public void iclickontheheaderlogo() throws IOException, InterruptedException {
        System.out.println("I change of page to return to the homepage later");
        Reporter.addStepLog("I click on the header logo");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/ng-component/app-report-create/main/app-header/header/nav/div/div[2]/div/div[1]/ul/li[4]/a")));
        WebElement Publication = driver.findElement(By.xpath("/html/body/app-root/ng-component/app-report-create/main/app-header/header/nav/div/div[2]/div/div[1]/ul/li[4]/a"));
        App.highlight(driver,Publication);
        Publication.click();
        SaveScreenshot.screenshot(driver,"PublicationClick");

        System.out.println("I click on the header logo");
        Reporter.addStepLog("I click on the header logo");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/ng-component/app-report-create/main/app-header/header/div/a/img")));
        WebElement Logo = driver.findElement(By.xpath("/html/body/app-root/ng-component/app-report-create/main/app-header/header/div/a/img"));
        App.highlight(driver,Logo);
        Logo.click();

        SaveScreenshot.screenshot(driver,"LogoClick");
    }
}