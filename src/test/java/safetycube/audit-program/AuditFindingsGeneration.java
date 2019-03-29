import com.cucumber.listener.Reporter;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'des checklists')]")));
        WebElement AddChecklist = driver.findElement(By.xpath("//*[contains(text(), 'des checklists')]"));

        App.scrollTo(driver,AddChecklist);
        App.highlight(driver,AddChecklist);

        SaveScreenshot.screenshot(driver,"AddChecklist");
        AddChecklist.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"addAuditChecklist\"]")));
        SaveScreenshot.screenshot(driver,"ChecklistModale");

        System.out.println("Add checklist");
        Reporter.addStepLog("Add checklist");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"addAuditChecklist\"]/div/div/div[3]/ul/li[3]")));

        List<WebElement> ChecklistInputs = driver.findElements(By.xpath("//*[@id=\"addAuditChecklist\"]/div/div/div[3]/ul/li/label/input"));
         for(int i = 0;i<ChecklistInputs.size();i++){
            if(!App.isAttribtuePresent(ChecklistInputs.get(i), "disabled")){
                App.addClass(driver, "olivier", ChecklistInputs.get(i));
                App.highlight(driver,ChecklistInputs.get(i));
                ChecklistInputs.get(i).click();
                System.out.println(ChecklistInputs.get(i).isSelected());
                break;
            }
         }
        SaveScreenshot.screenshot(driver,"ChecklistInput");

        // click on the save button
        System.out.println("Click on the save button");
        Reporter.addStepLog("Click on the save button");

        WebElement SendList = driver.findElement(By.xpath("//*[@id=\"btnSendList\"]"));
        App.highlight(driver,SendList);
        SendList.click();

        WebElement ChecklistElement = driver.findElement(By.xpath("/html/body/app-root/app-audit-form/div[3]/section/form/div[3]/div[1]/div[3]/div[1]/div[1]"));
        WebElement addAuditChecklist = driver.findElement(By.xpath("//*[@id=\"addAuditChecklist\"]"));

        wait.until(ExpectedConditions.visibilityOf(ChecklistElement));
        wait.until(ExpectedConditions.invisibilityOf(addAuditChecklist));

        App.scrollTo(driver,ChecklistElement);
        App.highlight(driver,ChecklistElement);
        ChecklistElement.click();

        SaveScreenshot.screenshot(driver,"ChecklistPage");
    }

    @Then("^I edit the checklist")
    public void ieditthechecklist() throws IOException, InterruptedException {
        System.out.println("I edit the checklist");
        Reporter.addStepLog("I edit the checklist");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/app-check-list/section/div/div/div/button[2]")));

        WebElement UnfoldButton = driver.findElement(By.cssSelector("body > app-root > app-check-list > section > div > div > div > button:nth-child(2)"));
        WebElement EditButton = driver.findElement(By.cssSelector("body > app-root > app-check-list > section > div > div > div > button:nth-child(3)"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-check-list/section/div/div/div/button[2]")));
        App.scrollTo(driver,UnfoldButton);


        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("/html/body/app-root/app-check-list/app-loader")));
        //wait.until(ExpectedConditions.elementToBeClickable(EditButton));
        App.highlight(driver,EditButton);
        EditButton.click();

        System.out.println("I click on the edit button");
        Reporter.addStepLog("I click on the edit button");
        SaveScreenshot.screenshot(driver,"EditButton");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-check-list/section/div/div/div/button[2]")));
        App.highlight(driver,UnfoldButton);
        UnfoldButton.click();

        System.out.println("I click on the unfold button");
        Reporter.addStepLog("I click on the unfold button");
        SaveScreenshot.screenshot(driver,"UnfoldButton");
    }

    @And("^I add a non conformity")
    public void iaddanonconformity() throws InterruptedException, IOException {
        WebElement auditSectionRoot = driver.findElement(By.className("audit-answers-list"));
        String auditSectionRootString = App.generateXPATH(auditSectionRoot,"");
        WebElement auditSectionRootXpath = driver.findElement(By.xpath(auditSectionRootString));

        System.out.println(App.generateXPATH(auditSectionRoot,""));
        //wait.until(ExpectedConditions.visibilityOf(auditSectionRoot));
        App.highlight(driver,auditSectionRootXpath);
        auditSectionRootXpath.click();
        SaveScreenshot.screenshot(driver,"bonjour");
    }
}