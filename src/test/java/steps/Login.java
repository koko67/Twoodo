package steps;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.BrowserManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import ui.pages.ContainerPage;
import ui.pages.LoginPage;

/**
 * Created by jorgeavila on 11/10/2015.
 */
public class Login {

    BrowserManager manager = BrowserManager.getInstance();
    WebDriver driver;

    private LoginPage loginPage;
    private ContainerPage containerPage;

    @Before
    public void setUp(){
        loginPage = new LoginPage();
    }


    @Given("^I navigate to Login Page$")
    public void goToLoginPage() {
        driver = manager.getDriver();
        driver.get("https://www.twoodo.com/login");
    }

    @When("^I Login as \"([^\"]*)\" with Password \"([^\"]*)\"$")
    public void login(String user, String password) {
        System.out.print("######### ");
        System.out.print(loginPage == null);
        System.out.print(loginPage);
        containerPage =  loginPage.typeUserName(user)
                    .typeUserPassword(password)
                    .clickLoginButtonSuccessful();
    }


    @Then("^I should login to$")
    public void I_should_login_to() throws Throwable {
        Assert.assertTrue(containerPage.existsUserName("@jorge"));
    }
}
