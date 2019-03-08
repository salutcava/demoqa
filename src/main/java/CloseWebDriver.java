import cucumber.api.java.en.And;

public class CloseWebDriver extends Login{
    @And("^I close the webdriver$")
    public void i_close_the_webdriver() {
        App.close(driver);
    }
}