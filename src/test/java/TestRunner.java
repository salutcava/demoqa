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
        Reporter.loadXMLConfig(new File("config/extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", System.getProperty("os.name"));
        Reporter.setTestRunnerOutput("Sample test runner output message");
    }

}
