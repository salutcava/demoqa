import com.cucumber.listener.Reporter;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    @And("^I open the menu")
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

    @Then("^I select safety occurence")
    public void iselectsafetyoccurence(){
        // something
    }

    @Then("^I select risk assessment")
    public void iselectriskassessment() throws InterruptedException, IOException {
        System.out.println("I select risk assessment");
        Reporter.addStepLog("I select risk assessment");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"risk-assessment-module\"]")));

        WebElement RiskAssessmentModule = driver.findElement(By.xpath("//*[@id=\"risk-assessment-module\"]"));
        App.highlight(driver,RiskAssessmentModule);
        App.scrollTo(driver,RiskAssessmentModule);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"risk-assessment-module\"]")));

        SaveScreenshot.screenshot(driver, "risk-assessment-module");

        RiskAssessmentModule.click();
    }

}
