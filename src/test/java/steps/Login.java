package steps;

import common.CommonMethods;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.BrowserManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import ui.PageTransporter;
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

    @When("^I am logged on the page with user \"([^\"]*)\" and Password \"([^\"]*)\"$")
    public void login(String user, String password) {
        if(!CommonMethods.isAccountLogged()){
            PageTransporter.getInstance().goToLoginPage();
            loginSuccessful(user, password);
        } else {
            System.out.println("already in homepage");
        }
    }

    @Given("^I navigate to Login Page$")
    public void goToLoginPage() {
        if(!CommonMethods.isBrowserInLoginPage()){
            PageTransporter.getInstance().goToLoginPage();
        } else {
            System.out.println("currently in login page");
        }
    }

    @When("^I Login as \"([^\"]*)\" with Password \"([^\"]*)\"$")
    public void loginSuccessful(String userEmail, String password) {
        containerPage = loginPage.typeUserName(userEmail)
                .typeUserPassword(password)
                .clickLoginButtonSuccessful();
    }

    @Then("^I should login to$")
    public void I_should_login_to() throws Throwable {
        Assert.assertTrue(containerPage.existsUserName("@jorge"));
    }
}
