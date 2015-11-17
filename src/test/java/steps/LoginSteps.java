//package steps;
//
//import common.CommonMethods;
//import cucumber.api.PendingException;
//import cucumber.api.java.After;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//
//import cucumber.api.j
//
//import static org.testng.Assert.assertTrue;
//
///**
// * Created by silvia valencia on 11/9/2015.
// */
//public class LoginSteps {
//    private LoginPage loginPage;
//    private MainPage mainPage;
//
//    @Given("^I navigate to Login page$")
//    public void navigateLoginPage() {
//
//    }
//
//    @When("^I login as \"(.*?)\" with password \"(.*?)\"$")
//        public void login(String userName, String userPassword){
//        mainPage = loginPage.loginSuccessful(username, password);
//    }
//
//    @Then("^I should login successfully$")
//    public void verifyMainPageIsDisplayed() {
//        assertTrue(mainPage.isUserNameDisplayed(), "User name displayed");
//    }
//
//    //****************************************************************
//    //Hooks for @Login scenarios
//    //****************************************************************
//    @After(value = "@Login", order = 999)
//    public void afterLoginScenario() {
//        CommonMethods.logOut();
//    }
//}
