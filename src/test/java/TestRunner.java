import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(
        //features = {"src/test/resources"},
        //glue = {"com.cucumber.stepdefinitions"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:report/extent-report.html"},
        tags = {"~@successfulportallogin, ~@successfulcubelogin"}
)

public class TestRunner {
    @AfterClass
    public static void setup() {
        Reporter.loadXMLConfig(new File("./config/extent-config.xml"));
        Reporter.setSystemInfo("User", System.getProperty("user.name"));
        Reporter.setSystemInfo("OS", System.getProperty("os.name"));
        Reporter.setSystemInfo("Java", System.getProperty("java.version"));
        Reporter.setSystemInfo("Apache Maven", "3.6.0");
        Reporter.setTestRunnerOutput("Before yesterday, Catherine was 17 years old. Next year, she will be 20 years old. How can it be possible ?");
    }
}
