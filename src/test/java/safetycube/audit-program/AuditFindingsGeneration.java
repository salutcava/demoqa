import com.cucumber.listener.Reporter;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.util.List;

public class AuditFindingsGeneration extends Login{

    private String URL = driver.getCurrentUrl();

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
        String URL = driver.getCurrentUrl();
        System.out.println("I edit the audit");
        Reporter.addStepLog("I edit the audit");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"collapsePanelRef\"]/div/button")));
        WebElement EditButton = driver.findElement(By.xpath("//*[@id=\"collapsePanelRef\"]/div/button"));

        App.highlight(driver, EditButton);
        SaveScreenshot.screenshot(driver, "editbutton");

        EditButton.click();
    }

    @And("^I add a checklist")
    public void iaddachecklist() throws InterruptedException, IOException {
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
            if(!App.isAttributePresent(ChecklistInputs.get(i), "disabled")){
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

        WebElement loader = driver.findElement(By.xpath("/html/body/app-root/app-check-list/app-loader"));
        WebElement UnfoldButton = driver.findElement(By.cssSelector("body > app-root > app-check-list > section > div > div > div > button:nth-child(2)"));
        WebElement EditButton = driver.findElement(By.cssSelector("body > app-root > app-check-list > section > div > div > div > button:nth-child(3)"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-check-list/section/div/div/div/button[2]")));
        App.scrollTo(driver,UnfoldButton);


        wait.until(ExpectedConditions.invisibilityOf(loader));
        wait.until(ExpectedConditions.elementToBeClickable(EditButton));
        App.highlight(driver,EditButton);
        EditButton.click();

        System.out.println("I click on the edit button");
        Reporter.addStepLog("I click on the edit button");
        SaveScreenshot.screenshot(driver,"EditButton");

        wait.until(ExpectedConditions.invisibilityOf(loader));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-check-list/section/div/div/div/button[2]")));
        wait.until(ExpectedConditions.elementToBeClickable(UnfoldButton));
        App.highlight(driver,UnfoldButton);
        UnfoldButton.click();

        System.out.println("I click on the unfold button");
        Reporter.addStepLog("I click on the unfold button");
        SaveScreenshot.screenshot(driver,"UnfoldButton");
    }

    @And("^I add a non conformity")
    public void iaddanonconformity() throws InterruptedException, IOException {

        WebElement loader = driver.findElement(By.xpath("/html/body/app-root/app-check-list/app-loader"));

        System.out.println("I find the farest child");
        Reporter.addStepLog("I find the farest child");

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("app-audit-answers > ul > li:nth-child(1) > a > span")));
        List<WebElement> auditSectionRoot = driver.findElements(By.cssSelector("app-audit-answers > ul > li:nth-child(1) > a > span"));

        WebElement auditSectionRootElement = auditSectionRoot.get(1);
        String auditSectionRootString = App.generateXPATH(auditSectionRootElement,"");
        WebElement auditSectionRootXpath = driver.findElement(By.xpath(auditSectionRootString));

        App.highlight(driver,auditSectionRootElement);

        System.out.println("Waiting that the loader disapears");
        wait.until(ExpectedConditions.invisibilityOf(loader));

        System.out.println("I select a child");
        Reporter.addStepLog("I select a child");
        App.highlight(driver,auditSectionRootXpath);
        wait.until(ExpectedConditions.elementToBeClickable(auditSectionRootXpath));
        auditSectionRootXpath.click();
        SaveScreenshot.screenshot(driver,"auditSectionRootXpath");

        System.out.println("I select the option NonDocumenteNonImplemente");
        Reporter.addStepLog("I select the option NonDocumenteNonImplemente");
        WebElement NonDocumenteNonImplemente = driver.findElement(By.xpath("/html/body/app-root/app-check-list/section/div/app-audit-answer-form/div[1]/div[9]/div[1]/select"));
        WebElement NonDocumenteNonImplementeOption = driver.findElement(By.xpath("/html/body/app-root/app-check-list/section/div/app-audit-answer-form/div[1]/div[9]/div[1]/select/option[5]"));

        App.scrollTo(driver,NonDocumenteNonImplemente);
        App.highlight(driver,NonDocumenteNonImplemente);

        System.out.println("I choose NonDocumenteNonImplemente");
        Reporter.addStepLog("I choose NonDocumenteNonImplemente");
        NonDocumenteNonImplemente.click();
        NonDocumenteNonImplementeOption.click();
        SaveScreenshot.screenshot(driver,"NonDocumenteNonImplemente");

        WebElement SaveButton = driver.findElement(By.xpath("/html/body/app-root/app-check-list/section/div/app-audit-answer-form/div[1]/div[11]/button[1]"));
        SaveButton.click();
        SaveScreenshot.screenshot(driver,"NonDocumenteNonImplementeSaved");

        WebElement close = driver.findElement(By.xpath("//*[@id=\"modalConfirm\"]/div/div/div[1]/button"));
        close.click();

        //going back to the audit
        System.out.println("Going back to the audit");
        System.out.println(URL);
        driver.get(URL);
    }

    @Then("^I change the status")
    public void ichangethestatus() throws InterruptedException, IOException {
        WebElement DetailsButton = driver.findElement(By.xpath("//*[contains(text(),'tails')]"));
        App.highlight(driver,DetailsButton);
        DetailsButton.click();

        List<WebElement> StatusCheckbox = driver.findElements(By.xpath("//*[@id=\"modalDetail\"]/div/div/div[2]/table/tbody/tr/td[1]/input"));
        System.out.println("StatusCheckbox.size() : " + StatusCheckbox.size());

        int i = 0;
        while(i<StatusCheckbox.size()){
            System.out.println("While " + i);
            System.out.println("Checkbox is checked : " + StatusCheckbox.get(i).isSelected());

            // If the checkbox is not checked, we will check it
            if(!StatusCheckbox.get(i).isSelected()){
                WebElement StatusCheckboxFromXpath = driver.findElement(By.xpath(App.generateXPATH(StatusCheckbox.get(i),"")));
                App.highlight(driver,StatusCheckboxFromXpath);

                WebElement ConfirmButton = driver.findElement(By.xpath("//*[@id=\"modalFindingInfo\"]/div/div/div[3]/button[2]"));

                if(App.isClickable(driver,ConfirmButton)){
                    ConfirmButton.click();
                }

                StatusCheckboxFromXpath.click();
            }
            i++;
            SaveScreenshot.screenshot(driver,"StatusCheckox"+i);
        }

        WebElement StatusConfirmButton = driver.findElement(By.xpath("//*[@id=\"btnStatusChange\"]"));
        StatusConfirmButton.click();
    }
}