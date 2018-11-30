import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

public class FORM_KNE_ASR {
    public static WebDriver driver;

//    @Before
//    public static void kne_form_Before(Scenario scenario) {
//    }

    @Given("^the web browser is at the KNE_ASR form$")
    public void open_form() {
        System.out.println("Open the form");
        //driver.findElement(By.xpath("//*[@id=\"form_52\"]")).click();
    }

    @And("^the user fills the form$")
    public void fill_form() {
        System.out.println("Fill the form");
    }

    @Then("^the user posts the form$")
    public void post_form() {
        System.out.println("Sendind the form");
    }

}
