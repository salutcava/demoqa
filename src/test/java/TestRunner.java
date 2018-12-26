import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    format = {"pretty"}
    //glue = {"helpers","stepDefinitions"}
    //format = {"pretty","html:report/html","json:report/json","usage:report/usage","junit:report/junit"}
)

public class TestRunner {
}