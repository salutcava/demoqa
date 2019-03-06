import com.cucumber.listener.Reporter;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

public class MatriceRisques extends Login{

    @And("^I select matrice de risques tab")
    public void iselectmatricederisquetab() throws IOException {
        System.out.println("I select matrice de risques tab");
        Reporter.addStepLog("I select matrice de risques tab");

        // This element is an element of the right matrice
        // We wait that the matrix is visible
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/app-root/app-risk-assessment-list/section/div/ul/li[3]")));

        WebElement MatriceTab = driver.findElement(By.xpath("/html/body/app-root/app-risk-assessment-list/section/div/ul/li[3]"));
        MatriceTab.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-risk-assessment-list/section/div/ul/li[3]")));
        SaveScreenshot.screenshot(driver, "MatriceTab1");
    }

    @Then("^I select a non empty event box")
    public void iselectanonemptyeventbox() throws InterruptedException, IOException {
        System.out.println("I select a non empty event box");
        Reporter.addStepLog("I select a non empty event box");

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//parent::*[contains(text(), 'Evenement')]")));

        //This WebElement is the first found, from right top of the risks matrix
        WebElement EventText = driver.findElement(By.xpath("//parent::*[contains(text(), 'Evenement')]"));
        App.highlight(driver,EventText);
        App.scrollTo(driver,EventText);

        SaveScreenshot.screenshot(driver, "EventTextHighlight");

        EventText.click();

        WebElement loader = driver.findElement(By.xpath("//*[@id=\"analysis\"]/app-list/app-loader"));
        wait.until(ExpectedConditions.invisibilityOf(loader));
    }

