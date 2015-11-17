package steps;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.BrowserManager;
import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import ui.pages.*;

/**
 * Created by jorgeavila on 11/12/2015.
 */
public class DirectMessagesSteps {

    BrowserManager manager = BrowserManager.getInstance();
    WebDriver driver;

    private ContainerPage containerPage;

    private LoginPage loginpage;

    private String teamName;
    private String memberName;
    private String messageToDeliver;
    private String currentCompany;

    @Before
    public void setUp(){

        loginpage = new LoginPage();

    }

    @Given("^a team Created called \"([^\"]*)\"$")
    public void a_team_Created_called(String name) throws Throwable {
        teamName = name;
        containerPage.getLeftTeamsPanel()
                .clickCreateNewTeam()
                .createTeam(teamName);
    }

    @And("^the Team has a member called \"([^\"]*)\"$")
    public void the_Team_has_a_member_called(String name) throws Throwable {
        memberName = name;
        containerPage.getLeftMembersPanel()
                .clickCreateNewMember()
                .addNewMemberShip(name);
    }


    @Given("^I enter to a Team created$")
    public void I_enter_to_a_Team_created() throws Throwable {
        containerPage.getLeftTeamsPanel()
                .clickSelectATeam(teamName);
    }

    @And("^I select a member of that team$")
    public void I_select_a_member_of_that_team() throws Throwable {
        containerPage.getLeftMembersPanel()
                .clickSelectAMember(teamName);
    }

    @When("^I send a direct message to that team member as \"([^\"]*)\"$")
    public void I_send_a_direct_message_to_that_team_member_as(String message) throws Throwable {
        messageToDeliver = message;
        containerPage.getPostComponentPage()
                .typeTextArea(messageToDeliver)
                .clickSend();
    }


    @Then("^the destination member should has a notification when this do login$")
    public void the_destination_member_should_has_a_notification_when_this_do_login() throws Throwable {
        boolean existsNotification = containerPage.getPostComponentPage()
                .logout()
                .typeUserName("jorge.avila@fundacion-jala.org")
                .typeUserPassword("Control123")
                .clickLoginButtonSuccessful()
                .getLeftMembersPanel()
                .existsNotification();
        Assert.assertTrue(existsNotification);
    }

    @And("^the message must be the same that I sent$")
    public void the_message_must_be_the_same_that_I_sent() throws Throwable {
        boolean existsMessage = containerPage.existsPost(messageToDeliver);
        Assert.assertTrue(existsMessage);
    }
}
