import com.cucumber.listener.Reporter;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class OpenModule extends Login{

    @After
    public void OpenModuleAfter(){
        App.close(driver);
    }

    @Given("^I am logging in")
    public void main() throws IOException {
        Login.login_cube();
    }

    @Then("^I open the menu")
    public void iopenthemenuu() throws InterruptedException, IOException {
        System.out.println("I open the menu");
        Reporter.addStepLog("I open the menu");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("panel-btn")));
        WebElement BurgerMenu = driver.findElement(By.xpath("//*[@id=\"panel-btn\"]"));
        App.highlight(driver,BurgerMenu);
        BurgerMenu.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"risk-assessment-module\"]")));

        SaveScreenshot.screenshot(driver, "openmenu");
    }

    @And("^I select safety-occurrence-module")
    public void iselectsafetyoccurence() throws IOException, InterruptedException {
        Modules.openModule(driver,"safety-occurrence-module");
    }

    @And("^I select action-followup-module")
    public void actionfollowupmodule() throws InterruptedException, IOException {
        Modules.openModule(driver,"action-followup-module");
    }

    @And("^I select finding-module")
    public void findingmodule() throws InterruptedException, IOException {
        Modules.openModule(driver,"finding-module");
    }

    @And("^I select audit-management-module")
    public void auditmanagementmodule() throws InterruptedException, IOException {
        Modules.openModule(driver,"audit-management-module");
    }

    @And("^I select impact-module")
    public void impactmodule() throws InterruptedException, IOException {
        Modules.openModule(driver,"impact-module");
    }

    @And("^I select risk-assessment-module")
    public void riskassessmentmodule() throws InterruptedException, IOException {
        Modules.openModule(driver,"risk-assessment-module");
    }

    @And("^I select publication-module")
    public void publicationmodule() throws InterruptedException, IOException {
        Modules.openModule(driver,"publication-module");
    }

    @And("^I select standard-module")
    public void standardmodule() throws InterruptedException, IOException {
        Modules.openModule(driver,"standard-module");
    }

    @And("^I select taxonomy-module")
    public void taxonomymodule() throws InterruptedException, IOException {
        Modules.openModule(driver,"taxonomy-module");
    }

    @And("^I select dashboard-module")
    public void dashboardmodule() throws InterruptedException, IOException {
        Modules.openModule(driver,"dashboard-module");
    }

    @And("^I select document-management-module")
    public void documentmanagementmodule() throws InterruptedException, IOException {
        Modules.openModule(driver,"document-management-module");
    }

    @And("^I select indicators-list-module")
    public void indicatorslistmodule() throws InterruptedException, IOException {
        Modules.openModule(driver,"indicators-list-module");
    }
}
