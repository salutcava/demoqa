import cucumber.api.java.en.Given;
import java.io.IOException;

public class LoginIn extends Login {

    @Given("^I am logging in to the cube")
    public void i_am_logging_in_to_the_cube() throws IOException {
        Login.login_cube();
    }

    @Given("^I am logging in to the admin")
    public void i_am_logging_in_to_the_admin() throws IOException {
        Login.login_admin();
    }

    @Given("^I am logging in to the portal")
    public void i_am_logging_in_to_the_portal() throws IOException {
        Login.login_portal();
    }

    @Given("^SafetyCube QA Demo")
    public void qa_demo() throws IOException {
        Login.qademo();
    }
}
