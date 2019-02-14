import cucumber.api.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class FiltersTabPresent extends Login{

    @And("^I check that the filters panel exists")
    public void i_check_that_the_filters_panel_exists() throws IOException, InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.panel-heading > h4")));
        WebElement FiltersPanelTab = driver.findElement(By.cssSelector("div.panel-heading > h4"));

        App.highlight(driver,FiltersPanelTab);
        //FiltersPanelTab.click();

        SaveScreenshot.screenshot(driver,"filterpanelexists");
    }

    @And("^I check that the filters panel do not exists")
    public void i_check_that_the_filters_panel_do_not_exists() throws IOException {
        WebElement FiltersPanelTab = Login.driver.findElement(By.cssSelector("div.panel-heading > h4"));
        Assert.assertNull("Filters panel do not exists", FiltersPanelTab);

        SaveScreenshot.screenshot(driver,"filterpaneldonotexists");
    }
}
