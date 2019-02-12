import com.cucumber.listener.Reporter;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;

public class FormPortalKneAsrFill {

    private static WebDriver driver;
    private static JavascriptExecutor js;

    @Then("^I open the form formportalkneasrfill")
    public void IOpenForm() throws IOException {
        System.out.println("Selecting the form : ASR #form_52");

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("form_52")));

        WebElement FormButton = driver.findElement(By.xpath("//*[@id=\"form_52\"]"));
        FormButton.click();
    }

    @And("^I fill the form formportalkneasrfill")
    public void fill_form_filling() throws IOException {
        System.out.println("Filling the form with data and an attached file");

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("chr_1_2")));

        // General information
        WebElement FormTitle = driver.findElement(By.xpath("//*[@id=\"TITLE\"]"));
        FormTitle.sendKeys("Automated Test | Formulaire ASR KNE");

        WebElement FlightNumber = driver.findElement(By.id("chr_1_2"));
        FlightNumber.sendKeys("AFR345");

        WebElement AirCraftType = driver.findElement(By.id("chr_1_4"));
        AirCraftType.click();

        WebElement AirCraftTypeSelectOption = driver.findElement(By.xpath("//*[@id=\"form_report_id\"]/div[4]/div[1]/div[2]/div/div/ul/li[2]"));
        AirCraftTypeSelectOption.click();

        WebElement Immatriculation = driver.findElement(By.xpath("//*[@id=\"IMMAT\"]"));
        Immatriculation.click();

        WebElement ImmatriculationSelectOption = driver.findElement(By.xpath("//*[@id=\"form_report_id\"]/div[4]/div[1]/div[3]/div[1]/div[1]/ul[1]/li[6]"));
        ImmatriculationSelectOption.click();

        WebElement Date = driver.findElement(By.xpath("//*[@id=\"DATE\"]"));
        Date.click();

        WebElement DateSelectDate = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[4]/a[1]"));
        DateSelectDate.click();

        WebElement Commander = driver.findElement(By.xpath("//*[@id=\"chr_1_6\"]"));
        Commander.sendKeys("Commander Value");

        // Crew concerned by the discretion
        WebElement CrewConcernedByTheDiscretion = driver.findElement(By.xpath("//*[@id=\"txt_2_1\"]"));
        CrewConcernedByTheDiscretion.sendKeys("Crew concerned by the discretion. Nam mattis, ligula non dictum rutrum, ante felis ornare libero, sit amet blandit est tellus sit amet quam.");

        // Voyage details - Schedule (planned)
        WebElement PlaceInput = driver.findElement(By.xpath("//*[@id=\"chr_3_1\"]"));
        PlaceInput.sendKeys("Place Input Value");

        WebElement PlaceInputSecond = driver.findElement(By.xpath("//*[@id=\"chr_3_10\"]"));
        PlaceInputSecond.sendKeys("Place Input Second Value");

        WebElement UTCScheduleDP = driver.findElement(By.xpath("//*[@id=\"chr_3_2\"]"));
        UTCScheduleDP.sendKeys("1111");

        WebElement UTCScheduleFDP = driver.findElement(By.xpath("//*[@id=\"chr_3_5\"]"));
        UTCScheduleFDP.sendKeys("2222");

        WebElement UTCScheduleBlockOff = driver.findElement(By.xpath("//*[@id=\"chr_3_8\"]"));
        UTCScheduleBlockOff.sendKeys("1111");

        WebElement UTCScheduleBlockIn = driver.findElement(By.xpath("//*[@id=\"chr_3_11\"]"));
        UTCScheduleBlockIn.sendKeys("2222");

        // Voyage details - Max FDP
        WebElement MostRectMaxFdp = driver.findElement(By.xpath("//*[@id=\"max_fdp\"]"));
        MostRectMaxFdp.sendKeys("2222");

        WebElement DiscretionConcerns = driver.findElement(By.xpath("//*[@id=\"discretion\"]"));
        DiscretionConcerns.click();

        WebElement DiscretionConcernsSelectOption = driver.findElement(By.xpath("//*[@id=\"form_report_id\"]/div[6]/div[2]/div[1]/div[2]/div[1]/div[1]/ul[1]/li[2]"));
        DiscretionConcernsSelectOption.click();

        WebElement MaxFdpIs = driver.findElement(By.xpath("//*[@id=\"max_fdp_is\"]"));
        MaxFdpIs.click();

        WebElement MaxFdpIsSelectOption = driver.findElement(By.xpath("//*[@id=\"form_report_id\"]/div[6]/div[2]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[1]"));
        MaxFdpIsSelectOption.click();

        WebElement AccTimeZone = driver.findElement(By.xpath("//*[@id=\"acc_time_zone\"]"));
        AccTimeZone.click();

        WebElement AccTimeZoneSelectOption = driver.findElement(By.xpath("//*[@id=\"form_report_id\"]/div[6]/div[2]/div[2]/div[2]/div[1]/div[1]/ul[1]/li[2]"));
        AccTimeZoneSelectOption.click();

        // Voyage details - Actual
        WebElement StartDP = driver.findElement(By.xpath("//*[@id=\"chr_3_19\"]"));
        StartDP.sendKeys("1111");

        WebElement StartFDP = driver.findElement(By.xpath("//*[@id=\"chr_3_22\"]"));
        StartFDP.sendKeys("1111");

        WebElement BlockOff = driver.findElement(By.xpath("//*[@id=\"chr_3_25\"]"));
        BlockOff.sendKeys("1111");

        WebElement BlockIn = driver.findElement(By.xpath("//*[@id=\"chr_3_28\"]"));
        BlockIn.sendKeys("1111");

        WebElement ActualFdpDuration = driver.findElement(By.xpath("//*[@id=\"chr_3_37\"]"));
        ActualFdpDuration.sendKeys("0000");

        /*WebElement AmountCommanderDiscretionExercisedHours = driver.findElement(By.xpath("//*[@id=\"chr_3_40\"]"));
        AmountCommanderDiscretionExercisedHours.sendKeys("22");

        These two elements are filled when ActualFdpDuration is filled

        WebElement AmountCommanderDiscretionExercisedMinutes = driver.findElement(By.xpath("//*[@id=\"chr_3_41\"]"));
        AmountCommanderDiscretionExercisedMinutes.sendKeys("22");*/

        // Captain's report
        WebElement CaptainReport = driver.findElement(By.xpath("//*[@id=\"txt_4_1\"]"));
        CaptainReport.sendKeys("Captain's report. Nam mattis, ligula non dictum rutrum, ante felis ornare libero, sit amet blandit est tellus sit amet quam.");

        Reporter.addStepLog("Filling the form with data and an attached file");
    }

    @Then("^I post the form formportalkneasrfill")
    public void post_form_filling() throws IOException {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        System.out.println("Posting the form");

        // Send form
        WebElement SaveSend = driver.findElement(By.xpath("/html/body/app-root/ng-component/app-report-create/main/section/div/div/button[3]"));
        SaveSend.click();

        // Modale
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"confirmpresend\"]/div[1]/div[1]/div[3]/button[2]")));
        WebElement OkPreSend = driver.findElement(By.xpath("//*[@id=\"confirmpresend\"]/div[1]/div[1]/div[3]/button[2]"));
        OkPreSend.click();

        WebElement OkConfirm = driver.findElement(By.xpath("//*[@id=\"confirmsavesend\"]/div/div/div[3]/button"));
        wait.until(ExpectedConditions.visibilityOf(OkConfirm));
        wait.until(ExpectedConditions.elementToBeClickable(OkConfirm));
        OkConfirm.click();

        Reporter.addStepLog("Posting the form");
    }
}
