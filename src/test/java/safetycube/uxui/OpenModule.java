import com.cucumber.listener.Reporter;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class OpenModule extends Login {

    @Then("^I open the menu")
    public void iopenthemenuu() throws InterruptedException, IOException {
        System.out.println("I open the menu");
        Reporter.addStepLog("I open the menu");

        Login.wait.until(ExpectedConditions.presenceOfElementLocated(By.id("panel-btn")));
        WebElement BurgerMenu = Login.driver.findElement(By.xpath("//*[@id=\"panel-btn\"]"));
        App.highlight(Login.driver,BurgerMenu);
        BurgerMenu.click();

        Login.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"risk-assessment-module\"]")));

        SaveScreenshot.screenshot(Login.driver, "openmenu");
    }

    @And("^I select safety-occurrence-module")
    public void iselectsafetyoccurence() throws IOException, InterruptedException {
        Modules.openModule(Login.driver,"safety-occurrence-module");
    }

    @And("^I select action-followup-module")
    public void actionfollowupmodule() throws InterruptedException, IOException {
        Modules.openModule(Login.driver,"action-followup-module");
    }

    @And("^I select finding-module")
    public void findingmodule() throws InterruptedException, IOException {
        Modules.openModule(Login.driver,"finding-module");
    }

    @And("^I select audit-management-module")
    public void auditmanagementmodule() throws InterruptedException, IOException {
        Modules.openModule(Login.driver,"audit-management-module");
    }

    @And("^I select impact-module")
    public void impactmodule() throws InterruptedException, IOException {
        Modules.openModule(Login.driver,"impact-module");
    }

    @And("^I select risk-assessment-module")
    public void riskassessmentmodule() throws InterruptedException, IOException {
        Modules.openModule(Login.driver,"risk-assessment-module");
    }

    @And("^I select publication-module")
    public void publicationmodule() throws InterruptedException, IOException {
        Modules.openModule(Login.driver,"publication-module");
    }

    @And("^I select standard-module")
    public void standardmodule() throws InterruptedException, IOException {
        Modules.openModule(Login.driver,"standard-module");
    }

    @And("^I select taxonomy-module")
    public void taxonomymodule() throws InterruptedException, IOException {
        Modules.openModule(Login.driver,"taxonomy-module");
    }

    @And("^I select dashboard-module")
    public void dashboardmodule() throws InterruptedException, IOException {
        Modules.openModule(Login.driver,"dashboard-module");
    }

    @And("^I select document-management-module")
    public void documentmanagementmodule() throws InterruptedException, IOException {
        Modules.openModule(Login.driver,"document-management-module");
    }

    @And("^I select indicators-list-module")
    public void indicatorslistmodule() throws InterruptedException, IOException {
        Modules.openModule(Login.driver,"indicators-list-module");
    }
}
