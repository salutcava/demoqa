import com.cucumber.listener.Reporter;
import cucumber.api.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class FiltersTabPresent extends Login {

    @And("^I check that the filters panel exists")
    public void i_check_that_the_filters_panel_exists() throws IOException, InterruptedException {
        String element = "panel-action";

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
        int FilterPanel = Login.driver.findElements(By.id(element)).size();
        System.out.println(FilterPanel);


        if(FilterPanel > 0){
            App.highlight(Login.driver, Login.driver.findElement(By.id(element)));
        }

        SaveScreenshot.screenshot(Login.driver,"filterpanelexists");

        if(FilterPanel > 0){
            Reporter.addStepLog("Panel filter exists");
        }else{
            Reporter.addStepLog("Panel filter do not exists");
            Assert.assertFalse("Element do not exists",FilterPanel <= 0);
        }
    }

    @And("^I check that the filters panel does not exist")
    public void i_check_that_the_filters_panel_do_not_exists() throws IOException, InterruptedException {
        String element = "panel-action";
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element)));
        int FilterPanel = Login.driver.findElements(By.id(element)).size();
        System.out.println(FilterPanel);

        if(FilterPanel > 0){
            App.highlight(Login.driver, Login.driver.findElement(By.id(element)));
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("complex-list")));
        SaveScreenshot.screenshot(Login.driver,"filterpaneldonotexists");

        if(FilterPanel == 0){
            Reporter.addStepLog("Panel filter do not exists");
        }else{
            Reporter.addStepLog("Panel filter exists");
            Assert.assertFalse("Element exists",FilterPanel > 0);
        }
    }
}
