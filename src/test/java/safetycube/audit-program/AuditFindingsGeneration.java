import com.cucumber.listener.Reporter;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

public class AuditFindingsGeneration extends Login{

    @And("^I open an audit")
    public void iopenanaudit() throws IOException, InterruptedException {
        System.out.println("I open an audit");
        Reporter.addStepLog("I open an audit");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Créé')]")));
        List AuditsStatusCreated = driver.findElements(By.xpath("//*[contains(text(), 'Créé')]"));

        while (AuditsStatusCreated.size() <= 0) {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#list-audits > app-list-pagination > div > span:nth-child(5)")));
            WebElement NextPage = driver.findElement(By.cssSelector("#list-audits > app-list-pagination > div > span:nth-child(5)"));

            App.highlight(driver, NextPage);
            NextPage.click();
        }

        SaveScreenshot.screenshot(driver, "iopenanaudit");

        WebElement Audit = driver.findElement(By.xpath("//parent::*[contains(text(), 'Créé')]"));
        App.highlight(driver,Audit);
        Audit.click();

        SaveScreenshot.screenshot(driver, "clickaudit");
    }

    @Given("^I edit the audit")
    public void ieditanaudit() throws InterruptedException, IOException {
        System.out.println("I edit the audit");
        Reporter.addStepLog("I edit the audit");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"collapsePanelRef\"]/div/button")));
        WebElement EditButton = driver.findElement(By.xpath("//*[@id=\"collapsePanelRef\"]/div/button"));

        App.highlight(driver,EditButton);
        SaveScreenshot.screenshot(driver,"editbutton");

        EditButton.click();

        System.out.println("I add a checklist");
        Reporter.addStepLog("I add a checklist");

        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/app-audit-form/div[3]/section/form/div[3]/div[1]/div[3]/div[1]/div[2]/a")));
        //WebElement AddChecklist = driver.findElement(By.xpath("/html/body/app-root/app-audit-form/div[3]/section/form/div[3]/div[1]/div[3]/div[1]/div[2]/a"));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'des checklists')]")));
        WebElement AddChecklist = driver.findElement(By.xpath("//*[contains(text(), 'des checklists')]"));

        App.scrollTo(driver,AddChecklist);
        App.highlight(driver,AddChecklist);

        SaveScreenshot.screenshot(driver,"AddChecklist");
        AddChecklist.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"addAuditChecklist\"]")));
        SaveScreenshot.screenshot(driver,"ChecklistModale");

        System.out.println("I add a checklist");
        Reporter.addStepLog("I add a checklist");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"addAuditChecklist\"]/div/div/div[3]/ul/li[3]")));
        //WebElement ChecklistLi = driver.findElement(By.xpath("//*[@id=\"addAuditChecklist\"]/div/div/div[3]/ul/li[3]"));
        //App.highlight(driver,ChecklistLi);

        //WebElement ChecklistLiInput = driver.findElement(By.xpath("//*[@id=\"addAuditChecklist\"]/div/div/div[3]/ul/li[3]/label/span"));
        //ChecklistLi.click();

        List<WebElement> ChecklistInputs = driver.findElements(By.xpath("//*[@id=\"addAuditChecklist\"]/div/div/div[3]/ul/li/label/input"));
         for(int i = 0;i<ChecklistInputs.size();i++){
            if(!ChecklistInputs.get(i).isSelected()){
                System.out.println(!ChecklistInputs.get(i).isSelected());
                App.highlight(driver,ChecklistInputs.get(i));
                ChecklistInputs.get(i).click();
            }
            //break;
         }
        SaveScreenshot.screenshot(driver,"ChecklistInput");

        // click on the save button
        WebElement SendList = driver.findElement(By.xpath("//*[@id=\"btnSendList\"]"));
        App.highlight(driver,SendList);
        //SendList.click();
    }
}