    @And("^I open the filter panel")
    public void iopenthefilterpanel() throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"analysis\"]/app-list/app-list-filter/div[2]/h4/a")));

        WebElement FiltersButton = driver.findElement(By.xpath("//*[@id=\"analysis\"]/app-list/app-list-filter/div[2]/h4/a"));

        App.highlight(driver,FiltersButton);
        App.scrollTo(driver,FiltersButton);

        // The elemnet FiltersButton can not be clicked..
        // So I had to find a way to modify the DOM
        // To display the filters panel
        WebElement Panel = driver.findElement(By.xpath("//*[@id=\"analysis\"]/app-list/app-list-filter/div[1]/div"));
        App.highlight(driver,Panel);
        App.addClass(driver,"in",Panel);
        App.setAttribute(driver,"style","height:100px;",Panel);
        //FiltersButton.click();

        SaveScreenshot.screenshot(driver,"FilterButton");

        App.removeClass(driver,"in",Panel);
        App.setAttribute(driver,"style","height:0px;",Panel);
    }

    @And("^I compare the probability values from the filters")
    public void ialsocomparetheprobabilitycolumns() throws InterruptedException, IOException {
        Reporter.addStepLog("Comparing the value in the table results with the value from the filter probability");
        WebElement ProbabilityFilter = driver.findElement(By.xpath("//*[contains(text(), 'Probabilité')]"));
        App.highlight(driver,ProbabilityFilter);

        String ProbabilityFilterName = ProbabilityFilter.getAttribute("innerHTML").replace(":", "");

        // in the filter, we get the number
        WebElement ProbabilityFilterNumberValue = driver.findElement(By.xpath("//*[contains(text(), 'Probabilité')]/following-sibling::span"));
        // we modify the data in string
        String ProbabilityNumberValueSpan = ProbabilityFilterNumberValue.getAttribute("innerText").replace(" ", "");
        App.highlight(driver,ProbabilityFilterNumberValue);

        System.out.println("ProbabilityNumberValueSpan " +ProbabilityNumberValueSpan);

        WebElement ProbabilityLetter = driver.findElement(By.xpath("//*[@id=\"analysis\"]/app-list/app-list-content/table/tbody/tr[2]/td[2]/app-list-cell/div/div/span/span/span/span"));
        String ProbabilityLetterValue = ProbabilityLetter.getAttribute("innerHTML");

        App.highlight(driver,ProbabilityLetter);

        System.out.println("Filter name : " + ProbabilityFilterName);
        Reporter.addStepLog("Filter name : " + ProbabilityFilterName);

        System.out.println("[A:1,B:2,C:3,D:4,E:5]");
        Reporter.addStepLog("[A:1,B:2,C:3,D:4,E:5]");

        System.out.println("Filter " + ProbabilityFilterName + "value : " + ProbabilityNumberValueSpan);
        Reporter.addStepLog("Filter " + ProbabilityFilterName + "value : " + ProbabilityNumberValueSpan);

        int ProbabilityNumberValueSpanInt = Integer.parseInt(ProbabilityNumberValueSpan);

        String[] filterList = {"Olivier","A","B","C","D","E"};
        String probabilityLetter = filterList[ProbabilityNumberValueSpanInt].replace(" ","");

        System.out.println("probabilityLetter " + probabilityLetter);
        Reporter.addStepLog("probabilityLetter " + probabilityLetter);
        System.out.println("ProbabilityLetterValue " + ProbabilityLetterValue);
        Reporter.addStepLog("ProbabilityLetterValue " + ProbabilityLetterValue);

        String ProbabilityLetterValueA = ProbabilityLetterValue.replace(" ","");
        String ProbabilityLetterValueB = probabilityLetter.replace(" ","");

        Assert.assertEquals(ProbabilityLetterValueA,ProbabilityLetterValueB);

        if(ProbabilityLetterValueA.equals(ProbabilityLetterValueB)){
            System.out.println("Values from filter panel and table match !");
            Reporter.addStepLog("Values from filter panel and table match !");
        }else{
            System.out.println("Values from filter panel and table do not match !");
            Reporter.addStepLog("Values from filter panel and table do not match !");
        }

        Reporter.addScreenCaptureFromPath(Props.getProperty("report.screenshot") + "FilterButton.png");
    }

    @Then("^I compare the severity values from the table")
    public void icomparewiththeamoutoflines() throws InterruptedException, IOException {
        System.out.println("This step is comparing the rows in the table results with the value from the severity the risks matrix");
        Reporter.addStepLog("This step is comparing the rows in the table results with the value from the severity the risks matrix");

        // We get the element int value in the risks matrix, the same as the previous test case
        WebElement EventText = driver.findElement(By.xpath("//parent::*[contains(text(), 'Evenement')]"));
        String FirstEventFromRisksMatrixXpath = App.generateXPATH(EventText,"");

        // Get the int value of the box
        WebElement EventNumberValueSpan = driver.findElement(By.xpath(FirstEventFromRisksMatrixXpath+"/preceding-sibling::span[1]"));
        App.highlight(driver,EventNumberValueSpan);
        // We store the value as string
        int EventNumberValue = Integer.parseInt(EventNumberValueSpan.getAttribute("innerHTML"));

        // list of the rows in the table
        List TableRow = driver.findElements(By.cssSelector("#analysis > app-list > app-list-content > table > tbody > tr.click-action.tr-row"));
        int TableRowSize = TableRow.size();

        for(int i = 0;i < TableRowSize;i++){
            App.highlight(driver,TableRow.get(i));
        }

        System.out.println("Number of event from risks matrix : " + EventNumberValue);
        Reporter.addStepLog("Number of event from risks matrix : " + EventNumberValue);
        System.out.println("Number of rows in results table : " + TableRowSize);
        Reporter.addStepLog("Number of rows in results table : " + TableRowSize);

        SaveScreenshot.screenshot(driver,"TableRow");
        Reporter.addScreenCaptureFromPath(Props.getProperty("report.screenshot") + "EventTextHighlight.png");

        Reporter.addStepLog("Event count value : " + EventNumberValue);
        Reporter.addStepLog("Table row number : " + TableRowSize);

        if(EventNumberValue == TableRowSize){
            System.out.println("Values from the risks matrix and the row counts match");
            Reporter.addStepLog("Values from the risks matrix and the row counts match");
        }else{
            System.out.println("Values from the risks matrix and the row counts do not match");
            Reporter.addStepLog("Values from the risks matrix and the row counts do not match");
        }

        Assert.assertEquals(EventNumberValue,TableRowSize);
    }

    @And("^I compare the severity values from the filters")
    public void icomparetheseverityvaluesfromthefilters() throws InterruptedException, IOException {
        Reporter.addStepLog("Comparing the value in the table results with the value from the filter severity");
        WebElement SeverityFilter = driver.findElement(By.xpath("//*[contains(text(), 'Gravité')]"));
        String SeverityFilterName = SeverityFilter.getAttribute("innerHTML").replace(":", "");
        App.highlight(driver,SeverityFilter);

        WebElement SeverityFilterNumberValue = driver.findElement(By.xpath("//*[contains(text(), 'Gravité')]/following-sibling::span"));
        String SeverityFilterValue = SeverityFilterNumberValue.getAttribute("innerText").replace(" ", "");
        App.highlight(driver,SeverityFilterNumberValue);

        WebElement TableSeverity = driver.findElement(By.xpath("//*[@id=\"analysis\"]/app-list/app-list-content/table/tbody/tr[2]/td[3]/app-list-cell/div/div/span/span/span/span"));
        String TableSeverityText = TableSeverity.getText();
        App.highlight(driver,TableSeverity);

        System.out.println("Filter name : " + SeverityFilterName);
        Reporter.addStepLog("Filter name : " + SeverityFilterName);

        System.out.println("Filter " + SeverityFilterName + "value : " + SeverityFilterValue);
        Reporter.addStepLog("Filter " + SeverityFilterName + "value : " + SeverityFilterValue);

        System.out.println("Severity number in the table : " + TableSeverityText);
        Reporter.addStepLog("Severity number in the table : " + TableSeverityText);


        if(SeverityFilterValue.equals(TableSeverityText)){
            System.out.println("Filter and table severity value matche !");
            Reporter.addStepLog("Filter and table severity value matche !");
        }else {
            System.out.println("Filter and table severity value do not matche !");
            Reporter.addStepLog("Filter and table severity value do not matche !");
        }

        System.out.println("Filter " + SeverityFilterName + "value : " + SeverityFilterValue);
        Reporter.addStepLog("Filter " + SeverityFilterName + "value : " + SeverityFilterValue);

        System.out.println("Severity number in the table : " + TableSeverityText);
        Reporter.addStepLog("Severity number in the table : " + TableSeverityText);


        if(SeverityFilterValue.equals(TableSeverityText)){
            System.out.println("Values from filter and table severity match !");
            Reporter.addStepLog("Values from filter and table severity match !");
        }else {
            System.out.println("Values from filter and table severity do not match !");
            Reporter.addStepLog("Values from filter and table severity do not match !");
        }

        Assert.assertEquals(SeverityFilterValue,TableSeverityText);

        Reporter.addScreenCaptureFromPath(Props.getProperty("report.screenshot") + "FilterButton.png");
    }
}